package com.ofw.ofw.service.auth;

import com.ofw.ofw.entity.auth.AuthBrandCache;
import com.ofw.ofw.entity.auth.AuthBrandCacheRepository;
import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.entity.user.User;
import com.ofw.ofw.entity.user.UserRepository;
import com.ofw.ofw.exception.type.BrandNotFoundException;
import com.ofw.ofw.exception.type.UserNotFoundException;
import com.ofw.ofw.payload.auth.request.GoogleOauthSignUpRequest;
import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.auth.request.GoogleOauthLogInRequest;
import com.ofw.ofw.payload.auth.request.SignInBrandRequest;
import com.ofw.ofw.payload.auth.response.LinkResponse;
import com.ofw.ofw.payload.auth.response.NotFoundUserResponse;
import com.ofw.ofw.payload.auth.response.TokenResponse;
import com.ofw.ofw.security.jwt.JwtTokenProvider;
import com.ofw.ofw.util.api.client.google.GoogleAuthClient;
import com.ofw.ofw.util.api.client.google.GoogleInfoClient;
import com.ofw.ofw.util.api.dto.google.request.GoogleTokenRequest;
import com.ofw.ofw.util.api.dto.google.response.GoogleInfoResponse;
import com.ofw.ofw.util.api.dto.google.response.GoogleTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
    private static final String GOOGLE_LOGIN_LINK = "https://accounts.google.com/o/oauth2/v2/auth";

    @Value("${oauth.google.client_id}")
    private String googleClientId;

    @Value("${oauth.google.client_secret}")
    private String googleClientSecret;

    @Value("${oauth.google.redirect_uri}")
    private String googleRedirectUri;

    private final GoogleAuthClient googleAuthClient;
    private final GoogleInfoClient googleInfoClient;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthBrandCacheRepository repository;
    private final BrandRepository brandRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LinkResponse getGoogleLink() {
        return new LinkResponse(GOOGLE_LOGIN_LINK +
                "?client_id=" + googleClientId +
                "&scope=https://www.googleapis.com/auth/userinfo.email%20https://www.googleapis.com/auth/userinfo.profile" +
                "&response_type=code" +
                "&access_type=offline" +
                "&redirect_uri=" + URLEncoder.encode(googleRedirectUri, StandardCharsets.UTF_8)
        );
    }

    @Override
    public Object googleOauthLogIn(GoogleOauthLogInRequest request){
        GoogleTokenResponse response = googleAuthClient.getTokenByCode(
                new GoogleTokenRequest(URLDecoder.decode(request.getCode(), StandardCharsets.UTF_8),
                        googleClientId, googleClientSecret, googleRedirectUri, "authorization_code")
        );

        GoogleInfoResponse info = googleInfoClient.getInfo("Bearer " + response.getAccess_token());
        String email = info.getEmail();

        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        String userId = user.getId().toString();

        if(userRepository.findByEmail(email).isEmpty()) {
            return NotFoundUserResponse.builder()
                    .isFresh(true)
                    .email(email)
                    .build();
        }

        return getToken(userId, request.getAud());
    }

    @Override
    public TokenResponse googleOauthSignUp(GoogleOauthSignUpRequest request){
        User user = userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .name(request.getName())
                        .build()
        );
        String userId = user.getId().toString();

        return getToken(userId, request.getAud());
    }

    private TokenResponse getToken(String email, String aud) {
        String accessToken = jwtTokenProvider.generateAccessToken(email, aud);

        return new TokenResponse(accessToken);
    }

    @Override
    public void requestBrandRegistering(AuthRequestBrandRegisteringRequest request) {
        AuthBrandCache brandCache = AuthBrandCache.builder()
                .email(request.getEmail())
                .profileFile(request.getProfileUrl())
                .coverFile(request.getCoverUrl())
                .password(request.getPassword())
                .name(request.getName())
                .url(request.getUrl())
                .description(request.getDescription())
                .build();

        repository.save(brandCache);
    }

    @Override
    public TokenResponse brandSignIn(SignInBrandRequest request){
        Brand brand = verifyBrand(request);
        TokenResponse response = generateTokenResponse(brand);

        return new TokenResponse(response.toString());
    }

    public Brand verifyBrand(SignInBrandRequest request){
        return brandRepository.findByEmail(request.getEmail())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .orElseThrow(BrandNotFoundException::new);
    }

    public TokenResponse generateTokenResponse(Brand brand){
        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(brand.getEmail(), "brand"))
                .build();
    }
}

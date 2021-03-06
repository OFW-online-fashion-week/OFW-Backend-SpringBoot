package com.ofw.ofw.service.auth;

import com.ofw.ofw.entity.auth.AuthBrandCache;
import com.ofw.ofw.entity.auth.AuthBrandCacheRepository;
import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.entity.user.User;
import com.ofw.ofw.entity.user.UserRepository;
import com.ofw.ofw.exception.type.BrandNotFoundException;
import com.ofw.ofw.exception.type.PasswordNotFoundException;
import com.ofw.ofw.exception.type.UserNotFoundException;
import com.ofw.ofw.payload.auth.request.GoogleOauthSignUpRequest;
import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.auth.request.GoogleOauthLogInRequest;
import com.ofw.ofw.payload.auth.request.SignInBrandRequest;
import com.ofw.ofw.payload.auth.response.BrandSignInResponse;
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

        if(userRepository.findByEmail(email).isEmpty()) {
            return NotFoundUserResponse.builder()
                    .isFresh(true)
                    .email(email)
                    .build();
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        Long userId = user.getId();

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
        Long userId = user.getId();

        return getToken(userId, request.getAud());
    }

    private TokenResponse getToken(Long id, String aud) {
        String accessToken = jwtTokenProvider.generateAccessToken(id.toString(), aud);

        return new TokenResponse(accessToken, id);
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
    public Object brandSignIn(SignInBrandRequest request){
        Brand brand = verifyBrand(request);
        TokenResponse tokenResponse = generateTokenResponse(brand);

        Brand getBrand = brandRepository.findByEmail(request.getEmail())
                .orElseThrow(BrandNotFoundException::new);

        String brandId = getBrand.getId().toString();

        return BrandSignInResponse.builder()
                .accessToken(tokenResponse.getAccessToken())
                .id(brandId)
                .aud("brand")
                .build();
    }

    public Brand verifyBrand(SignInBrandRequest request){
        Brand brand = brandRepository.findByEmail(request.getEmail())
                .orElseThrow(BrandNotFoundException::new);

        Boolean passwordMatches = brand.getPassword().equals(request.getPassword());
        if(!passwordMatches) {
            throw new PasswordNotFoundException();
        } else{
            return brand;
        }
    }

    public TokenResponse generateTokenResponse(Brand brand){
        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(brand.getId().toString(), "brand"))
                .build();
    }
}

package com.ofw.ofw.service.auth;

import com.ofw.ofw.entity.auth.AuthBrandCache;
import com.ofw.ofw.entity.auth.AuthBrandCacheRepository;
import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.entity.user.User;
import com.ofw.ofw.entity.user.UserRepository;
import com.ofw.ofw.exception.type.BrandNotFoundException;
import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.auth.request.GetGoogleTokenByCodeRequest;
import com.ofw.ofw.payload.auth.request.SignInBrandRequest;
import com.ofw.ofw.payload.auth.response.LinkResponse;
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
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

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
    public TokenResponse getGoogleTokenByCode(GetGoogleTokenByCodeRequest request) {
        GoogleTokenResponse response = googleAuthClient.getTokenByCode(
                new GoogleTokenRequest(URLDecoder.decode(request.getCode(), StandardCharsets.UTF_8),
                        googleClientId, googleClientSecret, googleRedirectUri, "authorization_code")
        );

        GoogleInfoResponse info = googleInfoClient.getInfo("Bearer" + response.getAccess_token());
        String email = info.getEmail();

        if(userRepository.findByEmail(email).isEmpty()) {
            userRepository.save(
                User.builder()
                        .email(email)
                        .name(request.getName())
                        .build()
            );
        }

        return getToken(email, request.getAud());
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
                .orElseThrow(BrandNotFoundException::new);
    }

    public TokenResponse generateTokenResponse(Brand brand){
        return TokenResponse.builder()
                .accessToken(jwtTokenProvider.generateAccessToken(brand.getEmail(), "Brand"))
                .build();
    }


}

package com.ofw.ofw.service.auth;

import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.auth.request.GetGoogleTokenByCodeRequest;
import com.ofw.ofw.payload.auth.request.SignInBrandRequest;
import com.ofw.ofw.payload.auth.response.LinkResponse;
import com.ofw.ofw.payload.auth.response.TokenResponse;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthService {
    void requestBrandRegistering(AuthRequestBrandRegisteringRequest request);
    LinkResponse getGoogleLink();
    TokenResponse getGoogleTokenByCode(GetGoogleTokenByCodeRequest request);
    TokenResponse brandSignIn(SignInBrandRequest request);
}

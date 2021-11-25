package com.ofw.ofw.service.auth;

import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.auth.request.GetGoogleTokenByCodeRequest;
import com.ofw.ofw.payload.auth.response.LinkResponse;
import com.ofw.ofw.payload.auth.response.TokenResponse;

public interface AuthService {
    void requestBrandRegistering(AuthRequestBrandRegisteringRequest request);

    LinkResponse getGoogleLink();
    TokenResponse getGoogleTokenByCode(GetGoogleTokenByCodeRequest request);
}

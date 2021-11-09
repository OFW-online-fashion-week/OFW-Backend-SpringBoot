package com.ofw.ofw.service.auth;

import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;

public interface AuthService {
    void requestBrandRegistering(AuthRequestBrandRegisteringRequest request);
}

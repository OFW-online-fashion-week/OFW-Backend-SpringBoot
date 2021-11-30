package com.ofw.ofw.service.auth;

import com.ofw.ofw.payload.auth.request.*;
import com.ofw.ofw.payload.auth.response.LinkResponse;
import com.ofw.ofw.payload.auth.response.TokenResponse;

public interface AuthService {
    void requestBrandRegistering(AuthRequestBrandRegisteringRequest request);
    LinkResponse getGoogleLink();
    TokenResponse googleOauthSignUp(GoogleOauthSignUpRequest request);
    Object googleOauthLogIn(GoogleOauthLogInRequest request);
    TokenResponse brandSignIn(SignInBrandRequest request);
}

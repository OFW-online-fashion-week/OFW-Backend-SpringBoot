package com.ofw.ofw.controller;

import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.auth.request.GetGoogleTokenByCodeRequest;
import com.ofw.ofw.payload.auth.request.GoogleOauthSignUpRequest;
import com.ofw.ofw.payload.auth.request.SignInBrandRequest;
import com.ofw.ofw.payload.auth.response.LinkResponse;
import com.ofw.ofw.payload.auth.response.TokenResponse;
import com.ofw.ofw.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private  final AuthService authService;

    @GetMapping("/google")
    public ResponseEntity<LinkResponse> getGoogleLink() {
        return new ResponseEntity<>(authService.getGoogleLink(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<TokenResponse> getGoogleTokenByCode(@RequestBody GoogleOauthSignUpRequest request) {
        return new ResponseEntity<>(authService.googleOauthSignUp(request), HttpStatus.OK);
    }

    @PostMapping("/brand/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String requestBrandRegistering(@RequestBody AuthRequestBrandRegisteringRequest request) {
        authService.requestBrandRegistering(request);
        return "success";
    }

    @PostMapping("/brand/login")
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse brandSignIn(@RequestBody SignInBrandRequest request){
        return authService.brandSignIn(request);
    }
}

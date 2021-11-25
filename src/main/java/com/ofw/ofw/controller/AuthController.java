package com.ofw.ofw.controller;

import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.auth.request.GetGoogleTokenByCodeRequest;
import com.ofw.ofw.payload.auth.response.LinkResponse;
import com.ofw.ofw.payload.auth.response.TokenResponse;
import com.ofw.ofw.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private  final AuthService authService;

    @GetMapping("auth/google")
    public ResponseEntity<LinkResponse> getGoogleLink() {
        return new ResponseEntity<>(authService.getGoogleLink(), HttpStatus.OK);
    }

    @PostMapping("auth/google")
    public ResponseEntity<TokenResponse> getGoogleTokenByCode(@RequestBody GetGoogleTokenByCodeRequest request) {
        return new ResponseEntity<>(authService.getGoogleTokenByCode(request), HttpStatus.OK);
    }

    @PostMapping("/brand/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String requestBrandRegistering(@RequestBody AuthRequestBrandRegisteringRequest request) {
        authService.requestBrandRegistering(request);
        return "success";
    }
}

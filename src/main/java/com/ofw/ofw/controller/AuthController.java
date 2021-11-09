package com.ofw.ofw.controller;

import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.response.SessionUser;
import com.ofw.ofw.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final HttpSession httpSession;
    private  final AuthService authService;

    @GetMapping
    public String index() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return user.getEmail();
    }

    @PostMapping("/brand/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public String requestBrandRegistering(@RequestBody AuthRequestBrandRegisteringRequest request) {
        authService.requestBrandRegistering(request);
        return "success";
    }
}

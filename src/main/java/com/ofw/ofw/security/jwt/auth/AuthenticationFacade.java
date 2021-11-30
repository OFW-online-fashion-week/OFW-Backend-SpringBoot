package com.ofw.ofw.security.jwt.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public Long getSub() {
        return Long.parseLong(this.getAuthentication().getName() == null ? "" : this.getAuthentication().getName());
    }
}

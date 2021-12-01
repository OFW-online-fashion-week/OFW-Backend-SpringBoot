package com.ofw.ofw.security.facade;

import com.ofw.ofw.exception.type.CredentialsNotFoundException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserFacade {
    public static String getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication.getPrincipal() == null)
            throw new CredentialsNotFoundException();

        return authentication.getName();
    }
}

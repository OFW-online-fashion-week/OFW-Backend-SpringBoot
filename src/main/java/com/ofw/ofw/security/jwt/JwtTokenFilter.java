package com.ofw.ofw.security.jwt;

import com.ofw.ofw.security.jwt.auth.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtTokenProvider.resolveToken(request);


        if (token != null && jwtTokenProvider.validateToken(token)) {
            String tokenAud = jwtTokenProvider.getTokenAud(token);
            Authentication authentication;
            if(tokenAud.equals("brand")) {
                authentication = jwtTokenProvider.brandAuthentication(token);
            } else {
                authentication = jwtTokenProvider.userAuthentication(token);
            }

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}

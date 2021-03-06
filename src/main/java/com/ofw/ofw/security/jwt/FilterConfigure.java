package com.ofw.ofw.security.jwt;

import com.ofw.ofw.exception.ExceptionHandlerFilter;
import com.ofw.ofw.security.jwt.JwtTokenFilter;
import com.ofw.ofw.security.jwt.JwtTokenProvider;
import com.ofw.ofw.security.logging.RequestLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class FilterConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;
    private final ExceptionHandlerFilter exceptionHandlerFilter;
    private final RequestLogger requestLogger;

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        JwtTokenFilter filter = new JwtTokenFilter(jwtTokenProvider);
        builder.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        builder.addFilterBefore(exceptionHandlerFilter, JwtTokenFilter.class);
        builder.addFilterBefore(requestLogger, ExceptionHandlerFilter.class);
    }
}

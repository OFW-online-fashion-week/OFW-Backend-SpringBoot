package com.ofw.ofw.service.auth;

import com.ofw.ofw.entity.auth.AuthBrandCache;
import com.ofw.ofw.entity.auth.AuthBrandCacheRepository;
import com.ofw.ofw.payload.request.AuthRequestBrandRegisteringRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
    private final AuthBrandCacheRepository repository;

    @Override
    public void requestBrandRegistering(AuthRequestBrandRegisteringRequest request) {
        AuthBrandCache brandCache = AuthBrandCache.builder()
                .email(request.getEmail())
                .profileFile(request.getProfileUrl())
                .coverFile(request.getCoverUrl())
                .password(request.getPassword())
                .name(request.getName())
                .url(request.getUrl())
                .description(request.getDescription())
                .build();

        repository.save(brandCache);
    }
}

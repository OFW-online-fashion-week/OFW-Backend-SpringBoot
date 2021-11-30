package com.ofw.ofw.security.jwt.auth;

import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.entity.user.UserRepository;
import com.ofw.ofw.exception.type.BrandNotFoundException;
import com.ofw.ofw.exception.type.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandDetailsService implements UserDetailsService {

    private final BrandRepository brandRepository;

    @Override
    public BrandDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return brandRepository.findByEmail(email)
                .map(BrandDetails::new)
                .orElseThrow(BrandNotFoundException::new);
    }
}

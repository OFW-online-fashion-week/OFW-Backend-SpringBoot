package com.ofw.ofw.security.jwt.auth;

import com.ofw.ofw.entity.user.UserRepository;
import com.ofw.ofw.exception.type.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Long userId= Long.parseLong(id);

        return userRepository.findById(userId)
                .map(AuthDetails::new)
                .orElseThrow(UserNotFoundException::new);
    }
}

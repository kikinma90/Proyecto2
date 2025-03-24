package com.example.auth_service_api.commons.service.impl;

import com.example.auth_service_api.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDatailsImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDatailsImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("UserDetailsService user not found"));
    }
}

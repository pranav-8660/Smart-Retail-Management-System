package com.pranavv51.userservice.secure_user_management_service.service;

import com.pranavv51.userservice.secure_user_management_service.model.User;
import com.pranavv51.userservice.secure_user_management_service.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow( () -> new UsernameNotFoundException("User Not Found"));

        return org.springframework.security.core.userdetails.User.withUsername(username).password(user.getPassword()).roles(user.getRole()).build();

    }
}

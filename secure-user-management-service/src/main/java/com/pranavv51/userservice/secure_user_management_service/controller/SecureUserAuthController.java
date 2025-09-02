package com.pranavv51.userservice.secure_user_management_service.controller;


import com.pranavv51.userservice.secure_user_management_service.DTO.AuthRequest;
import com.pranavv51.userservice.secure_user_management_service.model.User;
import com.pranavv51.userservice.secure_user_management_service.repository.UserRepository;
import com.pranavv51.userservice.secure_user_management_service.security.JwtUtil;
import com.pranavv51.userservice.secure_user_management_service.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class SecureUserAuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserRepository userRepository;

    public SecureUserAuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailsService customUserDetailsService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customUserDetailsService = customUserDetailsService;
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword())
        );

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newuser){
        newuser.setPassword(new BCryptPasswordEncoder().encode(newuser.getPassword()));
        userRepository.save(newuser);
        newuser.setPassword("encodedpassword");
        return ResponseEntity.ok(newuser);
    }



}

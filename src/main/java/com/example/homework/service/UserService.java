package com.example.homework.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.homework.dto.request.LoginRequest;
import com.example.homework.dto.request.RegisterRequest;
import com.example.homework.dto.response.UserDto;
import com.example.homework.entity.User;
import com.example.homework.exception.CustomDataNotFoundException;
import com.example.homework.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public UserDto login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserName(),
                        request.getPassword()
                )
        );

        User user = userRepository
                .findByUserName(request.getUserName())
                .orElseThrow(() ->
                        new CustomDataNotFoundException("User with email [" + request.getUserName() + "] not found")
                );

        return returnUserResponse(user);
    }

    public UserDto register(RegisterRequest request) {
        if (userRepository.existsByUserName(request.getUserName()))
            throw new RuntimeException("User with email [" + request.getUserName() + "] already exists.");

        User user = userRepository.save(buildUser(request));
        return returnUserResponse(user);
    }


    private UserDto returnUserResponse(User user) {
        return UserDto.builder()
                .userName(user.getUserName())
                .build();
    }
    private User buildUser(RegisterRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return user;
    }

}

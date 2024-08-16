package com.cybercarjava.domain.user.service;

import com.cybercarjava.domain.user.dto.LoginRequest;
import com.cybercarjava.domain.user.dto.SignUpRequest;
import com.cybercarjava.domain.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Override
    public void signup(SignUpRequest req) {

    }

    @Override
    public void login(LoginRequest req, HttpServletResponse res) {

    }
}

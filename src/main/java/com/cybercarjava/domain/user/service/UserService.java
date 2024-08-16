package com.cybercarjava.domain.user.service;

import com.cybercarjava.domain.user.dto.LoginRequest;
import com.cybercarjava.domain.user.dto.SignUpRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface UserService{

    void signup(SignUpRequest req);

    void login(LoginRequest req, HttpServletResponse res);
}

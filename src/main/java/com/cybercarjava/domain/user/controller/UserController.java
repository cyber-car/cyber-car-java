package com.cybercarjava.domain.user.controller;

import com.cybercarjava.domain.user.dto.LoginRequest;
import com.cybercarjava.domain.user.dto.SignUpRequest;
import com.cybercarjava.domain.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(
            @RequestBody SignUpRequest req) {
        userService.signup(req);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody LoginRequest req,
            HttpServletResponse res) {
        userService.login(req, res);
        return ResponseEntity.status(HttpStatus.OK).body("로그인 성공");
    }
}

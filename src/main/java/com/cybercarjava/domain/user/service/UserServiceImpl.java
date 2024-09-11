package com.cybercarjava.domain.user.service;

import com.cybercarjava.domain.user.dto.LoginRequest;
import com.cybercarjava.domain.user.dto.SignUpRequest;
import com.cybercarjava.domain.user.model.User;
import com.cybercarjava.domain.user.repository.UserRepository;
import com.cybercarjava.global.jwt.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public void signup(SignUpRequest req) {
        String number = req.number();
        String nickname = req.nickname();
        String password = req.password();
        String company = req.company();

        if(userRepository.findByNumber(number).isPresent()){
            throw new RuntimeException();
        }

        User user = User.builder()
                .number(number)
                .company(company)
                .nickname(nickname)
                .password(password)
                .build();

        userRepository.save(user);
    }

    @Override
    public void login(LoginRequest req, HttpServletResponse res) {
        String number = req.number();
        String password = req.password();

        User user = userRepository.findByNumber(number).orElseThrow(RuntimeException::new);

        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException();
        }

        jwtUtil.addJwtToCookie(jwtUtil.createToken(req.number()),res);
    }
}

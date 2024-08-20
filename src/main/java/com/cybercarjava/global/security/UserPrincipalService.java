package com.cybercarjava.global.security;

import com.cybercarjava.domain.user.model.User;
import com.cybercarjava.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserPrincipalService {
    private final UserRepository userRepository;

    public UserPrincipalImpl getUserPrincipal(String number){
        User user = userRepository.findByNumber(number).orElseThrow(() -> new UsernameNotFoundException(number + "발견되지 않습니다."));
        return new UserPrincipalImpl(user);
    }
}

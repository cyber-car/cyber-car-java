package com.cybercarjava.global.jwt;

import com.cybercarjava.global.security.UserPrincipalImpl;
import com.cybercarjava.global.security.UserPrincipalService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UserPrincipalService userPrincipalService;
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtUtil.getTokenFromReq(req);

        if (Objects.nonNull(token)) {
            if (jwtUtil.validateToken(token)) {
                Claims info = jwtUtil.getUserInfoFromToken(token);
                String number = info.getSubject();
                SecurityContext context = SecurityContextHolder.createEmptyContext();
                UserPrincipalImpl userPrincipal = userPrincipalService.getUserPrincipal(number);
                Authentication authentication = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
                context.setAuthentication(authentication);
                SecurityContextHolder.setContext(context);
            } else {
                ResponseEntity<String> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("유효하지 않는 토큰입니다");
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                res.setContentType("application/json; charset=UTF-8");
                res.getWriter().write(objectMapper.writeValueAsString(response));
                return;
            }
        }
        filterChain.doFilter(req, res);
    }
}

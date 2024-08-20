package com.cybercarjava.global.jwt;

import io.jsonwebtoken.security.SecurityException;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtUtil {

    public static final String AUTHORIZATION = "Authorization";

    public static final String BEARER = "Bearer ";

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expired.period}")
    private String expiredPeriod;


    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    private Key key;

    @PostConstruct
    public void init() {
        byte [] bytes = Base64.getDecoder().decode(secretKey);
        key = Keys.hmacShaKeyFor(bytes);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch (SecurityException | MalformedJwtException e) {
            log.error("유효하지 않는 JWT 시그니처");
        } catch (ExpiredJwtException e){
            log.error("만료된 JWT 토큰");
        } catch (UnsupportedJwtException e){
            log.error("지원하지 않는 JWT 토큰");
        } catch (IllegalArgumentException e){
            log.error("비워있는 JWT claims");
        }
        return false;
    }

    public Claims getUserInfoFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public String createToken(String number){
        Date date = new Date();

        return BEARER +
                Jwts.builder()
                    .setSubject(number)
                    .setExpiration(new Date(date.getTime() + Long.parseLong(expiredPeriod)))
                    .setIssuedAt(date)
                    .signWith(key, signatureAlgorithm)
                    .compact();
    }

    public void addJwtToCookie(String token, HttpServletResponse res){
        token = URLEncoder.encode(token, StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20");

        Cookie cookie = new Cookie(AUTHORIZATION, token);
        cookie.setPath("/");
        cookie.setMaxAge(Integer.parseInt(expiredPeriod));

        res.addCookie(cookie);
    }

    public String getTokenFromReq(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(AUTHORIZATION)){
                    return URLDecoder.decode(cookie.getValue().replaceAll("Bearea%20",""),
                            StandardCharsets.UTF_8);
                }
            }
        }
        return null;
    }


}

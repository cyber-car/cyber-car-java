package com.cybercarjava.domain.user.dto;

public record LoginRequest(
        String number,
        String password
) {
}

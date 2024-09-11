package com.cybercarjava.domain.customer.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record CustomerResponse(
        String carNumber,
        String name,
        String carModel,
        String pinNumber,
        String phoneNumber,
        LocalDateTime createdAt
) {
}

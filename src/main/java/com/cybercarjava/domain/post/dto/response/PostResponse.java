package com.cybercarjava.domain.post.dto.response;

import java.time.LocalDateTime;

public record PostResponse(
        String content,

        String partsPrice,

        String royalty,

        int quantity,

        String mileage,

        String engineer,

        LocalDateTime createdAt
) {
}

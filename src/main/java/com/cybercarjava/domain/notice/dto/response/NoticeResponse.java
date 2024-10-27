package com.cybercarjava.domain.notice.dto.response;

import lombok.Builder;

@Builder
public record NoticeResponse(
        String title,

        String content
) {
}

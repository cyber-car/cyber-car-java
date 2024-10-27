package com.cybercarjava.domain.notice.controller;

import com.cybercarjava.domain.notice.dto.response.NoticeResponse;
import com.cybercarjava.domain.notice.service.NoticeService;
import com.cybercarjava.domain.post.dto.response.PostResponse;
import com.cybercarjava.global.security.UserPrincipalImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notices")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @Operation(summary = "공지 전체 조회하기")
    @GetMapping
    public ResponseEntity<List<NoticeResponse>> getListNotice(
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(noticeService.getListNotice(userPrincipal.getUser()));
    }

    @Operation(summary = "공지 단건 조회하기")
    @GetMapping("/{noticeId}")
    public ResponseEntity<NoticeResponse> getNotice(
            @PathVariable Long noticeId,
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(noticeService.getNotice(userPrincipal.getUser(), noticeId));
    }
}

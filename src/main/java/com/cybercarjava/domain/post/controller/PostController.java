package com.cybercarjava.domain.post.controller;

import com.cybercarjava.domain.post.dto.request.PostRequest;
import com.cybercarjava.domain.post.dto.response.PostResponse;
import com.cybercarjava.domain.post.model.PartGrade;
import com.cybercarjava.domain.post.model.PostStatus;
import com.cybercarjava.domain.post.service.PostService;
import com.cybercarjava.global.security.UserPrincipalImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @Operation(summary = " 게시물 등록하기")
    @PostMapping
    public ResponseEntity<String> createPost(
            @RequestBody PostRequest req,
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal,
            @RequestParam PostStatus postStatus,
            @RequestParam PartGrade partGrade
    ) {
        postService.createPost(req, userPrincipal.getUser(), partGrade, postStatus);
        return ResponseEntity.status(HttpStatus.CREATED).body("고객 정보 등록");
    }

    @Operation(summary = "게시물 전체 조회하기")
    @GetMapping
    public ResponseEntity<List<PostResponse>> getListPost(
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPost(userPrincipal.getUser()));
    }

    @Operation(summary = "게시물 수정하기")
    @PatchMapping("/{postId}")
    public ResponseEntity<String> updateCustomer(
            @PathVariable(name = "postId") Long postId,
            @RequestBody PostRequest req,
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal,
            @RequestParam PostStatus postStatus,
            @RequestParam PartGrade partGrade
    ) {
        postService.updatePost(req, userPrincipal.getUser(), postId, partGrade, postStatus);
        return ResponseEntity.status(HttpStatus.OK).body("게시물 수정");
    }

    @Operation(summary = "게시물 삭제하기")
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deleteCustomer(
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal,
            @PathVariable(name = "postId") Long postId
    ) {
        postService.deletePost(postId, userPrincipal.getUser());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("게시물 삭제");
    }
}

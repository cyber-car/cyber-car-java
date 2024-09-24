package com.cybercarjava.domain.post.service;

import com.cybercarjava.domain.post.dto.request.PostRequest;
import com.cybercarjava.domain.post.dto.response.PostResponse;
import com.cybercarjava.domain.post.model.PartGrade;
import com.cybercarjava.domain.post.model.PostStatus;
import com.cybercarjava.domain.user.model.User;

import java.util.List;

public interface PostService {

    void createPost(PostRequest req, User user, PartGrade partGrade, PostStatus postStatus);

    List<PostResponse> getPost(User user);

    void updatePost(PostRequest req, User user, Long postId, PartGrade partGrade, PostStatus postStatus);

    void deletePost(Long id, User user);

}

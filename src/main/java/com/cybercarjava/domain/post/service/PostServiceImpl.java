package com.cybercarjava.domain.post.service;

import com.cybercarjava.domain.customer.repository.CustomerRepository;
import com.cybercarjava.domain.post.dto.request.PostRequest;
import com.cybercarjava.domain.post.dto.response.PostResponse;
import com.cybercarjava.domain.post.model.Calculation;
import com.cybercarjava.domain.post.model.PartGrade;
import com.cybercarjava.domain.post.model.Post;
import com.cybercarjava.domain.post.model.PostStatus;
import com.cybercarjava.domain.post.repository.PostRepository;
import com.cybercarjava.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final CustomerRepository customerRepository;
    private final PostRepository postRepository;

    @Override
    public void createPost(PostRequest req, User user, PartGrade partGrade, PostStatus postStatus, Calculation calculation) {
        Post post = Post.builder()
                .content(req.content())
                .partsPrice(req.partsPrice())
                .royalty(req.royalty())
                .quantity(req.quantity())
                .mileage(req.mileage())
                .engineer(req.engineer())
                .partGrade(partGrade)
                .postStatus(postStatus)
                .calculation(calculation)
                .user(user)
                .build();
        postRepository.save(post);
    }

    @Override
    public List<PostResponse> getPost(User user) {
        return null;
    }

    @Override
    public void updatePost(PostRequest req, User user, Long postId, PartGrade partGrade, PostStatus postStatus, Calculation calculation) {
        Post post = postRepository.findPostByIdAndUser(postId, user);

        if (post != null) {
            post.updatePost(
                    req.partsNumber(),
                    req.content(),
                    req.partsPrice(),
                    req.royalty(),
                    req.quantity(),
                    req.mileage(),
                    req.engineer(),
                    postStatus,
                    partGrade,
                    calculation
            );
            postRepository.save(post);
        } else {
            throw new RuntimeException("DDD");
            // 예외처리는 추후에 변경 예정
        }
    }

    @Override
    public void deletePost(Long postId, User user) {
        Post post = postRepository.findPostByIdAndUser(postId, user);
        postRepository.delete(post);
    }
}

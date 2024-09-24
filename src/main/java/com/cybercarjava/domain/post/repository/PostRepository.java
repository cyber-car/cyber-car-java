package com.cybercarjava.domain.post.repository;

import com.cybercarjava.domain.post.model.Post;
import com.cybercarjava.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostByIdAndUser(Long postId, User user);
}

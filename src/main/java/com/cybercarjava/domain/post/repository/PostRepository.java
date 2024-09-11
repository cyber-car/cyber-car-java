package com.cybercarjava.domain.post.repository;

import com.cybercarjava.domain.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

package com.cybercarjava.domain.user.repository;

import com.cybercarjava.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

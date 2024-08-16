package com.cybercarjava.domain.user.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Builder
    public User(String number, String password, String nickname) {
        this.number = number;
        this.password = password;
        this.nickname = nickname;
    }
}

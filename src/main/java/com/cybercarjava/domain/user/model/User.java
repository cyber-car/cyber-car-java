package com.cybercarjava.domain.user.model;

import com.cybercarjava.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Entity
@Getter
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String company;

    @Builder
    public User(String number, String password, String nickname, String company) {
        this.number = number;
        this.password = password;
        this.nickname = nickname;
        this.company = company;
    }
}

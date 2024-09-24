package com.cybercarjava.domain.post.model;

import com.cybercarjava.domain.customer.model.Customer;
import com.cybercarjava.domain.user.model.User;
import com.cybercarjava.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "posts")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String content;

    @Column
    private String partsPrice;

    @Column
    private String royalty;

    @Column
    private String quantity;

    @Column
    private String mileage;

    @Column
    private String engineer;

    @Column
    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    @Builder
    public Post(User user, Customer customer, String content, String partsPrice, String royalty, String quantity, String mileage, String engineer,PostStatus postStatus) {
        this.user = user;
        this.customer = customer;
        this.content = content;
        this.partsPrice = partsPrice;
        this.royalty = royalty;
        this.quantity = quantity;
        this.mileage = mileage;
        this.engineer = engineer;
        this.postStatus = postStatus;
    }
}

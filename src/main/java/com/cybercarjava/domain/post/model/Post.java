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
    private String partsNumber;

    @Column
    private String content;

    @Column
    private String partsPrice;

    @Column
    private String royalty;

    @Column
    private int quantity;

    @Column
    private String mileage;

    @Column
    private String engineer;

    @Column
    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private PartGrade partGrade;

    @Builder
    public Post(User user, Customer customer, String partsNumber, String content, String partsPrice, String royalty, int quantity, String mileage, String engineer, PostStatus postStatus, PartGrade partGrade) {
        this.user = user;
        this.customer = customer;
        this.partsNumber = partsNumber;
        this.content = content;
        this.partsPrice = partsPrice;
        this.royalty = royalty;
        this.quantity = quantity;
        this.mileage = mileage;
        this.engineer = engineer;
        this.postStatus = postStatus;
        this.partGrade = partGrade;
    }

    public void updatePartsNumber(String partsNumber) {
        this.partsNumber = partsNumber;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updatePartsPrice(String partsPrice) {
        this.partsPrice = partsPrice;
    }

    public void updateRoyalty(String royalty) {
        this.royalty = royalty;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void updateMileage(String mileage) {
        this.mileage = mileage;
    }

    public void updateEngineer(String engineer) {
        this.engineer = engineer;
    }
}

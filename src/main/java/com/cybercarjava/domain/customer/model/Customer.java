package com.cybercarjava.domain.customer.model;

import com.cybercarjava.domain.user.model.User;
import com.cybercarjava.global.entity.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "customer")
public class Customer extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String carNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private String pinNumber;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String guestName;

    @Column
    private String memo;

    @Builder
    public Customer(
            String carNumber,
            String name,
            String carModel,
            String pinNumber,
            String phoneNumber,
            String guestName,
            String memo,
            User user
    ) {
        this.carNumber = carNumber;
        this.name = name;
        this.carModel = carModel;
        this.pinNumber = pinNumber;
        this.phoneNumber = phoneNumber;
        this.guestName = guestName;
        this.memo = memo;
        this.user = user;
    }

    public void updateCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updateCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void updatePinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void updatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void updateMemo(String memo) {
        this.memo = memo;
    }


}



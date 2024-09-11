package com.cybercarjava.domain.customer.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(
        @NotBlank(message = "차 번호를 입력해주세요")
        String carNumber,

        @NotBlank(message = "고객명을 입력해주세요")
        String name,

        @NotBlank(message = "차 기종을 입력해주세요")
        String carModel,

        String pinNumber,

        String phoneNumber,

        String guestName,

        String memo
){

}

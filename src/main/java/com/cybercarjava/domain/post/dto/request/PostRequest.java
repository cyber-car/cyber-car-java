package com.cybercarjava.domain.post.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PostRequest (

    String partsNumber,

    @NotBlank(message = "작업내용을 입력해주세요")
    String Content,

    String partsPrice,

    String royalty,

    int quantity,

    @NotBlank(message = "주행 거리를 입력해주세요")
    String mileage,

    @NotBlank(message = "담당 엔지니어의 이름을 입력해주세요")
    String engineer,

    String partGrade
){

}

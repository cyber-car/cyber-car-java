package com.cybercarjava.domain.user.dto;

public record SignUpRequest (
        String number,
        String password,
        String company
){

}

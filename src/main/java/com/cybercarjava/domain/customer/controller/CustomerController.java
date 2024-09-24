package com.cybercarjava.domain.customer.controller;

import com.cybercarjava.domain.customer.dto.CustomerRequest;
import com.cybercarjava.domain.customer.dto.CustomerResponse;
import com.cybercarjava.domain.customer.service.CustomerService;
import com.cybercarjava.global.security.UserPrincipalImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "고객 정보 등록하기")
    @PostMapping("/customer")
    public ResponseEntity<String> createCustomer(
            @RequestBody CustomerRequest req,
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal
            ) {
        customerService.createCustomer(req, userPrincipal.getUser());
        return ResponseEntity.status(HttpStatus.CREATED).body("고객 정보 등록");
    }
    @Operation(summary = "고객 정보 전체 조회하기")
    @GetMapping("/customer")
    public ResponseEntity<List<CustomerResponse>> getListCustomer(
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getListCustomer(userPrincipal.getUser()));
    }
    @Operation(summary = "고객 정보 단건 조회하기")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomer(
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal,
            @PathVariable (name = "customerId") Long customerId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomer(userPrincipal.getUser(), customerId));
    }

    @Operation(summary = "고객 정보 수정하기")
    @PatchMapping("/customer/{customerId}")
    public ResponseEntity<String> updateCustomer(
            @PathVariable (name = "customerId") Long customerId,
            @RequestBody CustomerRequest req,
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal
    ) {
        customerService.updateCustomer(req, userPrincipal.getUser(), customerId);
        return ResponseEntity.status(HttpStatus.OK).body("고객 정보 수정");
    }

    @Operation(summary = "고객 정보 삭제하기")
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> deleteCustomer(
            @AuthenticationPrincipal UserPrincipalImpl userPrincipal,
            @PathVariable (name = "customerId") Long customerId
    ) {
        customerService.deleteCustomer(userPrincipal.getUser(), customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("고객 정보 삭제");
    }
}

package com.cybercarjava.domain.customer.service;

import com.cybercarjava.domain.customer.dto.CustomerRequest;
import com.cybercarjava.domain.customer.dto.CustomerResponse;
import com.cybercarjava.domain.user.model.User;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerRequest req, User user);
    List<CustomerResponse> getListCustomer(User user);

    CustomerResponse getCustomer(User user, Long customerId);

    void updateCustomer(CustomerRequest req, User user, Long customerId);

    void deleteCustomer(User user, Long customerId);

}

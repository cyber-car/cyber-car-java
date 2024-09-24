package com.cybercarjava.domain.customer.repository;

import com.cybercarjava.domain.customer.model.Customer;
import com.cybercarjava.domain.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerByIdAndUser(Long customerId, User user);
}

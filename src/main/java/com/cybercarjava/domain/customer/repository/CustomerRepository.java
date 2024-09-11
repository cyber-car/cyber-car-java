package com.cybercarjava.domain.customer.repository;

import com.cybercarjava.domain.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findCustomerById(Long customerId);
}

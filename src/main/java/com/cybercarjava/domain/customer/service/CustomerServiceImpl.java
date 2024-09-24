package com.cybercarjava.domain.customer.service;

import com.cybercarjava.domain.customer.dto.CustomerRequest;
import com.cybercarjava.domain.customer.dto.CustomerResponse;
import com.cybercarjava.domain.customer.model.Customer;
import com.cybercarjava.domain.customer.repository.CustomerRepository;
import com.cybercarjava.domain.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerRequest req, User user) {
        Customer customer = Customer.builder()
                .carNumber(req.carNumber())
                .name(req.name())
                .carModel(req.carModel())
                .pinNumber(req.pinNumber())
                .phoneNumber(req.phoneNumber())
                .guestName(req.guestName())
                .memo(req.memo())
                .user(user)
                .build();
        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> getListCustomer(User user) {
        return null;
    }

    @Override
    public CustomerResponse getCustomer(User user, Long customerId) {
        return null;
    }

    @Override
    public void updateCustomer(CustomerRequest req, User user, Long customerId) {
        Customer customer = customerRepository.findCustomerByIdAndUser(customerId, user);

        if (customer != null) {
            customer.updateCarNumber(req.carNumber());
            customer.updateName(req.name());
            customer.updateCarModel(req.carModel());
            customer.updatePinNumber(req.pinNumber());
            customer.updatePhoneNumber(req.phoneNumber());
            customer.updateGuestName(req.guestName());
            customer.updateMemo(req.memo());
            customerRepository.save(customer);
        } else {
            throw new RuntimeException("DDD");
            // 예외처리는 추후에 변경 예정
        }
    }

    @Override
    public void deleteCustomer(User user, Long customerId) {
        Customer customer = customerRepository.findCustomerByIdAndUser(customerId, user);
        customerRepository.delete(customer);
    }
}

package com.example.labw3JPA;

import com.example.labw3JPA.modal.Customer;
import com.example.labw3JPA.repositories.CustomerRepository;
import com.example.labw3JPA.repositories.CustomerStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @Transactional
    public void testCustomerRepository() {

        Customer customer = new Customer();
        customer.setCustomerName("John Doe");
        customer.setCustomerStatus(CustomerStatus.ACTIVE);
        customer.setTotalCustomerMileage(10000);


        customerRepository.save(customer);

        Optional<Customer> savedCustomer = customerRepository.findByCustomerName("John Doe");
        assertTrue(savedCustomer.isPresent());
        assertEquals("John Doe", savedCustomer.get().getCustomerName());

        List<Customer> customersByStatus = customerRepository.findCustomerStatus(CustomerStatus.ACTIVE);
        assertTrue(customersByStatus.size() > 0);
    }
}

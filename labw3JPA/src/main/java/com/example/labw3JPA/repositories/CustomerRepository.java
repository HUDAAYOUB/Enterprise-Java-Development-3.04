package com.example.labw3JPA.repositories;

import com.example.labw3JPA.modal.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    Optional<Customer> findByCustomerName(String customerName);
    List<Customer> findCustomerStatus(CustomerStatus customerStatus);

}

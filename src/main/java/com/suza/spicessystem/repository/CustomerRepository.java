package com.suza.spicessystem.repository;

import com.suza.spicessystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {
    static List<Customer> find() {
        return null;
    }

    static Optional<Customer> findByID(Integer id) {
        return null;
    }
}

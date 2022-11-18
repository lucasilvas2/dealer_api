package com.project.dealer_api.repository;

import com.project.dealer_api.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Long> {
    List<Customers> findByName(String name);
    List<Customers> findByPhone(String phone);
    List<Customers> findByEmail(String email);
    List<Customers> findByAddress(String address);
}

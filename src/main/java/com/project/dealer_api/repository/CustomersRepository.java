package com.project.dealer_api.repository;

import com.project.dealer_api.domain.customers.Customers;
import com.project.dealer_api.domain.dealer.Dealer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    Page<Customers> findByName(String name, Pageable pageable);
    Page<Customers> findByPhone(String phone, Pageable pageable);
    Page<Customers> findByEmail(String email, Pageable pageable);
    Page<Customers> findByAddress(String address, Pageable pageable);
    Page<Customers> findByDealer(Dealer dealer, Pageable pageable);

    Page<Customers> findByNameAndEmail(String name, String email, Pageable pageable);
}
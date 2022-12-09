package com.project.dealer_api.repository;

import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findByName(String name);
    List<Customers> findByPhone(String phone);
    List<Customers> findByEmail(String email);
    List<Customers> findByAddress(String address);
    List<Customers> findByDealer(Dealer dealer);

    List<Customers> findByNameAndEmail(String name, String email);
}
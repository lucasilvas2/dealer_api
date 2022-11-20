package com.project.dealer_api.repository;

import com.project.dealer_api.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRequiredRepository extends JpaRepository<OrderRequired, Integer> {
    List<OrderRequired> findByCustomers(Customers customers);
    List<OrderRequired> findByStatus(Integer status);
    //List<OrderRequired> findByMethod_payment(Integer method);
}

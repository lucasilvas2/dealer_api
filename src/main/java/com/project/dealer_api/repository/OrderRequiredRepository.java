package com.project.dealer_api.repository;

import com.project.dealer_api.models.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRequiredRepository extends JpaRepository<OrderRequired, Integer> {
    List<OrderRequired> findByCustomers(Customers customers);
    List<OrderRequired> findByStatus(Integer status);
    List<OrderRequired> findByMethodPayment(Integer methodPayment);
    List<OrderRequired> findByTotalValue(BigDecimal totalValue);

    List<OrderRequired> findByTotalValueBetween(BigDecimal primaryValue, BigDecimal secondValue);
    List<OrderRequired> findByDatePay(LocalDateTime datePay);

    List<OrderRequired> findByDateRequest(LocalDateTime dateRequest);
}

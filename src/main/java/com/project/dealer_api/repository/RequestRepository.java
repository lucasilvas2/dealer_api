package com.project.dealer_api.repository;

import com.project.dealer_api.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Customers> findByCustomers(Customers customers);
    List<Customers> findByStatus(RequestStatus status);
    List<Customers> findByMethod_payment(MethodPayment methodPayment);
    List<Customers> findByDate_pay(LocalDate localDate);
    List<Customers> findByDate_request(LocalDate localDate);
}

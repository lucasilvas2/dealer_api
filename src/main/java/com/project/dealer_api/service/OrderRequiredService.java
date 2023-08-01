package com.project.dealer_api.service;

import com.project.dealer_api.domain.customers.Customers;
import com.project.dealer_api.domain.order.OrderRequired;
import com.project.dealer_api.repository.OrderRequiredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderRequiredService {
    @Autowired
    private OrderRequiredRepository orderRequiredRepository;
    private CustomersService customersService;

    public OrderRequiredService(OrderRequiredRepository orderRequiredRepository, CustomersService customersService){
        this.orderRequiredRepository = orderRequiredRepository;
        this.customersService = customersService;
    }


    public OrderRequired create(OrderRequired orderRequired, Integer id_customers){
        orderRequired.setCustomers(customersService.findById(id_customers));
        return orderRequiredRepository.save(orderRequired);
    }

    public void delete(Integer id_order){
        orderRequiredRepository.deleteById(id_order);
    }

    public OrderRequired findById(Integer id_order){
        return orderRequiredRepository.findById(id_order).isPresent() ? orderRequiredRepository.findById(id_order).get() : null;
    }

    public List<OrderRequired> findAll(){
        return orderRequiredRepository.findAll();
    }

    public List<OrderRequired> findByCustomers(Integer id_customers){
        Customers customers = customersService.findById(id_customers);
        return orderRequiredRepository.findByCustomers(customers);
    }

    public List<OrderRequired> findByStatus(Integer status){
        return orderRequiredRepository.findByStatus(status);
    }

    public List<OrderRequired> findByMethodPayment(Integer methodPayment){
        return orderRequiredRepository.findByMethodPayment(methodPayment);
    }

    public List<OrderRequired> findByTotalValue(BigDecimal totalValue){
        return orderRequiredRepository.findByTotalValue(totalValue);
    }

    public List<OrderRequired> findByTotalValueBetween(BigDecimal primaryTotalValue, BigDecimal secondTotalValue){
        return orderRequiredRepository.findByTotalValueBetween(primaryTotalValue, secondTotalValue);
    }

    public List<OrderRequired> findByDateRequest(LocalDateTime dateRequest){
        return orderRequiredRepository.findByDateRequest(dateRequest);
    }
    public List<OrderRequired> findByDatePay(LocalDateTime datePay){
        return orderRequiredRepository.findByDatePay(datePay);
    }
}

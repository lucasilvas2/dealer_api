package com.project.dealer_api.service;

import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.OrderRequired;
import com.project.dealer_api.repository.OrderRequiredRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

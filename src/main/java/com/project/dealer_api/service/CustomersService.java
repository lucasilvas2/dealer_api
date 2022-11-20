package com.project.dealer_api.service;

import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.Dealer;
import com.project.dealer_api.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {
    @Autowired
    public CustomersRepository customersRepository;
    @Autowired
    public DealerService dealerService;

    public CustomersService(CustomersRepository customersRepository, DealerService dealerService){
        this.customersRepository = customersRepository;
        this.dealerService = dealerService;
    }

    public Customers create(Customers customers, Integer id_dealer){
        customers.setDealer(dealerService.findById(id_dealer));
        return customersRepository.save(customers);
    }

    public void delete(Integer id_customers){
        customersRepository.deleteById(id_customers);
    }

    public List<Customers> findAll(){
        return customersRepository.findAll();
    }

    public Customers findById(Integer id_customer){
        return customersRepository.findById(id_customer).isPresent() ? customersRepository.findById(id_customer).get() : null;
    }

    public List<Customers> findByName(String name){
        return customersRepository.findByName(name);
    }
    public List<Customers> findByPhone(String phone){
        return customersRepository.findByPhone(phone);
    }

    public List<Customers> findByEmail(String email){
        return customersRepository.findByEmail(email);
    }

    public List<Customers> findByAddress(String address){
        return customersRepository.findByAddress(address);
    }

    public List<Customers> findByDealer(Integer id_dealer){
        Dealer dealer = dealerService.findById(id_dealer);
        return customersRepository.findByDealer(dealer);
    }
}


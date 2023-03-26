package com.project.dealer_api.service;

import com.project.dealer_api.models.Address;
import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.Dealer;
import com.project.dealer_api.repository.AddressRepository;
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

    @Autowired
    public AddressRepository addressRepository;

    @Autowired
    public AddressService addressService;

    public CustomersService(CustomersRepository customersRepository, DealerService dealerService, AddressService addressService,AddressRepository addressRepository){
        this.customersRepository = customersRepository;
        this.dealerService = dealerService;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    public Customers create(Customers customers, Integer id_address, Integer id_dealer){
        customers.setDealer(dealerService.findById(id_dealer));
        customers.setAddress(addressService.findById(id_address));
        return customersRepository.save(customers);
    }

    public Customers createWithAddress(Customers customers, Address address,Integer id_dealer){
        Address addressSave = addressRepository.save(address);
        customers.setAddress(addressSave);
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

    public List<Customers> findByNameAndEmail(String name, String email){
        return customersRepository.findByNameAndEmail(name, email);
    }
}


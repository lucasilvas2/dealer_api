package com.project.dealer_api.service;

import com.project.dealer_api.domain.customers.Customers;
import com.project.dealer_api.domain.customers.CustomersCreateDTO;
import com.project.dealer_api.domain.customers.CustomersUpdateDTO;
import com.project.dealer_api.domain.dealer.Dealer;
import com.project.dealer_api.repository.AddressRepository;
import com.project.dealer_api.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public CustomersService(CustomersRepository customersRepository, DealerService dealerService, AddressService addressService, AddressRepository addressRepository) {
        this.customersRepository = customersRepository;
        this.dealerService = dealerService;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    public Customers create(CustomersCreateDTO customersCreateDTO) {
        var dealer = dealerService.findById(customersCreateDTO.dealer_id());
        var address = addressService.create(customersCreateDTO.addressCreateDTO());
        var customers = new Customers(customersCreateDTO, address, dealer);
        return customersRepository.save(customers);
    }

    public Customers update(CustomersUpdateDTO customersUpdateDTO) {
        var dealer = dealerService.findById(customersUpdateDTO.dealer_id());
        var address = addressService.update(customersUpdateDTO.addressUpdateDTO());
        var customers = customersRepository.getReferenceById(customersUpdateDTO.id());
        customers.update(customersUpdateDTO, address, dealer);
        return customers;
    }

    public void delete(Integer id_customers) {
        customersRepository.deleteById(id_customers);
    }

    public Page<Customers> findAll(Pageable pageable) {
        return customersRepository.findAll(pageable);
    }

    public Customers findById(Integer id_customer) {
        return customersRepository.findById(id_customer).isPresent() ? customersRepository.findById(id_customer).get() : null;
    }

    public Page<Customers> findByName(String name, Pageable pageable) {
        return customersRepository.findByName(name, pageable);
    }

    public Page<Customers> findByPhone(String phone, Pageable pageable) {
        return customersRepository.findByPhone(phone, pageable);
    }

    public Page<Customers> findByEmail(String email, Pageable pageable) {
        return customersRepository.findByEmail(email, pageable);
    }

    public Page<Customers> findByAddress(String address, Pageable pageable) {
        return customersRepository.findByAddress(address, pageable);
    }

    public Page<Customers> findByDealer(Integer id_dealer, Pageable pageable) {
        Dealer dealer = dealerService.findById(id_dealer);
        return customersRepository.findByDealer(dealer, pageable);
    }

    public Page<Customers> findByNameAndEmail(String name, String email, Pageable pageable) {
        return customersRepository.findByNameAndEmail(name, email, pageable);
    }
}


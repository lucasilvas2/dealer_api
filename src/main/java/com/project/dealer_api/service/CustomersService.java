package com.project.dealer_api.service;

import com.project.dealer_api.models.Address;
import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.CustomersBodyRequest;
import com.project.dealer_api.models.Dealer;
import com.project.dealer_api.repository.AddressRepository;
import com.project.dealer_api.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Customers update(Customers customers, Integer id_customer, Integer id_address, Integer id_dealer){
        customers.setId(id_customer);
        customers.setDealer(dealerService.findById(id_dealer));
        customers.setAddress(addressService.findById(id_address));
        return customersRepository.save(customers);
    }

    public Customers createWithAddress(CustomersBodyRequest customersBodyRequest, Integer id_dealer){
        Customers newCustomers = new Customers();
        newCustomers.setName(customersBodyRequest.getName());
        newCustomers.setEmail(customersBodyRequest.getEmail());
        newCustomers.setPhone(customersBodyRequest.getPhone());

        Address newAddress = new Address();
        newAddress.setStreet(customersBodyRequest.getStreet());
        newAddress.setNumber(customersBodyRequest.getNumber());
        newAddress.setDistrict(customersBodyRequest.getDistrict());
        newAddress.setCity(customersBodyRequest.getCity());
        newAddress.setState(customersBodyRequest.getState());
        newAddress.setCountry(customersBodyRequest.getCountry());
        newAddress.setPostalCode(customersBodyRequest.getPostalCode());
        Address addressSave = addressRepository.save(newAddress);

        newCustomers.setAddress(addressSave);
        newCustomers.setDealer(dealerService.findById(id_dealer));
        return customersRepository.save(newCustomers);
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


package com.project.dealer_api.service;

import com.project.dealer_api.models.Address;
import com.project.dealer_api.models.Customers;
import com.project.dealer_api.request.CustomersDTO;
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
    public Customers createWithAddress(CustomersDTO customersDTO, Integer id_dealer){
        Customers newCustomers = new Customers();
        newCustomers.setName(customersDTO.getName());
        newCustomers.setEmail(customersDTO.getEmail());
        newCustomers.setPhone(customersDTO.getPhone());

        Address newAddress = new Address();
        newAddress.setStreet(customersDTO.getStreet());
        newAddress.setNumber(customersDTO.getNumber());
        newAddress.setDistrict(customersDTO.getDistrict());
        newAddress.setCity(customersDTO.getCity());
        newAddress.setState(customersDTO.getState());
        newAddress.setCountry(customersDTO.getCountry());
        newAddress.setPostalCode(customersDTO.getPostalCode());
        Address addressSave = addressRepository.save(newAddress);

        newCustomers.setAddress(addressSave);
        newCustomers.setDealer(dealerService.findById(id_dealer));
        return customersRepository.save(newCustomers);
    }

    public Customers update(Customers customers, Integer id_customer, Integer id_dealer){
        customers.setId(id_customer);
        customers.setDealer(dealerService.findById(id_dealer));
        customers.setAddress(customers.getAddress());
        return customersRepository.save(customers);
    }

    public Customers updateWithAddress(CustomersDTO customersDTO, Integer id_customer, Integer id_address, Integer id_dealer){
        Customers customers = new Customers();
        customers.setId(id_customer);
        customers.setName(customersDTO.getName());
        customers.setEmail(customersDTO.getEmail());
        customers.setPhone(customersDTO.getPhone());

        Address address = new Address();
        address.setId(id_address);
        address.setStreet(customersDTO.getStreet());
        address.setNumber(customersDTO.getNumber());
        address.setDistrict(customersDTO.getDistrict());
        address.setCity(customersDTO.getCity());
        address.setState(customersDTO.getState());
        address.setCountry(customersDTO.getCountry());
        address.setPostalCode(customersDTO.getPostalCode());
        Address addressSave = addressRepository.save(address);

        customers.setDealer(dealerService.findById(id_dealer));
        customers.setAddress(addressSave);
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


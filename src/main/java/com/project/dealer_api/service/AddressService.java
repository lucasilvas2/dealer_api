package com.project.dealer_api.service;

import com.project.dealer_api.models.Address;
import com.project.dealer_api.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address create(Address address){
        return addressRepository.save(address);
    }

    public void delete(Integer id_address){
        addressRepository.deleteById(id_address);
    }

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public Address findById(Integer id_address){
        return addressRepository.findById(id_address).isPresent() ? addressRepository.findById(id_address).get() : null;
    }

    public List<Address> findByStreet(String street){
        return addressRepository.findByStreet(street);
    }

    public List<Address> findByNumber(String number){
        return addressRepository.findByNumber(number);
    }

    public List<Address> findByCity(String city){
        return addressRepository.findByCity(city);
    }

    public List<Address> findByPostalCode(String postalCode){
        return addressRepository.findByPostalCode(postalCode);
    }

    public List<Address> findByDistrict(String district){
        return addressRepository.findByDistrict(district);
    }

    public List<Address> findByStreetAndNumber(String street, String number){
        return addressRepository.findByStreetAndNumber(street, number);
    }
}

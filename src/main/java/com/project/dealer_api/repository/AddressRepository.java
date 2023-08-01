package com.project.dealer_api.repository;

import com.project.dealer_api.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    List<Address> findByStreet(String street);
    List<Address> findByNumber(String number);
    List<Address> findByCity(String city);
    List<Address> findByPostalCode(String postalCode);
    List<Address> findByDistrict(String district);
    List<Address> findByStreetAndNumber(String street, String number);

}

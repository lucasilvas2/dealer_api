package com.project.dealer_api.domain.customers;

import com.project.dealer_api.domain.address.Address;
import com.project.dealer_api.domain.dealer.Dealer;


public record CustomerDetailDTO(
        Integer id,
        String name,
        String phone,
        String email,
        Address address,
        Dealer dealer) {
    public CustomerDetailDTO(Customers customers){
        this(customers.getId(), customers.getName(), customers.getPhone(), customers.getEmail(), customers.getAddress(), customers.getDealer());
    }
}

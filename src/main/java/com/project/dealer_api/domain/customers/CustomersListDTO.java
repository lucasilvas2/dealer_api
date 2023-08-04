package com.project.dealer_api.domain.customers;

import com.project.dealer_api.domain.address.Address;
import com.project.dealer_api.domain.dealer.Dealer;

public record CustomersListDTO(Integer id, Dealer dealer, String name, String email, String phone, Address address) {

    public CustomersListDTO(Customers customers){
        this(customers.getId(), customers.getDealer(), customers.getName(), customers.getEmail(), customers.getPhone(), customers.getAddress());
    }
}

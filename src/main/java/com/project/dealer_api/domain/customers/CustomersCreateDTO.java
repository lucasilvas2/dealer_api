package com.project.dealer_api.domain.customers;

import com.project.dealer_api.domain.address.AddressCreateDTO;
import com.project.dealer_api.domain.dealer.Dealer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record CustomersCreateDTO(
        @NotNull
        String name,
        @NotNull
        String phone,
        @NotNull
        @Email
        String email,
        @NotNull
        AddressCreateDTO addressCreateDTO,
        @NotNull
        Integer dealer_id) {

}

package com.project.dealer_api.domain.customers;

import com.project.dealer_api.domain.address.AddressCreateDTO;
import com.project.dealer_api.domain.address.AddressUpdateDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record CustomersUpdateDTO(
        @NotNull
        Integer id,
        String name,
        String phone,
        @Email
        String email,
        AddressUpdateDTO addressUpdateDTO,
        Integer dealer_id) {

}

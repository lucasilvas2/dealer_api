package com.project.dealer_api.domain.address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record AddressDetailDTO(
        Integer id,
        String street,
        String number,
        String district,
        String city,
        String state,
        String country,
        String postalCode
) {
    public AddressDetailDTO(Address address){
        this(address.getId(), address.getStreet(), address.getNumber(), address.getDistrict(), address.getCity(), address.getState(), address.getCountry(), address.getPostalCode());
    }
}

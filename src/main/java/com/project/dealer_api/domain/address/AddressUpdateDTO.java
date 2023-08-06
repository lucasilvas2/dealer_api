package com.project.dealer_api.domain.address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record AddressUpdateDTO(
        @NotNull
        Integer id,
        String street,
        String number,
        String district,
        String city,
        String state,
        String country,
        @Pattern(regexp = "\\d{5}-\\d{3}")
        String postalCode
        ) {
}

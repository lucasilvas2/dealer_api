package com.project.dealer_api.domain.address;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record AddressCreateDTO(
        @NotNull
        String street,
        @NotNull
        String number,
        @NotNull
        String district,
        @NotNull
        String city,
        @NotNull
        String state,
        @NotNull
        String country,
        @Pattern(regexp = "\\d{5}-\\d{3}")
        String postalCode
        ) {
}

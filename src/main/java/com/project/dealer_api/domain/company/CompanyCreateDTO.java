package com.project.dealer_api.domain.company;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public record CompanyCreateDTO(
        @NotNull
        String name,
        @NotNull
        String phone,
        @NotNull
        @Email
        String email) {
}

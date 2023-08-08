package com.project.dealer_api.domain.ordered;

import io.swagger.models.auth.In;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record OrderedProductListCreateDTO(
        @NotNull
        String name,
        @NotNull
        String code,
        @NotNull
        String productName,
        @NotNull
        BigDecimal price,
        @NotNull
        Integer amount,
        @NotNull
        Integer orderRequiredId,
        @NotNull
        Integer companyId) {

}

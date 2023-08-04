package com.project.dealer_api.domain.dealer;

import javax.validation.constraints.NotNull;

public record DealerCreateDTO(@NotNull String name) {
}

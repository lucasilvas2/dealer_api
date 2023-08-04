package com.project.dealer_api.domain.dealer;

import javax.validation.constraints.NotNull;

public record DealerUpdateDTO(@NotNull Integer id,@NotNull String name) {
}

package com.project.dealer_api.domain.order;

import com.project.dealer_api.domain.ordered.MethodPayment;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record OrderRequiredCreateDTO(
        OrderStatus orderStatus,
        @NotNull
        LocalDateTime dateRequest,
        LocalDateTime datePay,
        MethodPayment methodPayment,
        Boolean delivery,
        @NotNull
        Integer customerId) {
}

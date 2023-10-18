package com.project.dealer_api.domain.order;

import com.project.dealer_api.domain.customers.Customers;
import com.project.dealer_api.domain.ordered.MethodPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRequired {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer status;
    private OrderStatus orderStatus;
    private MethodPayment methodPayment;
    private BigDecimal totalValue;
    private LocalDateTime dateRequest;
    private LocalDateTime datePay;
    private Integer payment;
    private Boolean delivery = false;

    @ManyToOne
    private Customers customers;


    public OrderStatus getStatus() {
        return OrderStatus.valueOf(this.status);
    }

    public void setStatus(OrderStatus status) {
        if (status != null) {
            this.status = status.getCodeOrderStatus();
        }
    }

    public MethodPayment getMethodPayment() {
        return MethodPayment.valueOf(this.payment);
    }

    public void setMethodPayment(MethodPayment methodPayment) {
        if(methodPayment != null){
            this.payment  = methodPayment.getCodeMethod();
        }
    }

    public OrderRequired(OrderRequiredCreateDTO orderRequiredCreateDTO, Customers customers){
        this.customers = customers;
        this.orderStatus = orderRequiredCreateDTO.orderStatus();
        this.dateRequest = orderRequiredCreateDTO.dateRequest();
        this.datePay = orderRequiredCreateDTO.datePay();
        this.methodPayment = orderRequiredCreateDTO.methodPayment();
    }
}

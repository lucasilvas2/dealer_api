package com.project.dealer_api.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class OrderRequired {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customers customers;

    private Integer status;
    private BigDecimal total_value;
    private LocalDateTime date_request;
    private LocalDateTime date_pay;
    private Integer method_payment;
    private Boolean delivery = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(this.status);
    }

    public void setStatus(OrderStatus status) {
        if(status != null){
            this.status = status.getCodeOrderStatus();
        }
    }

    public BigDecimal getTotal_value() {
        return total_value;
    }

    public void setTotal_value(BigDecimal total_value) {
        this.total_value = total_value;
    }

    public LocalDateTime getDate_request() {
        return date_request;
    }

    public void setDate_request(LocalDateTime date_request) {
        this.date_request = date_request;
    }

    public LocalDateTime getDate_pay() {
        return date_pay;
    }

    public void setDate_pay(LocalDateTime date_pay) {
        this.date_pay = date_pay;
    }

    public MethodPayment getMethod_payment() {
        return  MethodPayment.valueOf(this.method_payment);
    }

    public void setMethod_payment(MethodPayment method_payment) {
        if(method_payment != null){
            this.method_payment = method_payment.getCodeMethod();
        }
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }
}

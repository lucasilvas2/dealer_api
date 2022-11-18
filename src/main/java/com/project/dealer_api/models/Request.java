package com.project.dealer_api.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_customers")
    private Customers customers;

    private Integer status;
    private BigDecimal total_value;
    private LocalDate date_request;
    private LocalDate date_pay;
    private Integer method_payment;
    private Boolean delivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public RequestStatus getStatus() {
        return RequestStatus.valueOf(this.status);
    }

    public void setStatus(RequestStatus status) {
        if(status != null){
            this.status = status.getCode();
        }
    }

    public BigDecimal getTotal_value() {
        return total_value;
    }

    public void setTotal_value(BigDecimal total_value) {
        this.total_value = total_value;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDate getDate_request() {
        return date_request;
    }

    public void setDate_request(LocalDate date_request) {
        this.date_request = date_request;
    }

    public LocalDate getDate_pay() {
        return date_pay;
    }

    public void setDate_pay(LocalDate date_pay) {
        this.date_pay = date_pay;
    }

    public void setMethod_payment(Integer method_payment) {
        this.method_payment = method_payment;
    }

    public MethodPayment getMethod_payment() {
        return  MethodPayment.valueOf(this.method_payment);
    }

    public void setMethod_payment(MethodPayment method_payment) {
        if(method_payment != null){
            this.method_payment = method_payment.getCode();
        }
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }
}

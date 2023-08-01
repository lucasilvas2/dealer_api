package com.project.dealer_api.domain.order;

import com.project.dealer_api.domain.customers.Customers;
import com.project.dealer_api.domain.ordered.MethodPayment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class OrderRequired {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Customers customers;

    private Integer status;
    private BigDecimal totalValue;
    private LocalDateTime dateRequest;
    private LocalDateTime datePay;
    private Integer methodPayment;
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

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDateTime getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(LocalDateTime dateRequest) {
        this.dateRequest = dateRequest;
    }

    public LocalDateTime getDatePay() {
        return datePay;
    }

    public void setDatePay(LocalDateTime datePay) {
        this.datePay = datePay;
    }

    public MethodPayment getMethodPayment() {
        return  MethodPayment.valueOf(this.methodPayment);
    }

    public void setMethodPayment(MethodPayment methodPayment) {
        if(methodPayment != null){
            this.methodPayment  = methodPayment.getCodeMethod();
        }
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }
}

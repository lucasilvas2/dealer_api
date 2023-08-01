package com.project.dealer_api.domain.ordered;

import com.project.dealer_api.domain.company.Company;
import com.project.dealer_api.domain.order.OrderRequired;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderedProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private OrderRequired orderRequired;

    @ManyToOne
    private Company company;
    private String productName;
    private BigDecimal price;
    private String code;

    private Integer amount = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderRequired getOrderRequired() {
        return orderRequired;
    }

    public void setOrderRequired(OrderRequired orderRequired) {
        this.orderRequired = orderRequired;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

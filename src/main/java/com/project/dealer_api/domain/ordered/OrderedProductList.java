package com.project.dealer_api.domain.ordered;

import com.project.dealer_api.domain.company.Company;
import com.project.dealer_api.domain.order.OrderRequired;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderedProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String productName;
    private BigDecimal price;
    private String code;

    private Integer amount = 1;

    @ManyToOne
    private OrderRequired orderRequired;

    @ManyToOne
    private Company company;

    public OrderedProductList(OrderedProductListCreateDTO orderedProductListDTO, Company company, OrderRequired orderRequired){
        this.productName = orderedProductListDTO.productName();
        this.code = orderedProductListDTO.code();
        this.amount = orderedProductListDTO.amount();
        this.price = orderedProductListDTO.price();
        this.company = company;
        this.orderRequired = orderRequired;
    }
}

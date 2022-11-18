package com.project.dealer_api.repository;

import com.project.dealer_api.models.Company;
import com.project.dealer_api.models.OrderedProductList;
import com.project.dealer_api.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface OrderedProductListRepository extends JpaRepository<OrderedProductList, Long> {
    List<OrderedProductList> findByRequest(Request request);
    List<OrderedProductList> findByCompany(Company company);
    List<OrderedProductList> findByProduct_name(String product_name);
    List<OrderedProductList> findByPrice(BigDecimal price);
    List<OrderedProductList> findByCode(String code);
    List<OrderedProductList> findByAmount(Long amount);
}

package com.project.dealer_api.repository;

import com.project.dealer_api.models.Company;
import com.project.dealer_api.models.OrderRequired;
import com.project.dealer_api.models.OrderedProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrderedProductListRepository extends JpaRepository<OrderedProductList, Integer> {
    List<OrderedProductList> findByOrderRequired(OrderRequired orderRequired);
    List<OrderedProductList> findByCompany(Company company);
    List<OrderedProductList> findByProductName(String productName);
    List<OrderedProductList> findByPrice(BigDecimal price);
    List<OrderedProductList> findByCode(String code);
    List<OrderedProductList> findByAmount(Integer amount);
}

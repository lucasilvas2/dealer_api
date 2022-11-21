package com.project.dealer_api.service;

import com.project.dealer_api.models.Company;
import com.project.dealer_api.models.OrderRequired;
import com.project.dealer_api.models.OrderedProductList;
import com.project.dealer_api.repository.OrderedProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderedProductListService {
    @Autowired
    private OrderedProductListRepository orderedProductListRepository;
    @Autowired
    private OrderRequiredService orderRequiredService;
    @Autowired
    private CompanyService companyService;


    public OrderedProductListService(OrderedProductListRepository orderedProductListRepository, OrderRequiredService orderRequiredService, CompanyService companyService){
        this.orderedProductListRepository = orderedProductListRepository;
        this.orderRequiredService = orderRequiredService;
        this.companyService = companyService;
    }

    public OrderedProductList create(OrderedProductList orderedProductList, Integer id_orderRequired, Integer id_company){
        orderedProductList.setOrderRequired(orderRequiredService.findById(id_orderRequired));
        orderedProductList.setCompany(companyService.findById(id_company));
        return orderedProductListRepository.save(orderedProductList);
    }

    public void delete(Integer id_orderedProductList){
        orderedProductListRepository.deleteById(id_orderedProductList);
    }

    public OrderedProductList findById(Integer id_orderedProductList){
        return orderedProductListRepository.findById(id_orderedProductList).isPresent() ? orderedProductListRepository.findById(id_orderedProductList).get() : null;
    }

    public List<OrderedProductList> findAll(){
        return orderedProductListRepository.findAll();
    }

    public List<OrderedProductList> findByOrderRequired(Integer id_orderRequired){
        OrderRequired orderRequiredSave = orderRequiredService.findById(id_orderRequired);
        return orderedProductListRepository.findByOrderRequired(orderRequiredSave);
    }

    public List<OrderedProductList> findByCompany(Integer id_company){
        Company companySave = companyService.findById(id_company);
        return orderedProductListRepository.findByCompany(companySave);
    }

    public List<OrderedProductList> findByProductName(String product_name){
        return orderedProductListRepository.findByProductName(product_name);
    }

    public List<OrderedProductList> findByPrice(BigDecimal price){
        return orderedProductListRepository.findByPrice(price);
    }
    public List<OrderedProductList> findByCode(String code){
        return orderedProductListRepository.findByCode(code);
    }
    public List<OrderedProductList> findByAmount(Integer amount){
        return orderedProductListRepository.findByAmount(amount);
    }
}

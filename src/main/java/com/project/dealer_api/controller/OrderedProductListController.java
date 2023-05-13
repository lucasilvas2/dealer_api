package com.project.dealer_api.controller;

import com.project.dealer_api.models.OrderRequired;
import com.project.dealer_api.models.OrderedProductList;
import com.project.dealer_api.service.OrderedProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value = "/orderProductList")
public class OrderedProductListController {

    @Autowired
    private OrderedProductListService orderedProductListService;

    public OrderedProductListController(OrderedProductListService orderedProductListService){
        this.orderedProductListService = orderedProductListService;
    }

    @PostMapping("/create/{id_ordered}/{id_company}")
    public ResponseEntity<?> create(@RequestBody OrderedProductList orderedProductList, @PathVariable Integer id_ordered, @PathVariable Integer id_company){
        OrderedProductList orderedProductListSave = orderedProductListService.create(orderedProductList, id_ordered, id_company);
        if(orderedProductList != null){
            return new ResponseEntity<>(orderedProductListSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping(value = "/delete/{id_orderedProductList}")
    public ResponseEntity<?> delete(@PathVariable Integer id_orderedProductList){
        orderedProductListService.delete(id_orderedProductList);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findById/{id_orderedProductList}")
    public ResponseEntity<?> findById(@PathVariable Integer id_orderedProductList){
        return ResponseEntity.ok(orderedProductListService.findById(id_orderedProductList));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(orderedProductListService.findAll());
    }

    @GetMapping(value = "/findByOrder/{id_orderRequired}")
    public ResponseEntity<?> findByOrderRequired(@PathVariable Integer id_orderRequired){
        return ResponseEntity.ok(orderedProductListService.findByOrderRequired(id_orderRequired));
    }

    @GetMapping(value = "/findByCompany/{id_company}")
    public ResponseEntity<?> findByCompany(@PathVariable Integer id_company){
        return ResponseEntity.ok(orderedProductListService.findByCompany(id_company));
    }
    @GetMapping(value = "/findByProductName/{product_name}")
    public ResponseEntity<?> findByProductName(@PathVariable String product_name){
        return ResponseEntity.ok(orderedProductListService.findByProductName(product_name));
    }
    @GetMapping(value = "/findByPrice/{price}")
    public ResponseEntity<?> findByPrice(@PathVariable BigDecimal price){
        return ResponseEntity.ok(orderedProductListService.findByPrice(price));
    }
    @GetMapping(value = "/findByCode/{code}")
    public ResponseEntity<?> findByCode(@PathVariable String code){
        return ResponseEntity.ok(orderedProductListService.findByCode(code));
    }
    @GetMapping(value = "/findByAmount/{amount}")
    public ResponseEntity<?> findByAmount(@PathVariable Integer amount){
        return ResponseEntity.ok(orderedProductListService.findByAmount(amount));
    }
}

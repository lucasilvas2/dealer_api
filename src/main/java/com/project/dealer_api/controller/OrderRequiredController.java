package com.project.dealer_api.controller;

import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.MethodPayment;
import com.project.dealer_api.models.OrderRequired;
import com.project.dealer_api.service.CustomersService;
import com.project.dealer_api.service.OrderRequiredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@RestController
@RequestMapping(value = "/pedido")
public class OrderRequiredController {
    @Autowired
    private OrderRequiredService orderRequiredService;
    private CustomersService customersService;

    public OrderRequiredController(OrderRequiredService orderRequiredService,CustomersService customersService){
        this.orderRequiredService = orderRequiredService;
        this.customersService = customersService;
    }

    @PostMapping("/cadastrar/{id_cliente}")
    public ResponseEntity<?> create(@RequestBody OrderRequired orderRequired, @PathVariable Integer id_cliente){
        orderRequired.setDate_request(LocalDateTime.from(ZonedDateTime.now()));
        OrderRequired orderRequiredSave = orderRequiredService.create(orderRequired, id_cliente);
        if(orderRequired != null){
            return new ResponseEntity<>(orderRequiredSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        //return ResponseEntity.ok(customersService.create(customers, id));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id_customer){
        orderRequiredService.delete(id_customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorId/{id_customer}")
    public ResponseEntity<?> findById(@PathVariable Integer id_customer){
        return ResponseEntity.ok(orderRequiredService.findById(id_customer));
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(orderRequiredService.findAll());
    }

    @GetMapping(value = "/buscarPorCliente/{id_customer}")
    public ResponseEntity<?> findByCustomers(@PathVariable Integer id_customer){
        return ResponseEntity.ok(orderRequiredService.findByCustomers(id_customer));
    }

    @GetMapping(value = "/buscarPorStatus/{status}")
    public ResponseEntity<?> findByStatus(@PathVariable Integer status){
        return ResponseEntity.ok(orderRequiredService.findByStatus(status));
    }
}

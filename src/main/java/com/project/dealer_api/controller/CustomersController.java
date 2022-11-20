package com.project.dealer_api.controller;


import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.Dealer;
import com.project.dealer_api.service.CustomersService;
import com.project.dealer_api.service.DealerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/clientes")
public class CustomersController {
    private CustomersService customersService;

    CustomersController(CustomersService customersService){
        this.customersService = customersService;
    }

    @PostMapping("/cadastrar/{id}")
    public ResponseEntity<?> create(@RequestBody Customers customers, @PathVariable Integer id){
        Customers customersSave = customersService.create(customers, id);
        if(customers != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        //return ResponseEntity.ok(customersService.create(customers, id));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id_customers){
        customersService.delete(id_customers);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(customersService.findAll());
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(customersService.findById(id));
    }
}

package com.project.dealer_api.controller;


import com.project.dealer_api.domain.customers.*;
import com.project.dealer_api.service.CustomersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping(value = "/customers")
public class CustomersController {
    private CustomersService customersService;

    CustomersController(CustomersService customersService){
        this.customersService = customersService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CustomersCreateDTO customersCreateDTO, UriComponentsBuilder uriComponentsBuilder){
        var customers = customersService.create(customersCreateDTO);
        var uri = uriComponentsBuilder.path("/customers/{id}").buildAndExpand(customers.getId()).toUri();
        return  ResponseEntity.created(uri).body(new CustomerDetailDTO(customers));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid CustomersUpdateDTO customersUpdateDTO){
        var customers =  customersService.update(customersUpdateDTO);
        return ResponseEntity.ok(new CustomerDetailDTO(customers));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity delete(@PathVariable Integer id_customer){
        customersService.delete(id_customer);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<CustomersListDTO>> list(Pageable pageable){
        var list = customersService.findAll(pageable).map(CustomersListDTO::new);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity detail(@PathVariable Integer id){
        var customer = customersService.findById(id);
        return ResponseEntity.ok(new CustomerDetailDTO(customer));
    }

    @PostMapping("/createWithAddress/{id}")
    public ResponseEntity<?> createWithAddress(@RequestBody CustomersDTO customersDTO, @PathVariable Integer id){
        //return new ResponseEntity<>(customersBodyRequest, HttpStatus.OK);
        Customers customersSave = customersService.createWithAddress(customersDTO, id);
        if(customersSave != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/updateWithAddress/{id_customer}/{id_address}/{id_dealer}")
    public ResponseEntity<?> updateWithAddress(@RequestBody CustomersDTO customersDTO, @PathVariable Integer id_customer, @PathVariable Integer id_address, @PathVariable Integer id_dealer){
        Customers customersSave = customersService.updateWithAddress(customersDTO, id_customer, id_address, id_dealer);
        if(customersSave != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Page<CustomersListDTO>> findById(@PathVariable String name, Pageable pageable){
        var customers = customersService.findByName(name, pageable).map(CustomersListDTO::new);
        return ResponseEntity.ok(customers);
    }
    @GetMapping(value = "/name/{name}/email/{email}")
    public ResponseEntity<Page<CustomersListDTO>> nameAndEmail(@PathVariable String name, @PathVariable String email, Pageable pageable){
        var customers = customersService.findByNameAndEmail(name, email, pageable).map(CustomersListDTO::new);
        return ResponseEntity.ok(customers);
    }
}

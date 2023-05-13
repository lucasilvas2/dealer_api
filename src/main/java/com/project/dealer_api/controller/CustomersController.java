package com.project.dealer_api.controller;


import com.project.dealer_api.models.Address;
import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.CustomersBodyRequest;
import com.project.dealer_api.service.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000" )
@RestController
@RequestMapping(value = "/customers")
public class CustomersController {
    private CustomersService customersService;

    CustomersController(CustomersService customersService){
        this.customersService = customersService;
    }

    @PostMapping("/create/{id_dealer}/{id_address}")
    public ResponseEntity<?> create(@RequestBody Customers customers, @PathVariable Integer id_dealer, @PathVariable Integer id_address){
        Customers customersSave = customersService.create(customers, id_address, id_dealer);
        if(customers != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/update/{id_customer}/{id_dealer}/{id_address}")
    public ResponseEntity<?> update(@RequestBody Customers customers, @PathVariable Integer id_customer, @PathVariable Integer id_dealer, @PathVariable Integer id_address){
        Customers customersSave =  customersService.update(customers, id_customer,id_address, id_dealer);
        if(customers != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/createWithAddress/{id}")
    public ResponseEntity<?> createWithAddress(@RequestBody CustomersBodyRequest customersBodyRequest, @PathVariable Integer id){
        Customers customersSave = customersService.createWithAddress(customersBodyRequest, id);
        if(customersSave != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping(value = "/delete/{id_customer}")
    public ResponseEntity<?> delete(@PathVariable Integer id_customer){
        customersService.delete(id_customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(customersService.findAll());
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(customersService.findById(id));
    }

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<?> findById(@PathVariable String name){
        return ResponseEntity.ok(customersService.findByName(name));
    }
    @GetMapping(value = "/findByNameAndEmail/{name}/{email}")
    public ResponseEntity<?> findByNameAndEmail(@PathVariable String name, @PathVariable String email){
        return ResponseEntity.ok(customersService.findByNameAndEmail(name, email));
    }
}

package com.project.dealer_api.controller;


import com.project.dealer_api.domain.customers.Customers;
import com.project.dealer_api.domain.customers.CustomersDTO;
import com.project.dealer_api.domain.customers.CustomersListDTO;
import com.project.dealer_api.service.CustomersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @PostMapping("/update/{id_customer}/{id_dealer}")
    public ResponseEntity<?> update(@RequestBody Customers customers, @PathVariable Integer id_customer, @PathVariable Integer id_dealer){
        Customers customersSave =  customersService.update(customers, id_customer, id_dealer);
        if(customers != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
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

    @DeleteMapping(value = "/delete/{id_customer}")
    public ResponseEntity<?> delete(@PathVariable Integer id_customer){
        customersService.delete(id_customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<Page<CustomersListDTO>> findAll(Pageable pageable){
        var page = customersService.findAll(pageable).map(CustomersListDTO::new);
        return ResponseEntity.ok(page);
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

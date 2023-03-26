package com.project.dealer_api.controller;


import com.project.dealer_api.models.Address;
import com.project.dealer_api.models.Customers;
import com.project.dealer_api.models.CustomersBodyRequest;
import com.project.dealer_api.service.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value = "/clientes")
public class CustomersController {
    private CustomersService customersService;

    CustomersController(CustomersService customersService){
        this.customersService = customersService;
    }

    @PostMapping("/cadastrar/{id_revendendor}/{id_endereco}")
    public ResponseEntity<?> create(@RequestBody Customers customers, @PathVariable Integer id_dealer, @PathVariable Integer id_address){
        Customers customersSave = customersService.create(customers, id_address, id_dealer);
        if(customers != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/cadastrarComEndereco/{id}/")
    public ResponseEntity<?> createWithAddress(@RequestBody CustomersBodyRequest customersBodyRequest, @PathVariable Integer id){
        Customers customersSave = customersService.createWithAddress(customersBodyRequest.getCustomers(), customersBodyRequest.getAddress(), id);
        if(customersSave != null){
            return new ResponseEntity<>(customersSave, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
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

    @GetMapping(value = "/buscarPorNome/{name}")
    public ResponseEntity<?> findById(@PathVariable String name){
        return ResponseEntity.ok(customersService.findByName(name));
    }
    @GetMapping(value = "/buscarPorNomeEmail/{name}/{email}")
    public ResponseEntity<?> findByNameAndEmail(@PathVariable String name, @PathVariable String email){
        return ResponseEntity.ok(customersService.findByNameAndEmail(name, email));
    }
}

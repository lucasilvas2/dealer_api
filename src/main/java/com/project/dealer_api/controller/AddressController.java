package com.project.dealer_api.controller;

import com.project.dealer_api.models.Address;
import com.project.dealer_api.models.Dealer;
import com.project.dealer_api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value ="/enderecos")
public class AddressController {
    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/buscarPorId/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<?> findById(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Address address){
        return ResponseEntity.ok(addressService.create(address));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorRua/{rua}")
    public ResponseEntity<?> findByNumber(@PathVariable String rua){
        return ResponseEntity.ok(addressService.findByStreet(rua));
    }

    @GetMapping(value = "/buscarPorNumero/{numero}")
    public ResponseEntity<?> findBy(@PathVariable String number){
        return ResponseEntity.ok(addressService.findByNumber(number));
    }

    @GetMapping(value = "/buscarPorCidate/{cidade}")
    public ResponseEntity<?> findByCity(@PathVariable String city){
        return ResponseEntity.ok(addressService.findByCity(city));
    }

    @GetMapping(value = "/buscarPorCodigoPostal/{codigoPostal}")
    public ResponseEntity<?> findByPostalCode(@PathVariable String postalCode){
        return ResponseEntity.ok(addressService.findByPostalCode(postalCode));
    }

    @GetMapping(value = "/buscarPorBairro/{bairro}")
    public ResponseEntity<?> findByDistrict(@PathVariable String district){
        return ResponseEntity.ok(addressService.findByDistrict(district));
    }
    @GetMapping(value = "/buscarPorRuaENumero/{rua}/{numero}")
    public ResponseEntity<?> findByStreetAndNumber(@PathVariable String street, @PathVariable String number){
        return ResponseEntity.ok(addressService.findByStreetAndNumber(street, number));
    }
}

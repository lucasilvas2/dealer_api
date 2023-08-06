package com.project.dealer_api.controller;

import com.project.dealer_api.domain.address.Address;
import com.project.dealer_api.domain.address.AddressCreateDTO;
import com.project.dealer_api.domain.address.AddressDetailDTO;
import com.project.dealer_api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value ="/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(addressService.findById(id));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findById(){
        return ResponseEntity.ok(addressService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid AddressCreateDTO addressCreateDTO, UriComponentsBuilder uriComponentsBuilder){
        var address = addressService.create(addressCreateDTO);
        var uri = uriComponentsBuilder.path("/adress/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri).body(new AddressDetailDTO(address));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        addressService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findByStree/{rua}")
    public ResponseEntity<?> findByNumber(@PathVariable String rua){
        return ResponseEntity.ok(addressService.findByStreet(rua));
    }

    @GetMapping(value = "/findByNumber/{numero}")
    public ResponseEntity<?> findBy(@PathVariable String number){
        return ResponseEntity.ok(addressService.findByNumber(number));
    }

    @GetMapping(value = "/findByCity/{cidade}")
    public ResponseEntity<?> findByCity(@PathVariable String city){
        return ResponseEntity.ok(addressService.findByCity(city));
    }

    @GetMapping(value = "/findByPostalCode/{codigoPostal}")
    public ResponseEntity<?> findByPostalCode(@PathVariable String postalCode){
        return ResponseEntity.ok(addressService.findByPostalCode(postalCode));
    }

    @GetMapping(value = "/findByDistrict/{bairro}")
    public ResponseEntity<?> findByDistrict(@PathVariable String district){
        return ResponseEntity.ok(addressService.findByDistrict(district));
    }
    @GetMapping(value = "/findByStreetAndNumber/{rua}/{numero}")
    public ResponseEntity<?> findByStreetAndNumber(@PathVariable String street, @PathVariable String number){
        return ResponseEntity.ok(addressService.findByStreetAndNumber(street, number));
    }
}

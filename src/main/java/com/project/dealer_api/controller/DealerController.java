package com.project.dealer_api.controller;

import com.project.dealer_api.models.Dealer;
import com.project.dealer_api.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value ="/dealer")
public class DealerController {
    @Autowired
    private DealerService dealerService;

    public DealerController(DealerService dealerService){
        this.dealerService = dealerService;
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){
        return ResponseEntity.ok(dealerService.findById(id));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(dealerService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody @Valid Dealer dealer){
        return ResponseEntity.ok(dealerService.create(dealer));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        dealerService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

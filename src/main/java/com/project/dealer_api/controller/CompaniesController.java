package com.project.dealer_api.controller;

import com.project.dealer_api.domain.company.Company;
import com.project.dealer_api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value = "/companies")
public class CompaniesController {
    @Autowired
    private CompanyService companyService;

    public CompaniesController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Company company){
        return ResponseEntity.ok(companyService.create(company));
    }

    @DeleteMapping(value = "/delete/{id_company}")
    public ResponseEntity<?> delete(@PathVariable Integer id_company){
        companyService.delete(id_company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/findById/{id_company}")
    public ResponseEntity<?> findById(@PathVariable Integer id_company){
        return ResponseEntity.ok(companyService.findById(id_company));
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return ResponseEntity.ok(companyService.findByName(name));
    }

    @GetMapping(value = "/findByPhone/{phone}")
    public ResponseEntity<?> findByPhone(@PathVariable String phone){
        return ResponseEntity.ok(companyService.findByPhone(phone));
    }

    @GetMapping(value = "/findByAddress/{address}")
    public ResponseEntity<?> findByAddress(@PathVariable String address){
        return ResponseEntity.ok(companyService.findByPhone(address));
    }
}

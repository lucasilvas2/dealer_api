package com.project.dealer_api.controller;

import com.project.dealer_api.models.Company;
import com.project.dealer_api.service.CompanyService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value = "/empresa")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> create(@RequestBody Company company){
        return ResponseEntity.ok(companyService.create(company));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@PathVariable Integer id_company){
        companyService.delete(id_company);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/buscarPorId/{id_company}")
    public ResponseEntity<?> findById(@PathVariable Integer id_company){
        return ResponseEntity.ok(companyService.findById(id_company));
    }

    @GetMapping(value = "/buscarTodos")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping(value = "/buscarPorNome/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return ResponseEntity.ok(companyService.findByName(name));
    }

    @GetMapping(value = "/buscarPorNome/{phone}")
    public ResponseEntity<?> findByPhone(@PathVariable String phone){
        return ResponseEntity.ok(companyService.findByPhone(phone));
    }

    @GetMapping(value = "/buscarPorNome/{address}")
    public ResponseEntity<?> findByAddress(@PathVariable String address){
        return ResponseEntity.ok(companyService.findByPhone(address));
    }
}

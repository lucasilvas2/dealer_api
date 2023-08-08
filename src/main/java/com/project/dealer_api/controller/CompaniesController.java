package com.project.dealer_api.controller;

import com.project.dealer_api.domain.company.Company;
import com.project.dealer_api.domain.company.CompanyCreateDTO;
import com.project.dealer_api.domain.company.CompanyDetailDTO;
import com.project.dealer_api.domain.company.CompanyListDTO;
import com.project.dealer_api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000","http://localhost:3001" })
@RestController
@RequestMapping(value = "/companies")
public class CompaniesController {
    @Autowired
    private CompanyService companyService;

    public CompaniesController(CompanyService companyService){
        this.companyService = companyService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CompanyCreateDTO companyCreateDTO, UriComponentsBuilder uriComponentsBuilder){
        var company = companyService.create(companyCreateDTO);
        var uri =  uriComponentsBuilder.path("/company/{id}").buildAndExpand(company.getId()).toUri();
        return ResponseEntity.created(uri).body(company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        companyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Integer id){
        var company = companyService.findById(id);
        return ResponseEntity.ok(new CompanyDetailDTO(company));
    }

    @GetMapping
    public ResponseEntity<Page<CompanyListDTO>> list(Pageable pageable){
        var list = companyService.findAll(pageable).map(CompanyListDTO::new);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity name(@PathVariable String name){
        var company = companyService.findByName(name);
        return ResponseEntity.ok(new CompanyDetailDTO(company));
    }

    @GetMapping(value = "/phone/{phone}")
    public ResponseEntity<?> phone(@PathVariable String phone){
        var company = companyService.findByPhone(phone);
        return ResponseEntity.ok(new CompanyDetailDTO(company));
    }
}

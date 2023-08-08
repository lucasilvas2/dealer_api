package com.project.dealer_api.service;

import com.project.dealer_api.domain.company.Company;
import com.project.dealer_api.domain.company.CompanyCreateDTO;
import com.project.dealer_api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public Company create(CompanyCreateDTO companyCreateDTO){
        var company = companyRepository.save(new Company(companyCreateDTO));
        return company;
    }

    public void delete(Integer id_company){
        companyRepository.deleteById(id_company);
    }

    public Company findById(Integer id_company){
        return companyRepository.findById(id_company).isPresent() ? companyRepository.findById(id_company).get() : null;
    }

    public Page<Company> findAll(Pageable pageable){
        return companyRepository.findAll(pageable);
    }

    public Company findByName(String name){
        return companyRepository.findByName(name);
    }

    public Company findByPhone(String phone){
        return companyRepository.findByPhone(phone);
    }
    public Company findByEmail(String email){
        return companyRepository.findByEmail(email);
    }

}

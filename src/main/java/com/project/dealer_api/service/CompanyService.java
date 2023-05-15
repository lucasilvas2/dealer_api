package com.project.dealer_api.service;

import com.project.dealer_api.models.Company;
import com.project.dealer_api.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public Company create(Company company){
        return companyRepository.save(company);
    }

    public void delete(Integer id_company){
        companyRepository.deleteById(id_company);
    }

    public Company findById(Integer id_company){
        return companyRepository.findById(id_company).isPresent() ? companyRepository.findById(id_company).get() : null;
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public List<Company> findByName(String name){
        return companyRepository.findByName(name);
    }

    public List<Company> findByPhone(String phone){
        return companyRepository.findByPhone(phone);
    }
    public List<Company> findByEmail(String email){
        return companyRepository.findByEmail(email);
    }

}

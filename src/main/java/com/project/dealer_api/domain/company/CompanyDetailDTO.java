package com.project.dealer_api.domain.company;

public record CompanyDetailDTO(Integer id ,String name, String phone, String email) {

    public CompanyDetailDTO(Company company){
        this(company.getId(), company.getName(), company.getPhone(), company.getEmail());
    }
}

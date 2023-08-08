package com.project.dealer_api.domain.company;

public record CompanyListDTO(Integer id , String name, String phone, String email) {

    public CompanyListDTO(Company company){
        this(company.getId(), company.getName(), company.getPhone(), company.getEmail());
    }
}

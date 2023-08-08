package com.project.dealer_api.domain.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;
    private String phone;

    @Email
    private String email;

    public Company(CompanyCreateDTO companyCreateDTO){
        this.name = companyCreateDTO.name();
        this.phone = companyCreateDTO.phone();
        this.email = companyCreateDTO.email();
    }
}


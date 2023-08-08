package com.project.dealer_api.repository;

import com.project.dealer_api.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Company findByName(String name);
    Company findByPhone(String phone);
    Company findByEmail(String email);
}


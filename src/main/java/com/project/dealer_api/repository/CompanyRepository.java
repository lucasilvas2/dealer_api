package com.project.dealer_api.repository;

import com.project.dealer_api.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {
    List<Company> findByName(String name);
    List<Company> findByPhone(String phone);
    List<Company> findByEmail(String email);
}


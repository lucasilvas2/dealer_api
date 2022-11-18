package com.project.dealer_api.repository;

import com.project.dealer_api.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    List<Company> findByName(String name);
    List<Company> findByPhone(String phone);
    List<Company> findByAddress(String address);
}

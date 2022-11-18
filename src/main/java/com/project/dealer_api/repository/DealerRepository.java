package com.project.dealer_api.repository;

import com.project.dealer_api.models.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
    List<Dealer> findByName(String name);
}

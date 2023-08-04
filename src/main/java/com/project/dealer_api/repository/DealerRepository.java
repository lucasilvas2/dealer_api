package com.project.dealer_api.repository;

import com.project.dealer_api.domain.dealer.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DealerRepository extends JpaRepository<Dealer, Integer> {
    List<Dealer> findByName(String name);
}


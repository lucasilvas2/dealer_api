package com.project.dealer_api.service;

import com.project.dealer_api.domain.dealer.Dealer;
import com.project.dealer_api.repository.DealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerService {
    @Autowired
    private DealerRepository dealerRepository;

    public DealerService(DealerRepository dealerRepository){
        this.dealerRepository = dealerRepository;
    }

    public Dealer create(Dealer dealer){
        return dealerRepository.save(dealer);
    }

    public void delete(Integer id_dealer){
        dealerRepository.deleteById(id_dealer);
    }

    public Page<Dealer> findAll(Pageable pageable){
        return dealerRepository.findAll(pageable);
    }

    public Dealer findById(Integer id_dealer){
        return dealerRepository.findById(id_dealer).isPresent() ? dealerRepository.findById(id_dealer).get() : null;
    }
    public List<Dealer> findByName(String name){
        return dealerRepository.findByName(name);
    }
}
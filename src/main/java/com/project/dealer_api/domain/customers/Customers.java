package com.project.dealer_api.domain.customers;

import com.project.dealer_api.domain.address.Address;
import com.project.dealer_api.domain.dealer.Dealer;
import com.project.dealer_api.repository.DealerRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String phone;

    @Email
    private String email;

    @ManyToOne
    private Address address;

    @ManyToOne
    private Dealer dealer;

    public Customers(CustomersCreateDTO customersCreateDTO, Address address, Dealer dealer){
        this.name = customersCreateDTO.name();
        this.email = customersCreateDTO.email();
        this.phone = customersCreateDTO.phone();
        this.address = address;
        this.dealer = dealer;
    }

    public void update(CustomersUpdateDTO customersUpdateDTO, Address address, Dealer dealer){

    }
}
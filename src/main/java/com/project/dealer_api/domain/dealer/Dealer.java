package com.project.dealer_api.domain.dealer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dealer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String name;

    public Dealer(DealerCreateDTO dealerCreateDTO) {
        this.name = dealerCreateDTO.name();
    }

    public void update(DealerUpdateDTO dealerUpdateDTO) {
        if(dealerUpdateDTO.name() != null){
            this.setName(dealerUpdateDTO.name());
        }
    }
}
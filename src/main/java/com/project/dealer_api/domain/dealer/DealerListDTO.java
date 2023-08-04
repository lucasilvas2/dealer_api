package com.project.dealer_api.domain.dealer;

public record DealerListDTO(Integer id, String name) {
    public DealerListDTO(Dealer dealer){
        this(dealer.getId(), dealer.getName());
    }
}

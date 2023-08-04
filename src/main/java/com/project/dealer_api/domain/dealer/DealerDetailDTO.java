package com.project.dealer_api.domain.dealer;

public record DealerDetailDTO(Integer id, String name) {
    public DealerDetailDTO(Dealer dealer){
        this(dealer.getId(), dealer.getName());
    }
}

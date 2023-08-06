package com.project.dealer_api.domain.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String number;
    private String district;
    private String city;
    private String state;
    private String country;
    @Pattern(regexp = "\\d{5}-\\d{3}")
    private String postalCode;

    public Address(AddressCreateDTO addressCreateDTO){
        this.street = addressCreateDTO.street();
        this.number = addressCreateDTO.number();
        this.city = addressCreateDTO.city();
        this.state = addressCreateDTO.state();
        this.country = addressCreateDTO.country();
        this.postalCode = addressCreateDTO.postalCode();
    }

    public void update(AddressUpdateDTO addressUpdateDTO){
        if(addressUpdateDTO.street() != null){
            this.street = addressUpdateDTO.street();
        }
        if(addressUpdateDTO.number() != null){
            this.number = addressUpdateDTO.number();
        }
        if(addressUpdateDTO.city() != null){
            this.city = addressUpdateDTO.city();
        }
        if(addressUpdateDTO.state() != null){
            this.state = addressUpdateDTO.state();
        }
        if(addressUpdateDTO.country() != null){
            this.country = addressUpdateDTO.country();
        }
        if(addressUpdateDTO.postalCode() != null){
            this.postalCode = addressUpdateDTO.postalCode();
        }
    }
}

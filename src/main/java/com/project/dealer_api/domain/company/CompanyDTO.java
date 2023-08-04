package com.project.dealer_api.domain.company;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.dealer_api.domain.address.Address;
import com.project.dealer_api.domain.customers.Customers;

public class CompanyDTO {
    private String name;
    private String phone;
    private String email;
    private String street;
    private String number;
    private String district;
    private String city;
    private String state;
    private String country;
    private String postalCode;

    @JsonCreator
    public CompanyDTO(
            @JsonProperty("name") String name,
            @JsonProperty("phone") String phone,
            @JsonProperty("email") String email,
            @JsonProperty("street") String street,
            @JsonProperty("number") String number,
            @JsonProperty("district") String district,
            @JsonProperty("city") String city,
            @JsonProperty("state") String state,
            @JsonProperty("country") String country,
            @JsonProperty("postalCode") String postalCode
    ) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }

    public Address getAddress(){
        Address newAddress = new Address();
        newAddress.setStreet(this.street);
        newAddress.setNumber(this.number);
        newAddress.setDistrict(this.district);
        newAddress.setCity(this.city);
        newAddress.setState(this.state);
        newAddress.setCountry(this.country);
        newAddress.setPostalCode(this.postalCode);
        return newAddress;
    }

    public Customers getCustomers(){
        Customers newCustomers = new Customers();
        newCustomers.setName(this.name);
        newCustomers.setEmail(this.email);
        newCustomers.setPhone(this.phone);
        return newCustomers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}

package com.dotin.course.entities;

import javax.persistence.Embeddable;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

    @NotNull
    @Column(nullable = false)
    private String street;

    @NotNull
    @Column(nullable = false, length = 5)
    private String zipcode;

    @NotNull
    @Column(nullable = false)
    private String city;

    public Address() {
    }

    public Address(String street, String zipCode, String city) {
        this.street = street;
        this.zipcode = zipCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
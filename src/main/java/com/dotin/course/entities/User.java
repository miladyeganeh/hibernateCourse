package com.dotin.course.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String firstName;
    private String lastName;

    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "street",
                column = @Column(name = "BILLING_STREET")),
        @AttributeOverride(name = "zipcode",
                column = @Column(name = "BILLING_ZIPCODE", length = 5)),
        @AttributeOverride(name = "city",
                column = @Column(name = "BILLING_CITY"))
    })
    private Address billingAddress;

    public User() {

    }

    public User(String userName, String firstName, String lastName, Address homeAddress, Address billingAddress) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.billingAddress = billingAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}

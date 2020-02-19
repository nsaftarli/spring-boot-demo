package com.example.demo.entity;

import javax.persistence.*;

/**
 * A simple representation of a Customer
 */

@Entity
@Table(name = "CUSTOMERS")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private Address address;

    protected Customer() {}

    public Customer(String firstName, String lastName, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Customer(Integer customerId, String firstName, String lastName, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

}

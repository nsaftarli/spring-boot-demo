package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private int streetNumber;
    private String streetName;
    private String city;
    private String country;
    private String postalCode;
}

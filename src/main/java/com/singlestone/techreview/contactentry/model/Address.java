package com.singlestone.techreview.contactentry.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column
    String street;

    @Column
    String city;

    @Column
    String state;

    @Column
    String zip;

    public Address() { }

    public Address(String street,String city,String state,String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() { return street; }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() { return city; }
    public void setCity(String city) {
        this.city = city;
    }

    public String getstate() { return state; }
    public void setState(String state) {
        this.state = state;
    }

    public String getZip() { return zip; }
    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return street + " " + city + " " + state + " " + zip;
    }
}

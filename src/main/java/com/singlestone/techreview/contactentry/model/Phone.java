package com.singlestone.techreview.contactentry.model;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String number;

    @Column
    private String type;

    @ManyToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    public Phone() { }

    public Phone(Contact c) {
        this.contact = c;
    }

    public Phone(String number, String type) {
        this.number = number;
        this.type = type;
    }

    public Phone(long id, String number, String type) {
        this.id = id;
        this.number = number;
        this.type = type;
    }

    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return " { \"id\": \"" + id + "\", \"number\": \""
                + number + "\", \"type\": \"" + type + "\" "
                + " } ";
    }
}

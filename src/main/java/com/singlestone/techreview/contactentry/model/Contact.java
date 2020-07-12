package com.singlestone.techreview.contactentry.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Embedded
    private Name name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "contact", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Phone> phoneNumbers;

    @Column
    private String email;

    public Contact() { }

    public Contact(String email) {
        this.email = email;
    }

    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }

    public Name getName() { return name; }
    public void setName(Name name) { this.name = name; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }
    public void setPhoneNumbers(Set<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ \"id\": ").append(this.id).append(", ")
                .append("\"name\": { \"first\": \"").append(this.name.first).append("\", ")
                .append("\"middle\": \"").append(this.name.middle).append("\", ")
                .append("\"last\": \"").append(this.name.last).append("\" }, ")
                .append("\"address\": { \"street\": \"").append(this.address.street).append("\", ")
                .append("\"city\": \"").append(this.address.city).append("\", ")
                .append("\"state\": \"").append(this.address.state).append("\", ")
                .append("\"zip\": \"").append(this.address.zip).append("\"}, ");
        if(phoneNumbers != null && phoneNumbers.size() > 0) {
            sb.append("\"phone\": [ ");
            for (Phone pn : phoneNumbers) {
                if(sb.toString().contains("number")) {
                    sb.append(", ");
                }
                sb.append(" { \"number\": \"").append(pn.getNumber()).append("\", ");
                sb.append("\"type\": \"").append(pn.getType()).append("\" } ");
            }
            sb.append(" ], ");
        }
        return sb.append("\"email\": \"").append(this.email).append( "\" }").toString();
    }

}

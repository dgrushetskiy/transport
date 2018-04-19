package ru.gothmog.app.model;

import org.hibernate.annotations.Type;
import ru.gothmog.app.enumeration.EnumTypeOfRegistration;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "date_of_registration")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfRegistration;

    @Column(name = "date_of_change")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfChange;

    private String address;

    private String number;

    private String addition;

    private String postcode;

    private String region;

    private String city;

    private String state;

    @Enumerated(EnumType.STRING)
    private EnumTypeOfRegistration typeOfRegistration;

    public Address() {
    }

    public Address(Date dateOfRegistration, Date dateOfChange, String address, String number, String addition, String postcode, String region, String city, String state, EnumTypeOfRegistration typeOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
        this.dateOfChange = dateOfChange;
        this.address = address;
        this.number = number;
        this.addition = addition;
        this.postcode = postcode;
        this.region = region;
        this.city = city;
        this.state = state;
        this.typeOfRegistration = typeOfRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public EnumTypeOfRegistration getTypeOfRegistration() {
        return typeOfRegistration;
    }

    public void setTypeOfRegistration(EnumTypeOfRegistration typeOfRegistration) {
        this.typeOfRegistration = typeOfRegistration;
    }
}

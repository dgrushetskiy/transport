package ru.gothmog.app.model;

import org.hibernate.annotations.Type;
import ru.gothmog.app.enumeration.EnumSex;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "date_of_registration")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfRegistration;

    @Column(name = "date_of_change")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfChange;

    @Column(name = "date_of_birth")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfBirth;

    @Column(name = "driver_name")
    private String driverName;

    @Enumerated(EnumType.STRING)
    private EnumSex enumSex;

    private String cnh;

    private String cpf;

    private String rg;
    @Column(name = "home_phone")
    private String homePhone;
    @Column(name = "mobile_phone")
    private String mobilePhone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public EnumSex getEnumSex() {
        return enumSex;
    }

    public void setEnumSex(EnumSex enumSex) {
        this.enumSex = enumSex;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

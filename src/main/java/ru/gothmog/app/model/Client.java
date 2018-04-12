package ru.gothmog.app.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import ru.gothmog.app.enumeration.EnumSex;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "clients")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "date_of_registration")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfRegistration;

    @Column(name = "date_of_change")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date DateOfChange;
    @Column(name = "client_name")
    private String name;

    private EnumSex enumSex;

    private String cpf;

    private String rg;
    @Column(name = "date_of_birth")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfBirth;
    @Column(name = "home_phone")
    private String homePhone;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "email")
    private String email;

    public Client() {
    }

    public Client(Date dateOfRegistration, Date dateOfChange, String name, EnumSex enumSex, String cpf, String rg, Date dateOfBirth, String homePhone, String mobilePhone, String email) {
        this.dateOfRegistration = dateOfRegistration;
        DateOfChange = dateOfChange;
        this.name = name;
        this.enumSex = enumSex;
        this.cpf = cpf;
        this.rg = rg;
        this.dateOfBirth = dateOfBirth;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.email = email;
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
        return DateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        DateOfChange = dateOfChange;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumSex getEnumSex() {
        return enumSex;
    }

    public void setEnumSex(EnumSex enumSex) {
        this.enumSex = enumSex;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", this.name)
                .append("email", this.email)
                .append("mobilePhone", this.mobilePhone)
                .toString();
    }
}

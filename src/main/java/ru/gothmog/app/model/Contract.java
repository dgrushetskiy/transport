package ru.gothmog.app.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "date_of_registration")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfRegistration;

    @Column(name = "date_of_change")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfChange;

    @Column(name = "date_validaty")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateValidity;

    @Column(name = "date_of_entry_into_force")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private Date dateOfEntryIntoForce;

    @Column(name = "observation", length = 2000)
    private String observation;
    @OneToOne
    @JoinColumn(name = "contract_value_id")
    @NotNull
    private ContractValue contractValue;

    @OneToOne
    @JoinColumn(name = "contract_installment_id")
    @NotNull
    private ContractInstallment contractInstallment;

    @OneToOne
    @JoinColumn(name = "contract_route_id")
    private ContractRoute contractRoute;

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

    public Date getDateValidity() {
        return dateValidity;
    }

    public void setDateValidity(Date dateValidity) {
        this.dateValidity = dateValidity;
    }

    public Date getDateOfEntryIntoForce() {
        return dateOfEntryIntoForce;
    }

    public void setDateOfEntryIntoForce(Date dateOfEntryIntoForce) {
        this.dateOfEntryIntoForce = dateOfEntryIntoForce;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ContractValue getContractValue() {
        return contractValue;
    }

    public void setContractValue(ContractValue contractValue) {
        this.contractValue = contractValue;
    }

    public ContractInstallment getContractInstallment() {
        return contractInstallment;
    }

    public void setContractInstallment(ContractInstallment contractInstallment) {
        this.contractInstallment = contractInstallment;
    }

    public ContractRoute getContractRoute() {
        return contractRoute;
    }

    public void setContractRoute(ContractRoute contractRoute) {
        this.contractRoute = contractRoute;
    }
}

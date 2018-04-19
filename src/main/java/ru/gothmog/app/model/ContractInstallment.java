package ru.gothmog.app.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "contract_installments")
public class ContractInstallment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_installment_id", nullable = false, unique = true)
    private Long id;
    @Column(name = "quantity_of_cargo")
    private Integer quantityOfCargo;
    @Column(name = "monthly_value")
    private BigDecimal monthlyValue;
    @Column(name = "total_amount_of_cargo")
    private BigDecimal totalAmountOfCargo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantityOfCargo() {
        return quantityOfCargo;
    }

    public void setQuantityOfCargo(Integer quantityOfCargo) {
        this.quantityOfCargo = quantityOfCargo;
    }

    public BigDecimal getMonthlyValue() {
        return monthlyValue;
    }

    public void setMonthlyValue(BigDecimal monthlyValue) {
        this.monthlyValue = monthlyValue;
    }

    public BigDecimal getTotalAmountOfCargo() {
        return totalAmountOfCargo;
    }

    public void setTotalAmountOfCargo(BigDecimal totalAmountOfCargo) {
        this.totalAmountOfCargo = totalAmountOfCargo;
    }
}

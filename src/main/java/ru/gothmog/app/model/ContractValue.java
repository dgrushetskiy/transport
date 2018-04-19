package ru.gothmog.app.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "contract_values")
public class ContractValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_value_id", nullable = false, unique = true)
    private Long id;
    @Column(name = "contract_value")
    private BigDecimal contractValue;
    @Column(name = "extended_contract_value")
    private String extendedContractValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getContractValue() {
        return contractValue;
    }

    public void setContractValue(BigDecimal contractValue) {
        this.contractValue = contractValue;
    }

    public String getExtendedContractValue() {
        return extendedContractValue;
    }

    public void setExtendedContractValue(String extendedContractValue) {
        this.extendedContractValue = extendedContractValue;
    }
}

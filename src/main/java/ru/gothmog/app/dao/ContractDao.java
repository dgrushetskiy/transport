package ru.gothmog.app.dao;

import org.springframework.stereotype.Repository;
import ru.gothmog.app.model.Contract;

@Repository
public class ContractDao extends GenericDao<Contract, Long>{

    public ContractDao(){
        super(Contract.class);
    }
}

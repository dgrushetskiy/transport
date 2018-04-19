package ru.gothmog.app.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import ru.gothmog.app.enumeration.EnumSex;
import ru.gothmog.app.model.Driver;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DriverDao extends GenericDao<Driver, Long>{

    public DriverDao(){
        super(Driver.class);
    }

    public List<Driver> findGrid(final Driver driver){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Driver> driverCriteriaQuery = builder.createQuery(Driver.class);
        Root<Driver> from = driverCriteriaQuery.from(Driver.class);
        Predicate predicate = builder.and();

        if (driver.getDriverName() != null && StringUtils.isNotBlank(driver.getDriverName())){
            predicate = builder.and(predicate, builder.like(from.<String>get("driverName"), "%" + driver.getDriverName() + "%"));
        }
        if (driver.getCnh() !=null && StringUtils.isNotBlank(driver.getCnh())){
            predicate = builder.and(predicate, builder.like(from.<String>get("cnh"), driver.getCnh()));
        }
        if (driver.getEnumSex() !=null && !driver.getEnumSex().equals(EnumSex.ALL)){
            predicate = builder.equal(from.<EnumSex>get("enumSex"),driver.getEnumSex());
        }
        if (driver.getRg() !=null && StringUtils.isNotBlank(driver.getRg())){
            predicate = builder.equal(from.<String>get("rg"), driver.getRg());
        }
        if (driver.getCpf() !=null && StringUtils.isNotBlank(driver.getCpf())){
            predicate = builder.equal(from.<String>get("cpf"), driver.getCpf());
        }

        TypedQuery<Driver> driverTypedQuery = entityManager.createQuery(
                driverCriteriaQuery.select(from).where(predicate).orderBy(builder.asc(from.get("driverName"))));

        return driverTypedQuery.getResultList();
        }
}

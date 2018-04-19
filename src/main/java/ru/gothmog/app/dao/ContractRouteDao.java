package ru.gothmog.app.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import ru.gothmog.app.model.ContractRoute;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ContractRouteDao extends GenericDao<ContractRoute, Long>{

    public ContractRouteDao(){
        super(ContractRoute.class);
    }

    public List<ContractRoute> findGrid(final ContractRoute contractRoute){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ContractRoute> contractRouteCriteriaQuery = builder.createQuery(ContractRoute.class);
        Root<ContractRoute> from = contractRouteCriteriaQuery.from(ContractRoute.class);
        Predicate predicate = builder.and();

        if (contractRoute.getExitPoint() != null && StringUtils.isNotBlank(contractRoute.getExitPoint())){
            predicate = builder.and(predicate, builder.like(from.<String>get("exitPoint"),"%" + contractRoute.getExitPoint() + "%"));
        }
        if (contractRoute.getPointOfArrival() != null && StringUtils.isNotBlank(contractRoute.getPointOfArrival())){
            predicate = builder.and(predicate, builder.like(from.<String>get("pointOfArrival"),"%" + contractRoute.getPointOfArrival() + "%"));
        }
        if (contractRoute.getExitTime() != null){
            predicate = builder.equal(from.<String>get("exitTime"), contractRoute.getExitTime());
        }
        if (contractRoute.getArrivalTime() != null){
            predicate = builder.equal(from.<String>get("arrivalTime"),contractRoute.getArrivalTime());
        }

        TypedQuery<ContractRoute> contractRouteTypedQuery = entityManager.createQuery(
          contractRouteCriteriaQuery.select(from).where(predicate).orderBy(builder.asc(from.get("exitTime"))));
        return contractRouteTypedQuery.getResultList();
    }
}

package ru.gothmog.app.dao;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;
import ru.gothmog.app.enumeration.EnumSex;
import ru.gothmog.app.model.Client;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ClienteDao extends GenericDao<Client, Long> {

    public ClienteDao() {
        super(Client.class);
    }

    public List<Client> findGrid(final Client client){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> clientCriteriaQuery = builder.createQuery(Client.class);
        Root<Client> from = clientCriteriaQuery.from(Client.class);
        Predicate predicate = builder.and();

        if (client.getClientName() != null && StringUtils.isNotBlank(client.getClientName())){
            predicate = builder.and(predicate, builder.like(from.<String>get("clientName"), "%" + client.getClientName() + "%"));
        }
        if (client.getEnumSex() != null && !client.getEnumSex().equals(EnumSex.ALL)){
            predicate = builder.equal(from.<EnumSex>get("sex"), client.getEnumSex());
        }
        if (client.getRg() != null && StringUtils.isNotBlank(client.getRg())){
            predicate = builder.equal(from.<String>get("rg"), client.getRg());
        }
        if (client.getCpf() !=null && StringUtils.isNotBlank(client.getCpf())){
            predicate = builder.equal(from.<String>get("cpf"), client.getCpf());
        }

        TypedQuery<Client> clientTypedQuery = entityManager.createQuery(
                clientCriteriaQuery.select(from).where(predicate).orderBy(builder.asc(from.get("clientName")))
        );
        return clientTypedQuery.getResultList();
    }
}

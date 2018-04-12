package ru.gothmog.app.dao;

import org.springframework.stereotype.Repository;
import ru.gothmog.app.model.Client;

@Repository
public class ClienteDao extends GenericDao<Client, Long> {

    public ClienteDao() {
        super(Client.class);
    }
}

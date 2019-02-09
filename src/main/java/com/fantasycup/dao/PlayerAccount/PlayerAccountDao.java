package com.fantasycup.dao.PlayerAccount;

import com.fantasycup.dao.Player.Player;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PlayerAccountDao extends AbstractDAO<PlayerAccount> {

    public PlayerAccountDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public String create(PlayerAccount playerAccount) {
        return persist(playerAccount).getEmail();
    }

    public List<PlayerAccount> findAll() {
        return (List<PlayerAccount>) currentSession().createCriteria(PlayerAccount.class).list();
    }
}

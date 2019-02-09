package com.fantasycup.dao.Player;

import com.fantasycup.dao.Game.Game;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class PlayerDao extends AbstractDAO<Player> {

    public PlayerDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public String create(Player player) {
        return persist(player).getEmail();
    }

    public List<Player> findAll() {
        return (List<Player>) currentSession().createCriteria(Player.class).list();
    }
}

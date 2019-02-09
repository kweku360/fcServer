package com.fantasycup.dao.Game;

import com.fantasycup.dao.Event.Event;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class GameDao extends AbstractDAO<Game> {

    public GameDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public String create(Game game) {
        return persist(game).getName();
    }

    public List<Game> findAll() {
        List<Game> le =(List<Game>) currentSession().createCriteria(Game.class).list();
        int iterator = 0;
        for (Game game : le){
            game.getEvent().setGames(null);
            iterator++;
        }
        return le;
//        Query q = currentSession().createQuery("From game ");
//        return q.list();
    }
}

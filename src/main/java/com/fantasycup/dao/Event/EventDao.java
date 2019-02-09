package com.fantasycup.dao.Event;

import com.fantasycup.dao.Game.Game;
import com.fantasycup.resources.EventResource;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EventDao extends AbstractDAO<Event> {
    private final Logger logger = LoggerFactory.getLogger(EventDao.class);

    public EventDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Integer create(Event event) {
        return persist(event).getNumber();
    }

    public List<Event> findAll() {
        List<Event> le = (List<Event>) currentSession().createCriteria(Event.class).list();
        int iterator = 0;
        for (Event evt : le){
            List<Game> glist = le.get(iterator).getGames();
            for (int k=0;k < glist.size();k++){
                glist.get(k).setEvent(null);
            }
            iterator++;
        }
        return le;
//        Query q = currentSession().createQuery("From game ");
//        return q.list();
    }

    public boolean updateGameEvents(Integer eventId){
        //first we get all games
        List<Game> games =  (List<Game>) currentSession().createCriteria(Game.class).list();
        logger.debug(games.size()+" games");
        for (Game game:games){
            //lets do an update
            game.setEventid(eventId);
            currentSession().update(game);
        }
        return true;
    }

    public boolean updateStatus(Integer id,Integer status){
        //first we get all games
        Event evt =  (Event) currentSession().get(Event.class,id);
        evt.setStatus(status);
        return true;
    }
}

package com.fantasycup.bal.controllers;

import com.fantasycup.api.EventAttributes;
import com.fantasycup.core.utility.TimeUtils;
import com.fantasycup.dao.Event.Event;
import com.fantasycup.dao.Event.EventDao;
import com.fantasycup.dao.Game.Game;
import com.fantasycup.dao.Game.GameDao;

import java.util.List;

public class EventController {

    EventDao eventDao;
    public EventController(EventDao eventDao){
        this.eventDao = eventDao;
    }

    public Integer AddEvent(EventAttributes attributes){
        Event event  = new Event();
        event.setNumber(attributes.getNumber());
        event.setMonth(attributes.getMonth());
        event.setDeadline(attributes.getDeadline());
        event.setStatus(0);//for new event defaults to 0 = pending
        event.setDatecreated(TimeUtils.CurrentTimeStamp());
        event.setLastmodified(TimeUtils.CurrentTimeStamp());

        return eventDao.create(event);
    }

    public List<Event> findAll(){
        return eventDao.findAll();
    }

    public boolean UpdateGameEvents(Integer eventid){
        return eventDao.updateGameEvents(eventid);
    }

    public boolean UpdateStatus(Integer eventId,Integer status) {
        return eventDao.updateStatus(eventId,status);
    }
}

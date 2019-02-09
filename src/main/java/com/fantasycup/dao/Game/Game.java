package com.fantasycup.dao.Game;

import com.fantasycup.dao.Event.Event;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "eventid")
    private long eventid;

    @Column(name = "playercount")
    private int playercount;

    @Column(name = "maxplayers")
    private int maxplayers;

    @Column(name = "gametax")
    private double gametax;

    @Column(name = "entryfee")
    private Double entryfee;

//    Relationship Mappings
    @ManyToOne
    @JoinColumn(name = "eventid",referencedColumnName = "id",insertable = false,updatable = false)
    private Event event;

    //getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


    public int getPlayercount() {
        return playercount;
    }

    public void setPlayercount(int playercount) {
        this.playercount = playercount;
    }

    public int getMaxplayers() {
        return maxplayers;
    }

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public void setMaxplayers(int maxplayers) {
        this.maxplayers = maxplayers;
    }

    public double getGametax() {
        return gametax;
    }

    public void setGametax(double gametax) {
        this.gametax = gametax;
    }

    public Double getEntryfee() {
        return entryfee;
    }

    public void setEntryfee(Double entryfee) {
        this.entryfee = entryfee;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
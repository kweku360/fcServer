package com.fantasycup.api;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class GameAttributes {

    @JsonProperty
    private String name;

    @JsonProperty
    private String duration;

    @JsonProperty
    private long eventid;

    @JsonProperty
    private int playercount;

    @JsonProperty
    private int maxplayers;

    @JsonProperty
    private double gametax;

    @JsonProperty
    private double entryfee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public int getPlayercount() {
        return playercount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setPlayercount(int playercount) {
        this.playercount = playercount;
    }

    public int getMaxplayers() {
        return maxplayers;
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

    public double getEntryfee() {
        return entryfee;
    }

    public void setEntryfee(double entryfee) {
        this.entryfee = entryfee;
    }
}

package com.fantasycup.dao.PlayerAccount;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "playeraccount")
public class PlayerAccount {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @Column(name = "playerid")
    private long playerid;

    @Column(name = "email")
    private String email;

    @Column(name = "credential")
    private String credential;

    @Column(name = "fplteamcode")
    private int fplteamcode;

    @Column(name = "teamname")
    private String teamname;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "region")
    private String region;

    @Column(name = "regioncode")
    private String regioncode;

    @Column(name = "eplteam")
    private String eplteam;

    @Column(name = "datejoined")
    private Timestamp datejoined;

    @Column(name = "lastmodified")
    private Timestamp lastmodified;

    public long getId() {
        return id;
    }

    public long getPlayerid() {
        return playerid;
    }

    public void setPlayerid(long playerid) {
        this.playerid = playerid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public int getFplteamcode() {
        return fplteamcode;
    }

    public void setFplteamcode(int fplteamcode) {
        this.fplteamcode = fplteamcode;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode;
    }

    public String getEplteam() {
        return eplteam;
    }

    public void setEplteam(String eplteam) {
        this.eplteam = eplteam;
    }

    public Timestamp getDatejoined() {
        return datejoined;
    }

    public void setDatejoined(Timestamp datejoined) {
        this.datejoined = datejoined;
    }

    public Timestamp getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Timestamp lastmodified) {
        this.lastmodified = lastmodified;
    }
}

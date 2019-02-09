package com.fantasycup.dao.Player;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "walletid")
    private int walletid;

    @Column(name = "datejoined")
    private Timestamp datejoined;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getWalletid() {
        return walletid;
    }

    public void setWalletid(int walletid) {
        this.walletid = walletid;
    }

    public Timestamp getDatejoined() {
        return datejoined;
    }

    public void setDatejoined(Timestamp datejoined) {
        this.datejoined = datejoined;
    }
}

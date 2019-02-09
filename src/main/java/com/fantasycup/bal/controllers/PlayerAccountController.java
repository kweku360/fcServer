package com.fantasycup.bal.controllers;

import com.fantasycup.dao.Player.Player;
import com.fantasycup.dao.Player.PlayerDao;
import com.fantasycup.dao.PlayerAccount.PlayerAccount;
import com.fantasycup.dao.PlayerAccount.PlayerAccountDao;

import java.util.List;

public class PlayerAccountController {

    PlayerAccountDao playerAccountDao;
    public PlayerAccountController(PlayerAccountDao playerAccountDao){
        this.playerAccountDao = playerAccountDao;
    }

    public String AddPlayer(PlayerAccount playerAccount){
        return playerAccountDao.create(playerAccount);
    }

    public List<PlayerAccount> findAll(){
        return playerAccountDao.findAll();
    }
}

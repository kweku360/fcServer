package com.fantasycup.bal.controllers;

import com.fantasycup.dao.Game.Game;
import com.fantasycup.dao.Game.GameDao;
import com.fantasycup.dao.Player.Player;
import com.fantasycup.dao.Player.PlayerDao;

import java.util.List;

public class PlayerController {

    PlayerDao playerDao;
    public PlayerController(PlayerDao playerDao){
        this.playerDao = playerDao;
    }

    public String AddPlayer(Player player){
        return playerDao.create(player);
    }

    public List<Player> findAll(){
        return playerDao.findAll();
    }
}

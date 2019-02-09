package com.fantasycup.bal.controllers;

import com.fantasycup.api.GameAttributes;
import com.fantasycup.dao.Game.Game;
import com.fantasycup.dao.Game.GameDao;

import java.util.List;

public class GameController {

    GameDao gameDao;
    public GameController(GameDao gameDao){
        this.gameDao = gameDao;
    }

    public String AddGame(GameAttributes attributes){
        Game game = new Game();
        game.setName(attributes.getName());
        game.setDuration(attributes.getDuration());
        game.setEventid(attributes.getEventid());
        game.setPlayercount(attributes.getPlayercount());
        game.setMaxplayers(attributes.getMaxplayers());
        game.setGametax(attributes.getGametax());
        game.setEntryfee(attributes.getEntryfee());

        return gameDao.create(game);
    }

    public List<Game> findAll(){
        return gameDao.findAll();
    }
}

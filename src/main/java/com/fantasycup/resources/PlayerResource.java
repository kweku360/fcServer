package com.fantasycup.resources;

import com.codahale.metrics.annotation.Timed;
import com.fantasycup.bal.controllers.GameController;
import com.fantasycup.bal.controllers.PlayerController;
import com.fantasycup.dao.Game.Game;
import com.fantasycup.dao.Player.Player;
import com.fantasycup.db.people.TestResource;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;


@Path("/v1/player")
@Api(value="PLAYER", description="Provides API endpoints for a Fantasy Cup Player")
public class PlayerResource {

    private final Logger logger = LoggerFactory.getLogger(TestResource.class);

    PlayerController playerController;
     public PlayerResource(PlayerController playerController){
         this.playerController = playerController;
     }

    @Timed
    @POST
    @Path("/")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Add A Player Resource.", notes="Add A Player Resource")
    @ApiResponses(value={
            @ApiResponse(code=400, message="Resource not found"),
            @ApiResponse(code=201, message="Resource Retrieved")
    })
    public String AddPlayer(@Valid Player player) throws IOException {
        return playerController.AddPlayer(player);
    }


    @Timed
    @GET
    @Path("/")
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Get All Games.", notes="Retrieve All Active Games")
    @ApiResponses(value={
            @ApiResponse(code=400, message="No Game Found"),
            @ApiResponse(code=201, message="Game retrieved")
    })
    public List<Player> FindAll(){
        return playerController.findAll();
    }
}

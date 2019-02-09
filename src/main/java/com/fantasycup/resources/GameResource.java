package com.fantasycup.resources;

import com.codahale.metrics.annotation.Timed;
import com.fantasycup.api.GameAttributes;
import com.fantasycup.bal.controllers.GameController;
import com.fantasycup.dao.Game.Game;
import com.fantasycup.db.people.TestResource;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;


@Path("/v1/game")
@Api(value="GAME", description="Provides API endpoints for a Fantasy Cup Game")
public class GameResource {

    private final Logger logger = LoggerFactory.getLogger(TestResource.class);

    GameController gameController;
     public  GameResource(GameController gameController){
         this.gameController = gameController;
     }

    @Timed
    @POST
    @Path("/")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Add A Game Resource.", notes="Add A Game Resource")
    @ApiResponses(value={
            @ApiResponse(code=400, message="Resource not found"),
            @ApiResponse(code=201, message="Resource Retrieved")
    })
    public String AddGame(@Valid GameAttributes gameAttributes) throws IOException {
        return gameController.AddGame(gameAttributes);
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
    public List<Game> FindAll(){
        return gameController.findAll();
    }
}

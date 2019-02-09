package com.fantasycup.resources;

import com.codahale.metrics.annotation.Timed;
import com.fantasycup.bal.controllers.PlayerAccountController;
import com.fantasycup.bal.controllers.PlayerController;
import com.fantasycup.dao.Player.Player;
import com.fantasycup.dao.PlayerAccount.PlayerAccount;
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


@Path("/v1/playeraccount")
@Api(value="PLAYER ACCCOUNT", description="Provides API endpoints for a Fantasy Cup Player Account")
public class PlayerAccountResource {

    private final Logger logger = LoggerFactory.getLogger(TestResource.class);

    PlayerAccountController playerAccountController;
     public PlayerAccountResource(PlayerAccountController playerAccountController){
         this.playerAccountController = playerAccountController;
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
    public String AddPlayer(@Valid PlayerAccount playerAccount) throws IOException {
        return playerAccountController.AddPlayer(playerAccount);
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
    public List<PlayerAccount> FindAll(){
        return playerAccountController.findAll();
    }
}

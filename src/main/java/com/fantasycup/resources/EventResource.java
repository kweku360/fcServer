package com.fantasycup.resources;

import com.codahale.metrics.annotation.Timed;
import com.fantasycup.api.EventAttributes;
import com.fantasycup.bal.controllers.EventController;
import com.fantasycup.bal.controllers.GameController;
import com.fantasycup.dao.Event.Event;
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


@Path("/v1/event")
@Api(value="EVENT", description="Provides API endpoints for a Fantasy Cup Game Events")
public class EventResource {

    private final Logger logger = LoggerFactory.getLogger(EventResource.class);

    EventController eventController;
     public EventResource(EventController eventController){
         this.eventController = eventController;
     }

    @Timed
    @POST
    @Path("/")
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Add A Events Resource.", notes="Add A Event Resource")
    @ApiResponses(value={
            @ApiResponse(code=400, message="Resource not found"),
            @ApiResponse(code=201, message="Resource Retrieved")
    })
    public Integer AddEvent(@Valid EventAttributes eventAttributes) throws IOException {
        return eventController.AddEvent(eventAttributes);
    }

    @Timed
    @GET
    @Path("/updategameevent/{eventId}")
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Update game Event", notes="Changes All Games to the Next Event Gameweek.")
    @ApiResponses(value={
            @ApiResponse(code=400, message="Action Performed Successfully"),
            @ApiResponse(code=201, message="Unable To Perform Action")
    })
    public boolean UpdateGameEvent(@ApiParam(name = "eventId", value = "Event id", required = true) @PathParam("eventId") Integer eventId) throws IOException {
        return eventController.UpdateGameEvents(eventId);
    }

    @Timed
    @GET
    @Path("/status/{eventId}/{status}")
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Change Game Event Status", notes="Change Game Event Status")
    @ApiResponses(value={
            @ApiResponse(code=400, message="Action Performed Successfully"),
            @ApiResponse(code=201, message="Unable To Perform Action")
    })
    public boolean UpdateStatus(@ApiParam(name = "eventId", value = "Event id", required = true) @PathParam("eventId") Integer eventId,@ApiParam(name = "status", value = "status", required = true) @PathParam("status") Integer status) throws IOException {
        return eventController.UpdateStatus(eventId,status);
    }



    @Timed
    @GET
    @Path("/")
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Get All Events.", notes="Retrieve All Active Events")
    @ApiResponses(value={
            @ApiResponse(code=400, message="No Events Found"),
            @ApiResponse(code=201, message="Events retrieved")
    })
    public List<Event> FindAll(){

         return eventController.findAll();
    }
}

package com.fantasycup.db.people;


import com.codahale.metrics.annotation.Timed;
import com.fantasycup.api.PeopleAttributes;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/v1/test")
@Api(value="Test", description="Provides API endpoints for Testing")
public class TestResource {
    private final Logger logger = LoggerFactory.getLogger(TestResource.class);

    public TestResource(){

    }

    @Timed
    @POST
    @Path("/me")
    @Consumes(MediaType.APPLICATION_JSON)
    @ApiOperation(value="Get A Test Resource.", notes="A Test Resource")
    @ApiResponses(value={
            @ApiResponse(code=400, message="Resource not found"),
            @ApiResponse(code=201, message="Resource Retrieved")
    })
    public String GetTestResource(@Valid PeopleAttributes attributes) throws IOException {

//        PeopleRepository peopleRepository = new PeopleRepository();
//        peopleRepository.put(new People(attributes.getUsername(),attributes.getEmail()));
//        peopleRepository.close();
        return "true";

    }
//
//
//
//
//    @Timed
//    @GET
//    @Path("/{criteria}/{value}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Get All Terminals.", notes="Retrieve Terminals by Criteria")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No terminal Found"),
//            @ApiResponse(code=201, message="terminal retrieved")
//    })
//    public EntityList TerminalsFilter(@ApiParam(name = "criteria", value = "Find by Brand | Model | Status", required = true) @QueryParam("page") String criteria, @ApiParam(name = "value", value = "values", required = true) @QueryParam("page") int currentPage){
//        return terminalManager.terminalList(currentPage);
//    }
//
//    @Timed
//    @POST
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Create a Terminal.", notes="Validates Serial Number to avoid duplicates.")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="Terminal name exists"),
//            @ApiResponse(code=201, message="Terminal added successfully")
//    })
//    public Response createTerminal(@Valid TerminalAttributes attributes){
//
//        Terminal terminal = new Terminal();
//        terminal.setSerialNumber(attributes.getSerialNumber());
//        terminal.setBrand(attributes.getBrand());
//        terminal.setModel(attributes.getModel());
//        terminal.setStatus(1);//since we creating a new terminal status is one
//
//        if(terminalManager.create(terminal)){
//            return Response.status(201).build();
//        }
//
//        logger.debug(ErrorMessages.BRAND_DUPLICATE_ERROR);
//        throw new WebApplicationException(ErrorMessages.BRAND_DUPLICATE_ERROR, Response.status(400).build());
//    }
//
//    @Timed
//    @GET
//    @Path("/{terminalSerial}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Get A Terminal By Serial Number.", notes="Retrieve A Terminal By Serial Number")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No Terminal Found"),
//            @ApiResponse(code=201, message="Terminal retrieved")
//    })
//    public Terminal getTerminal(@ApiParam(name = "terminalSerial", value = "Terminal Serial Number", required = true) @PathParam("terminalSerial") String terminalSerial){
//        Optional<Terminal> terminal = terminalManager.showOne(terminalSerial);
//
//        if(!terminal.isPresent()){
//            logger.debug(ErrorMessages.TERMINAL_NOT_FOUND_ERROR);
//            throw new WebApplicationException(ErrorMessages.TERMINAL_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
//        }
//
//        return terminal.get();
//    }
//
//    @Timed
//    @PUT
//    @Path("/{terminalSerial}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Update A Terminal", notes="Update A terminal")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No Terminal Found"),
//            @ApiResponse(code=201, message="Terminal Updated")
//    })
//
//    public boolean updateTerminal(@Valid TerminalAttributes terminalAttributes){
//        Optional<Terminal> terminal = terminalManager.showOneById(terminalAttributes.getId());
//        if(!terminal.isPresent()){
//            logger.debug(ErrorMessages.TERMINAL_NOT_FOUND_ERROR);
//            throw new WebApplicationException(ErrorMessages.TERMINAL_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
//        }
//        terminal.get().setSerialNumber(terminalAttributes.getSerialNumber());
//        terminal.get().setBrand(terminalAttributes.getBrand());
//        terminal.get().setModel(terminalAttributes.getModel());
//
//        return terminalManager.updateTerminal(terminal.get());
//
////        if(!terminalVal.isPresent()){
////            logger.debug(ErrorMessages.TERMINAL_NOT_FOUND_ERROR);
////            throw new WebApplicationException(ErrorMessages.TERMINAL_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
////        }
//
//  //      return terminalManager.updateTerminal(terminal);
//    }
//
//
//
//
//    @Timed
//    @POST
//    @Path("/brands")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Create a Brand.", notes="Validates name to avoid duplicates.")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="Brand name exists"),
//            @ApiResponse(code=201, message="Brand added successfully")
//    })
//    public Response createBrand(@Valid BrandAttributes attributes){
//
//        Brand brand = new Brand();
//        brand.setName(attributes.getName());
//
//        if(brandManager.create(brand)){
//            return Response.status(201).build();
//        }
//
//        logger.debug(ErrorMessages.BRAND_DUPLICATE_ERROR);
//        throw new WebApplicationException(ErrorMessages.BRAND_DUPLICATE_ERROR, Response.status(400).build());
//    }
//
//    @Timed
//    @GET
//    @Path("/brands")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Get All Brands.", notes="Retrieve All Brands")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No Brands Found"),
//            @ApiResponse(code=201, message="Brand retrieved")
//    })
//    public EntityList AllBrands(@ApiParam(name = "page", value = "Current page selector", required = false) @QueryParam("page") int currentPage){
//       return brandManager.brandList(currentPage);
//    }
//
//    @Timed
//    @GET
//    @Path("/brand/{brandval}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Get A Brand By Id or Name.", notes="Retrieve A Single Brand by Id or Name")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No Brand Found"),
//            @ApiResponse(code=201, message="Brand retrieved")
//    })
//    public Brand getBrand(@ApiParam(name = "brandval", value = "brand id or Name", required = false) @PathParam("brandval") String brandval){
//        Optional<Brand> brand = brandManager.showOne(brandval);
//
//        if(!brand.isPresent()){
//            logger.debug(ErrorMessages.BRAND_NOT_FOUND_ERROR);
//            throw new WebApplicationException(ErrorMessages.BRAND_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
//        }
//
//        return brand.get();
//    }
//
//
//    @Timed
//    @GET
//    @Path("/brand/{brandval}/models")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Get All Models in a Brand", notes="Retrieve A List of all models in a brand")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No Brand Found"),
//            @ApiResponse(code=201, message="Models retrieved")
//    })
//
//    public EntityList getBrandModels(@ApiParam(name = "brandval", value = "brand id or Name", required = false) @PathParam("brandval") String brandval,@ApiParam(name = "page", value = "Current page selector", required = false) @QueryParam("page") int currentPage){
//        Optional<Brand> brand = brandManager.showOne(brandval);
//
//        if(!brand.isPresent()){
//            logger.debug(ErrorMessages.BRAND_NOT_FOUND_ERROR);
//            throw new WebApplicationException(ErrorMessages.BRAND_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
//        }
//
//        return brandManager.getBrandModel(brandval,currentPage);
//    }
//
//    @Timed
//    @POST
//    @Path("/brand/{brandval}/model")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Add A single model to a Brand", notes="Add A single model to a brand")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No Brand Found"),
//            @ApiResponse(code=201, message="Model Updated in brand")
//    })
//
//    public boolean addBrandModel(@ApiParam(name = "brandval", value = "brand id or Name", required = false) @PathParam("brandval") String brandval,@Valid Model model){
//        Optional<Brand> brand = brandManager.showOne(brandval);
//
//        if(!brand.isPresent()){
//            logger.debug(ErrorMessages.BRAND_NOT_FOUND_ERROR);
//            throw new WebApplicationException(ErrorMessages.BRAND_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
//        }
//
//        return brandManager.addModel(brandval,model.getName());
//    }
//
//    @Timed
//    @DELETE
//    @Path("/brand/{brandVal}/{modelName}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Delete A model from Brand", notes="Delete A model from a brand")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No Brand/Model Found"),
//            @ApiResponse(code=201, message="Model Removed from brand")
//    })
//
//    public boolean removeBrandModel(@ApiParam(name = "brandVal", value = "brand id or Name", required = false) @PathParam("brandVal") String brandVal,@ApiParam(name = "modelName", value = "Model Name", required = false) @PathParam("modelName") String modelName){
//
//        Optional<Brand> brand = brandManager.showOne(brandVal);
//
//        if(!brand.isPresent()){
//            logger.debug(ErrorMessages.BRAND_NOT_FOUND_ERROR);
//            throw new WebApplicationException(ErrorMessages.BRAND_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
//        }
//
//        return brandManager.removeModel(brandVal,modelName);
//    }
//
//    @Timed
//    @PUT
//    @Path("/brand/{brandVal}/model")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Update A model from Brand", notes="Update A model from a brand")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="No Brand/Model Found"),
//            @ApiResponse(code=201, message="Model Update from brand")
//    })
//
//    public boolean updateBrandModel(@ApiParam(name = "brandVal", value = "brand id or Name", required = false) @PathParam("brandVal") String brandVal,@Valid Model model){
//
//        Optional<Brand> brand = brandManager.showOne(brandVal);
//
//        if(!brand.isPresent()){
//            logger.debug(ErrorMessages.BRAND_NOT_FOUND_ERROR);
//            throw new WebApplicationException(ErrorMessages.BRAND_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
//        }
//
//        return brandManager.updateModel(brandVal,model);
//    }
//
//
//
//
//    @Timed
//    @PUT
//    @Path("/brand/{brandId}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Update a Brand.", notes="Update A Brand.")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="Brand name exists"),
//            @ApiResponse(code=201, message="Brand Updated successfully")
//    })
//    public boolean Brand(@ApiParam(name = "brandId", value = "brand id or Name", required = false) @PathParam("brandId") String brandId,@Valid BrandAttributes attributes){
//        Optional<Brand> brand = brandManager.showOne(brandId);
//
//        if(!brand.isPresent()){
//            logger.debug(ErrorMessages.BRAND_NOT_FOUND_ERROR);
//            throw new WebApplicationException(ErrorMessages.BRAND_NOT_FOUND_ERROR, Response.Status.NOT_FOUND);
//        }
//        if(brandManager.updateBrand(brandId,attributes.getName()) == true){
//            return true;
//        }else{
//            throw new WebApplicationException(ErrorMessages.BRAND_DUPLICATE_ERROR, Response.Status.NOT_FOUND);
//        }
//    }
//
//    @Timed
//    @PUT
//    @Path("/{terminalId}/status")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Check Status of Terminal.", notes="Check Status of Terminal.")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="INACTIVE"),
//            @ApiResponse(code=201, message="ACTIVE")
//    })
//    public void TerminalStatus(@Valid BrandAttributes attributes){
//
//    }
//
//    @Timed
//    @PUT
//    @Path("/")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @ApiOperation(value="Update a Terminal.", notes="Updates A New Terminal.")
//    @ApiResponses(value={
//            @ApiResponse(code=400, message="Terminal name exists"),
//            @ApiResponse(code=201, message="Terminal added successfully")
//    })
//    public void Terminal(@Valid BrandAttributes attributes){
//
//    }

}

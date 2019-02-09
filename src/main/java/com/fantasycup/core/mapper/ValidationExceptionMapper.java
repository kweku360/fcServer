package com.fantasycup.core.mapper;

import io.dropwizard.jersey.validation.JerseyViolationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.HashMap;


public class ValidationExceptionMapper implements ExceptionMapper<JerseyViolationException> {
    @Override
    public Response toResponse(final JerseyViolationException exception) {

        HashMap<String,String> errors = new HashMap<>();

        errors.put("code", "400");
        errors.put("message", "Validation failed");

        return Response.status(400)
                .type(MediaType.APPLICATION_JSON)
                .entity(errors)
                .build();
    }

}

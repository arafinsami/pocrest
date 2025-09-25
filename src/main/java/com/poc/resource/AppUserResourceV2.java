package com.poc.resource;

import com.poc.core.abstracts.AbstractProcessor;
import com.poc.core.interfaces.Processor;
import com.poc.dto.AppUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Singleton;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nablarch.core.repository.SystemRepository;
import nablarch.fw.jaxrs.JaxRsHttpRequest;
import nablarch.fw.web.HttpResponse;

@Singleton
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "User Management", description = "CRUD APIs for AppUser")
public class AppUserResourceV2 {

    private final Processor processor = SystemRepository.get("appUserProcessor");

    @GET
    @Operation(summary = "List all users", description = "Fetch all AppUsers from database")
    public HttpResponse index() {
        return ((AbstractProcessor) processor).index();
    }

    @POST
    @Operation(summary = "Create a new user")
    public HttpResponse create(@Valid AppUserDTO dto) {
        return ((AbstractProcessor) processor).create(dto);
    }

    @GET
    @Path("/{id}")
    @Operation(summary = "Find a user by ID")
    public HttpResponse find(JaxRsHttpRequest req) {
        return ((AbstractProcessor) processor).find(req);
    }

    // ... same for update, delete, echo
}

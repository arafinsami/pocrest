package com.poc.resource;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/openapi.json")
public class OpenApiEndpoint {

    private final OpenApiResource delegate = new OpenApiResource();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getSpec() {
        return """
                {
                  "openapi": "3.0.1",
                  "info": { "title": "My API", "version": "1.0.0" },
                  "paths": {}
                }
                """;
    }
}
package com.poc.resource;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/openapi.yaml")
public class OpenApiEndpointYaml {
    private final OpenApiResource delegate = new OpenApiResource();

    @GET
    @Produces("application/yaml")
    public Response getSpec() {
        String spec = """
        openapi: 3.0.1
        info:
          title: My API
          version: 1.0.0
        paths: {}
        """;

        return Response.ok(spec, "application/yaml").build();
    }
}

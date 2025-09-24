package com.poc.resource;

import com.poc.dto.AppUserDTO;
import com.poc.processor.AbstractProcessor;
import com.poc.processor.Processor;
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
public class AppUserResource {

    private final Processor processor = SystemRepository.get("appUserProcessor");

    @GET
    public HttpResponse index() {
        return ((AbstractProcessor) processor).index();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Valid
    public HttpResponse create(AppUserDTO dto) {
        return ((AbstractProcessor) processor).create(dto);
    }

    @GET
    @Path("/{id}")
    public HttpResponse find(JaxRsHttpRequest req) {
        return ((AbstractProcessor) processor).find(req);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Valid
    public HttpResponse update(AppUserDTO dto, JaxRsHttpRequest req) {
        return ((AbstractProcessor) processor).update(dto, req);
    }

    @DELETE
    @Path("/{id}")
    public HttpResponse delete(JaxRsHttpRequest req) {
        return ((AbstractProcessor) processor).delete(req);
    }

    @GET
    @Path("/echo/{id}")
    public HttpResponse echo(JaxRsHttpRequest req) {
        return ((AbstractProcessor) processor).echo(req);
    }
}

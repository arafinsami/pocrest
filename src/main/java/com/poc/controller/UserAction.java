package com.poc.controller;

import com.poc.dto.AppUserDTO;
import com.poc.entity.AppUser;
import com.poc.mapper.AppUserMapper;
import com.poc.service.AppUserService;
import jakarta.inject.Singleton;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nablarch.core.repository.SystemRepository;
import nablarch.fw.jaxrs.JaxRsHttpRequest;
import nablarch.fw.web.HttpResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.poc.utils.JsonConverter.jsonResponse;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class UserAction {

    private final AppUserService appUserService = SystemRepository.get("appUserService");

    @GET
    public HttpResponse index() {
        List<AppUserDTO> users = appUserService.getAllUsers()
                .stream()
                .map(AppUserMapper::toDto)
                .toList();
        return jsonResponse(HttpResponse.Status.OK.getStatusCode(), users);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Valid
    public HttpResponse create(AppUserDTO dto) {
        AppUser saved = appUserService.createUser(AppUserMapper.toEntity(dto));
        return jsonResponse(HttpResponse.Status.CREATED.getStatusCode(), AppUserMapper.toDto(saved));
    }

    @GET
    @Path("/{id}")
    public HttpResponse find(JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUser> user = appUserService.getUserById(Long.parseLong(id));
        return user.map(value -> jsonResponse(HttpResponse.Status.OK.getStatusCode(), AppUserMapper.toDto(value)))
                .orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Valid
    public HttpResponse update(AppUserDTO dto, JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUser> updated = appUserService.updateUser(Long.parseLong(id), AppUserMapper.toEntity(dto));
        return updated.map(value -> jsonResponse(HttpResponse.Status.OK.getStatusCode(), AppUserMapper.toDto(value)))
                .orElseThrow(NotFoundException::new);
    }

    @DELETE
    @Path("/{id}")
    public HttpResponse delete(JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUser> deleted = appUserService.deleteUser(Long.parseLong(id));
        if (deleted.isEmpty()) {
            throw new NotFoundException();
        }
        return new HttpResponse(HttpResponse.Status.NO_CONTENT.getStatusCode());
    }

    @GET
    @Path("/echo/{id}")
    public HttpResponse echo(JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Map<String, String> payload = Map.of("echo", id);
        return jsonResponse(HttpResponse.Status.OK.getStatusCode(), payload);
    }
}

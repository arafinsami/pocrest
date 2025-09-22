package com.poc.api;

import com.poc.dto.AppUserDTO;
import com.poc.mapper.AppUserMapper;
import com.poc.service.AppUserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nablarch.core.repository.SystemRepository;

import java.util.List;
import java.util.Map;

@Path("/users")
public class AppUserApi {
    private final AppUserService appUserService = SystemRepository.get("appUserService");

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AppUserDTO> findAll() {
        return appUserService.getAllUsers().stream()
                .map(AppUserMapper::toDto)
                .toList();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> register(Map<String, Object> in) {
        in.put("status", "created");
        return in;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Object> findOne(@PathParam("id") String id) {
        return Map.of("id", id, "status", "ok");
    }
}

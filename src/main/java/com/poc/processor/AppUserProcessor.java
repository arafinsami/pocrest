package com.poc.processor;

import com.poc.dto.AppUserDTO;
import com.poc.entity.AppUser;
import com.poc.mapper.AppUserMapper;
import com.poc.service.AppUserService;
import jakarta.ws.rs.NotFoundException;
import nablarch.fw.jaxrs.JaxRsHttpRequest;
import nablarch.fw.web.HttpResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AppUserProcessor extends AbstractProcessor<AppUserDTO> {

    private AppUserService appUserService;

    public void setAppUserService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Override
    public HttpResponse index() {
        List<AppUserDTO> users = appUserService.getAllUsers()
                .stream()
                .map(AppUserMapper::toDto)
                .toList();
        return ok(users);
    }

    @Override
    public HttpResponse create(AppUserDTO dto) {
        AppUser saved = appUserService.createUser(AppUserMapper.toEntity(dto));
        return created(AppUserMapper.toDto(saved));
    }

    @Override
    public HttpResponse find(JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUser> user = appUserService.getUserById(Long.parseLong(id));
        return user.map(value -> ok(AppUserMapper.toDto(value)))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public HttpResponse update(AppUserDTO dto, JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUser> updated = appUserService.updateUser(Long.parseLong(id), AppUserMapper.toEntity(dto));
        return updated.map(value -> ok(AppUserMapper.toDto(value)))
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public HttpResponse delete(JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUser> deleted = appUserService.deleteUser(Long.parseLong(id));
        if (deleted.isEmpty()) {
            throw new NotFoundException();
        }
        return noContent();
    }

    @Override
    public HttpResponse echo(JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Map<String, String> payload = Map.of("echo", id);
        return ok(payload);
    }
}
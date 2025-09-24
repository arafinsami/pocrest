package com.poc.processor;

import com.poc.dto.AppUserDTO;
import com.poc.facade.BaseFacade;
import com.poc.facade.Facade;
import jakarta.ws.rs.NotFoundException;
import nablarch.fw.jaxrs.JaxRsHttpRequest;
import nablarch.fw.web.HttpResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AppUserProcessor extends AbstractProcessor<AppUserDTO> {

    private Facade appUserFacade;

    public void setAppUserFacade(Facade appUserFacade) {
        this.appUserFacade = appUserFacade;
    }

    private BaseFacade<AppUserDTO> userFacade() {
        return (BaseFacade<AppUserDTO>) appUserFacade;
    }

    @Override
    public HttpResponse index() {
        List<AppUserDTO> users = userFacade().getAll();
        return ok(users);
    }

    @Override
    public HttpResponse create(AppUserDTO dto) {
        AppUserDTO saved = userFacade().create(dto);
        return created(saved);
    }

    @Override
    public HttpResponse find(JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUserDTO> user = userFacade().getById(Long.parseLong(id));
        return user.map(this::ok)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public HttpResponse update(AppUserDTO dto, JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUserDTO> updated = userFacade().update(Long.parseLong(id), dto);
        return updated.map(this::ok)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public HttpResponse delete(JaxRsHttpRequest req) {
        String id = req.getParam("id")[0];
        Optional<AppUserDTO> deleted = userFacade().delete(Long.parseLong(id));
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

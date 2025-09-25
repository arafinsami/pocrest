package com.poc.core.abstracts;

import com.poc.context.BaseContext;
import com.poc.core.interfaces.BaseProcessor;
import com.poc.core.interfaces.IProcessorPipeline;
import jakarta.ws.rs.NotFoundException;
import lombok.Setter;
import nablarch.fw.jaxrs.JaxRsHttpRequest;
import nablarch.fw.web.HttpResponse;

import java.util.Map;

import static com.poc.utils.JsonConverter.jsonResponse;

@Setter
public abstract class AbstractProcessor<T, C extends BaseContext<T>> implements BaseProcessor<T> {

    protected IProcessorPipeline<C> indexPipeline;
    protected IProcessorPipeline<C> createPipeline;
    protected IProcessorPipeline<C> findPipeline;
    protected IProcessorPipeline<C> updatePipeline;
    protected IProcessorPipeline<C> deletePipeline;

    protected abstract C newContext();

    protected HttpResponse ok(Object body) {
        return jsonResponse(HttpResponse.Status.OK.getStatusCode(), body);
    }

    protected HttpResponse created(Object body) {
        return jsonResponse(HttpResponse.Status.CREATED.getStatusCode(), body);
    }

    protected HttpResponse noContent() {
        return new HttpResponse(HttpResponse.Status.NO_CONTENT.getStatusCode());
    }

    @Override
    public HttpResponse index() {
        C ctx = newContext();
        indexPipeline.execute(ctx);
        return ok(ctx.getResponseList());
    }

    @Override
    public HttpResponse create(T dto) {
        C ctx = newContext();
        ctx.setRequestDto(dto);
        createPipeline.execute(ctx);
        return created(ctx.getResponseDto());
    }

    @Override
    public HttpResponse find(JaxRsHttpRequest req) {
        Long id = Long.parseLong(req.getParam("id")[0]);
        C ctx = newContext();
        ctx.setId(id);
        findPipeline.execute(ctx);
        if (ctx.getResponseDto() == null) {
            throw new NotFoundException("Entity not found with id=" + id);
        }
        return ok(ctx.getResponseDto());
    }

    @Override
    public HttpResponse update(T dto, JaxRsHttpRequest req) {
        Long id = Long.parseLong(req.getParam("id")[0]);
        C ctx = newContext();
        ctx.setId(id);
        ctx.setRequestDto(dto);
        updatePipeline.execute(ctx);
        if (ctx.getResponseDto() == null) {
            throw new NotFoundException("Entity not found for update with id=" + id);
        }
        return ok(ctx.getResponseDto());
    }

    @Override
    public HttpResponse delete(JaxRsHttpRequest req) {
        Long id = Long.parseLong(req.getParam("id")[0]);
        C ctx = newContext();
        ctx.setId(id);
        deletePipeline.execute(ctx);
        if (ctx.getResponseDto() == null) {
            throw new NotFoundException("Entity not found for delete with id=" + id);
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
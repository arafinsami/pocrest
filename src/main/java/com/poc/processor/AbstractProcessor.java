package com.poc.processor;

import nablarch.fw.web.HttpResponse;

import static com.poc.utils.JsonConverter.jsonResponse;

public abstract class AbstractProcessor<T> implements BaseProcessor<T> {

    protected HttpResponse ok(Object body) {
        return jsonResponse(HttpResponse.Status.OK.getStatusCode(), body);
    }

    protected HttpResponse created(Object body) {
        return jsonResponse(HttpResponse.Status.CREATED.getStatusCode(), body);
    }

    protected HttpResponse noContent() {
        return new HttpResponse(HttpResponse.Status.NO_CONTENT.getStatusCode());
    }
}
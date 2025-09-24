package com.poc.processor;

import nablarch.fw.jaxrs.JaxRsHttpRequest;
import nablarch.fw.web.HttpResponse;

public interface BaseProcessor<T> extends Processor {

    default HttpResponse index() {
        throw new UnsupportedOperationException("index not implemented");
    }

    default HttpResponse create(T dto) {
        throw new UnsupportedOperationException("create not implemented");
    }

    default HttpResponse find(JaxRsHttpRequest req) {
        throw new UnsupportedOperationException("find not implemented");
    }

    default HttpResponse update(T dto, JaxRsHttpRequest req) {
        throw new UnsupportedOperationException("update not implemented");
    }

    default HttpResponse delete(JaxRsHttpRequest req) {
        throw new UnsupportedOperationException("delete not implemented");
    }

    default HttpResponse echo(JaxRsHttpRequest req) {
        throw new UnsupportedOperationException("echo not implemented");
    }
}

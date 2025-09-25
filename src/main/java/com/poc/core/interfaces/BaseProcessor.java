package com.poc.core.interfaces;

import nablarch.fw.jaxrs.JaxRsHttpRequest;
import nablarch.fw.web.HttpResponse;

public interface BaseProcessor<T> extends Processor {
    default HttpResponse index() {
        throw new UnsupportedOperationException();
    }

    default HttpResponse create(T dto) {
        throw new UnsupportedOperationException();
    }

    default HttpResponse find(JaxRsHttpRequest req) {
        throw new UnsupportedOperationException();
    }

    default HttpResponse update(T dto, JaxRsHttpRequest req) {
        throw new UnsupportedOperationException();
    }

    default HttpResponse delete(JaxRsHttpRequest req) {
        throw new UnsupportedOperationException();
    }

    default HttpResponse echo(JaxRsHttpRequest req) {
        throw new UnsupportedOperationException();
    }
}
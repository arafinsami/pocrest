package com.poc.core.abstracts;

import lombok.Setter;
import nablarch.core.repository.SystemRepository;
import nablarch.core.repository.di.ComponentFactory;

@Setter
public class LazyComponentFactory<T> implements ComponentFactory<T> {

    private String targetName;

    @SuppressWarnings("unchecked")
    @Override
    public T createObject() {
        return (T) SystemRepository.getObject(targetName);
    }
}

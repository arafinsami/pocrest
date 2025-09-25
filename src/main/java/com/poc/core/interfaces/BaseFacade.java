package com.poc.core.interfaces;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface BaseFacade<T> extends Facade {
    default List<T> getAll() {
        return Collections.emptyList();
    }

    default T create(T dto) {
        throw new UnsupportedOperationException("Create not implemented");
    }

    default Optional<T> getById(Long id) {
        return Optional.empty();
    }

    default Optional<T> update(Long id, T dto) {
        return Optional.empty();
    }

    default Optional<T> delete(Long id) {
        return Optional.empty();
    }
}

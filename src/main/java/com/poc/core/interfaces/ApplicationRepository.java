package com.poc.core.interfaces;

import java.util.List;

public interface ApplicationRepository<E, ID> {
    E findById(ID id);

    List<E> findAll();

    void insert(E entity);

    void update(E entity);

    void delete(E entity);

    void batchInsert(List<E> entities);

    void batchUpdate(List<E> entities);

    void batchDelete(List<E> entities);

    List<E> findBySqlFile(String sqlFileName, Object condition);

    E findOneBySqlFile(String sqlFileName, Object condition);
}

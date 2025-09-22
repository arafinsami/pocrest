package com.poc.repository;

import nablarch.common.dao.UniversalDao;

import java.util.List;

public abstract class AbstractApplicationRepository<E, ID> implements ApplicationRepository<E, ID> {

    private final Class<E> entityClass;

    protected AbstractApplicationRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public E findById(ID id) {
        return UniversalDao.findById(entityClass, id);
    }

    @Override
    public List<E> findAll() {
        return UniversalDao.findAll(entityClass);
    }

    @Override
    public void insert(E entity) {
        UniversalDao.insert(entity);
    }

    @Override
    public void update(E entity) {
        UniversalDao.update(entity);
    }

    @Override
    public void delete(E entity) {
        UniversalDao.delete(entity);
    }

    @Override
    public void batchInsert(List<E> entities) {
        UniversalDao.batchInsert(entities);
    }

    @Override
    public void batchUpdate(List<E> entities) {
        UniversalDao.batchUpdate(entities);
    }

    @Override
    public void batchDelete(List<E> entities) {
        UniversalDao.batchDelete(entities);
    }

    @Override
    public List<E> findBySqlFile(String sqlFileName, Object condition) {
        return UniversalDao.findAllBySqlFile(entityClass, sqlFileName, condition);
    }

    @Override
    public E findOneBySqlFile(String sqlFileName, Object condition) {
        return UniversalDao.findBySqlFile(entityClass, sqlFileName, condition);
    }
}

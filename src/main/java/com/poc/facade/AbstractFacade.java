package com.poc.facade;

public abstract class AbstractFacade<T> implements BaseFacade<T> {
    protected void logAction(String action) {
        System.out.println("Facade action: " + action);
    }
}

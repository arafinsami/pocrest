package com.poc.core.abstracts;

import com.poc.core.interfaces.BaseFacade;

public abstract class AbstractFacade<T> implements BaseFacade<T> {
    protected void logAction(String action) {
        System.out.println("Facade action: " + action);
    }
}

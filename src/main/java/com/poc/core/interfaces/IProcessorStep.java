package com.poc.core.interfaces;

@FunctionalInterface
public interface IProcessorStep<C> extends StepMarker {
    void execute(C context);
}

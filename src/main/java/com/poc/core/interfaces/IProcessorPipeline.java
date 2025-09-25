package com.poc.core.interfaces;

@FunctionalInterface
public interface IProcessorPipeline<C> extends PipelineMarker {
    void execute(C context);
}

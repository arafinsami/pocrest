package com.poc.core.pipeline;


import com.poc.context.BaseContext;
import com.poc.core.interfaces.IProcessorStep;

public class LoggingStep<C extends BaseContext<?>> implements IProcessorStep<C> {
    @Override
    public void execute(C context) {
        System.out.println("Pipeline executed. Status=" + context.getStatus());
    }
}
package com.poc.core.abstracts;

import com.poc.core.interfaces.IProcessorPipeline;
import com.poc.core.interfaces.IProcessorStep;
import lombok.Setter;

import java.util.List;

@Setter
public class RegistryProcessorPipeline<C> implements IProcessorPipeline<C> {
    private StepRegistry<C> stepRegistry;
    private List<String> stepNames;

    @Override
    public void execute(C context) {
        for (String name : stepNames) {
            IProcessorStep<C> step = stepRegistry.get(name);
            step.execute(context);
        }
    }
}

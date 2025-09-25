package com.poc.core.abstracts;

import com.poc.core.interfaces.IProcessorStep;

import java.util.HashMap;
import java.util.Map;

public class StepRegistry<C> {
    private final Map<String, IProcessorStep<C>> steps = new HashMap<>();

    public void register(String name, IProcessorStep<C> step) {
        steps.put(name, step);
    }

    public IProcessorStep<C> get(String name) {
        IProcessorStep<C> step = steps.get(name);
        if (step == null) throw new IllegalArgumentException("Step not found: " + name);
        return step;
    }
}

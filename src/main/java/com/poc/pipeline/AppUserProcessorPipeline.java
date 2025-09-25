package com.poc.pipeline;

import com.poc.context.AppUserContext;
import com.poc.core.interfaces.IProcessorPipeline;
import com.poc.core.interfaces.IProcessorStep;
import lombok.Setter;

import java.util.List;

@Setter
public class AppUserProcessorPipeline implements IProcessorPipeline<AppUserContext> {

    private List<IProcessorStep<AppUserContext>> steps;

    @Override
    public void execute(AppUserContext context) {
        for (IProcessorStep<AppUserContext> step : steps) {
            step.execute(context);
        }
    }
}

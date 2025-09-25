package com.poc.core.pipeline;

import com.poc.context.BaseContext;
import com.poc.core.interfaces.BaseFacade;
import com.poc.core.interfaces.IProcessorStep;
import lombok.Setter;

@Setter
public class FindStep<T, C extends BaseContext<T>> implements IProcessorStep<C> {
    private BaseFacade<T> facade;

    @Override
    public void execute(C context) {
        facade.getById(context.getId()).ifPresent(context::setResponseDto);
    }
}


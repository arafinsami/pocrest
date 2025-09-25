package com.poc.core.abstracts;

import com.poc.context.BaseContext;
import com.poc.context.ProcessorStatus;
import com.poc.core.interfaces.IProcessorStep;
import lombok.Setter;

@Setter
public class ConditionalStep<C extends BaseContext<?>> implements IProcessorStep<C> {
    private ProcessorStatus expected;
    private IProcessorStep<C> delegate;

    @Override
    public void execute(C context) {
        if (context.getStatus() == expected) {
            delegate.execute(context);
        }
    }
}

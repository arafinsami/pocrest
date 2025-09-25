package com.poc.core.pipeline;

import com.poc.core.interfaces.IProcessorStep;
import nablarch.core.message.ApplicationException;
import nablarch.core.message.MessageLevel;
import nablarch.core.message.MessageUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class ValidationStep<C, D> implements IProcessorStep<C> {
    private final Function<C, D> extractor;
    private final Predicate<D> validator;
    private final String errorCode;
    private final String errorMessage;

    public ValidationStep(Function<C, D> extractor,
                          Predicate<D> validator,
                          String errorCode,
                          String errorMessage) {
        this.extractor = extractor;
        this.validator = validator;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public void execute(C context) {
        D dto = extractor.apply(context);
        if (!validator.test(dto)) {
            throw new ApplicationException(
                    MessageUtil.createMessage(MessageLevel.ERROR, errorCode, errorMessage)
            );
        }
    }
}

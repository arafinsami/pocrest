package com.poc.processor;

import com.poc.context.AppUserContext;
import com.poc.core.abstracts.AbstractProcessor;
import com.poc.dto.AppUserDTO;
import lombok.Setter;

@Setter
public class AppUserProcessor extends AbstractProcessor<AppUserDTO, AppUserContext> {

    @Override
    protected AppUserContext newContext() {
        return new AppUserContext();
    }
}
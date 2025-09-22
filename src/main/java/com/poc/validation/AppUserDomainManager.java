package com.poc.validation;

import com.poc.dto.AppUserDTO;
import nablarch.core.validation.ee.DomainManager;

public class AppUserDomainManager implements DomainManager<AppUserDTO> {
    @Override
    public Class<AppUserDTO> getDomainBean() {
        return AppUserDTO.class;
    }
}

package com.poc.repository;

import com.poc.entity.AppUser;

public class AppUserRepository extends AbstractApplicationRepository<AppUser, Long> {

    public AppUserRepository() {
        super(AppUser.class);
    }
}

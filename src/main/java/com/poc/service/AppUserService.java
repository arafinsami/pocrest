package com.poc.service;

import com.poc.entity.AppUser;
import com.poc.repository.AppUserRepository;
import lombok.Setter;

import java.util.List;

@Setter
public class AppUserService {

    private AppUserRepository appUserRepository;

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public AppUser getUser(Long id) {
        return appUserRepository.findById(id);
    }

    public void createUser(AppUser user) {
        appUserRepository.insert(user);
    }

    public void updateUser(AppUser user) {
        appUserRepository.update(user);
    }

    public void deleteUser(Long id) {
        AppUser user = appUserRepository.findById(id);
        if (user != null) {
            appUserRepository.delete(user);
        }
    }
}

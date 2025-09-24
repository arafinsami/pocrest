package com.poc.service;

import com.poc.entity.AppUser;
import com.poc.repository.AppUserRepository;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Setter
public class AppUserService {

    private AppUserRepository appUserRepository;

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public Optional<AppUser> getUserById(Long id) {
        return Optional.ofNullable(appUserRepository.findById(id));
    }

    public AppUser createUser(AppUser user) {
        appUserRepository.insert(user);
        return user;
    }

    public Optional<AppUser> updateUser(Long id, AppUser updated) {
        AppUser existing = appUserRepository.findById(id);
        if (existing == null) {
            return Optional.empty();
        }
        updated.setId(id);
        appUserRepository.update(updated);
        return Optional.of(updated);
    }

    public Optional<AppUser> deleteUser(Long id) {
        AppUser existing = appUserRepository.findById(id);
        if (existing == null) {
            return Optional.empty();
        }
        appUserRepository.delete(existing);
        return Optional.of(existing);
    }
}

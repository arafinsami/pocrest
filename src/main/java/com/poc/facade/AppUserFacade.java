package com.poc.facade;

import com.poc.core.abstracts.AbstractFacade;
import com.poc.dto.AppUserDTO;
import com.poc.entity.AppUser;
import com.poc.mapper.AppUserMapper;
import com.poc.service.AppUserService;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Setter
public class AppUserFacade extends AbstractFacade<AppUserDTO> {

    private AppUserService appUserService;

    @Override
    public List<AppUserDTO> getAll() {
        return appUserService.getAllUsers()
                .stream()
                .map(AppUserMapper::toDto)
                .toList();
    }

    @Override
    public AppUserDTO create(AppUserDTO dto) {
        AppUser saved = appUserService.createUser(AppUserMapper.toEntity(dto));
        return AppUserMapper.toDto(saved);
    }

    @Override
    public Optional<AppUserDTO> getById(Long id) {
        return appUserService.getUserById(id)
                .map(AppUserMapper::toDto);
    }

    @Override
    public Optional<AppUserDTO> update(Long id, AppUserDTO dto) {
        return appUserService.updateUser(id, AppUserMapper.toEntity(dto))
                .map(AppUserMapper::toDto);
    }

    @Override
    public Optional<AppUserDTO> delete(Long id) {
        return appUserService.deleteUser(id)
                .map(AppUserMapper::toDto);
    }
}

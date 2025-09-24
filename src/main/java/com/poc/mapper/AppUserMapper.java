package com.poc.mapper;

import com.poc.dto.AppUserDTO;
import com.poc.entity.AppUser;

public class AppUserMapper {

    public static AppUserDTO toDto(AppUser appUser) {
        return AppUserDTO.builder()
                .id(appUser.getId())
                .firstName(appUser.getFirstName())
                .lastName(appUser.getLastName())
                .email(appUser.getEmail())
                .build();
    }

    public static AppUser toEntity(AppUserDTO dto) {
        return AppUser.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}
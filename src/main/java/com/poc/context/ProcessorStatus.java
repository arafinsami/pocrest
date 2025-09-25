package com.poc.context;

import lombok.Getter;

@Getter
public enum ProcessorStatus {
    APP_USER_INDEX("appUserIndex"),
    APP_USER_CREATE("appUserCreate"),
    APP_USER_FIND("appUserFind"),
    APP_USER_UPDATE("appUserUpdate"),
    APP_USER_DELETE("appUserDelete");

    private final String status;

    ProcessorStatus(String status) {
        this.status = status;
    }
}

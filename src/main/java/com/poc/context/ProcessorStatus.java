package com.poc.context;

import lombok.Getter;

@Getter
public enum ProcessorStatus {
    RENEW("renew"),
    SETTLEMENT("settlement"),
    CONTINUE("continue"),
    LUCK("luck"),
    FIRST("first"),
    CONTINUENOWIN("continue"),
    RENEWWIN("renew"),
    CONTINUEWIN("continueWin");

    private String status;

    ProcessorStatus(String status) {
        this.status = status;
    }
}

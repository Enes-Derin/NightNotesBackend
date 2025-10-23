package com.enesderin.NightNotes.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    NOTE_NOT_FOUND("1001","Not Bulunamadı");

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

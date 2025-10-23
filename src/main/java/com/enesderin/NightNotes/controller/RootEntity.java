package com.enesderin.NightNotes.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity<T> {
    private Integer status;
    private T payload;
    private String errorMessage;

    public static <T> RootEntity<T> ok(T payload) {
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.payload = payload;
        rootEntity.status = HttpStatus.OK.value();
        rootEntity.errorMessage = null;
        return rootEntity;
    }
    public static <T> RootEntity<T> error(String errorMessage) {
        RootEntity<T> rootEntity = new RootEntity<>();
        rootEntity.payload = null;
        rootEntity.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        rootEntity.errorMessage = errorMessage;
        return rootEntity;
    }
}

package com.enesderin.NightNotes.exception;

import com.enesderin.NightNotes.exception.handler.ApiError;
import com.enesderin.NightNotes.exception.handler.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;

public class BaseException extends RuntimeException {

    public BaseException(ErrorMessage message) {
        super(message.prepareErrorMessage());
    }




}

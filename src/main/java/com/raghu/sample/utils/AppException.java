package com.raghu.sample.utils;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends Exception {

    private final HttpStatus status;

    public AppException(String detail){
        super(detail,null);
        this.status = null;
    }

    public AppException(String detail, HttpStatus status){
        super(detail,null);
        this.status = status;
    }

    public AppException(String detail, Throwable cause){
        super(detail,cause);
        this.status=HttpStatus.INTERNAL_SERVER_ERROR;
    }
}

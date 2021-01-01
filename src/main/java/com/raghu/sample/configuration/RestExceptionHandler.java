package com.raghu.sample.configuration;

import com.raghu.sample.utils.AppErrorResponse;
import com.raghu.sample.utils.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppErrorResponse> convertToAppResponse(Exception ex) {
        AppErrorResponse errorResponse = AppErrorResponse.builder().cause(ex.getCause().getStackTrace()[0].toString())
                .message("Sorry error message = " + ex.getMessage())
                .uuid(UUID.randomUUID())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        if (ex instanceof AppException) {
            errorResponse = AppErrorResponse.builder().cause(ex.getCause().getStackTrace()[0].toString())
                    .message(ex.getMessage())
                    .uuid(UUID.randomUUID())
                    .status(((AppException) ex).getStatus())
                    .build();
        }
        if (ex instanceof AccessDeniedException)
            return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

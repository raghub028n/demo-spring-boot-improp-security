package com.raghu.sample.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class AppErrorResponse {
    private String message;
    private UUID uuid;
    @JsonIgnore
    private HttpStatus status;
    private String cause;
}

package org.example.rest.advice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

import static java.util.Collections.singletonList;

@Getter
public class ApiException {
    private final HttpStatus status;
    private final String message;
    private final List<String> errors;

    public ApiException(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiException(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = singletonList(error);
    }
}

package ru.makhach.proteus.exceptions.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ProteusException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ProteusException() {
        super();
    }

    public ProteusException(String message) {
        super(message);
    }

    public ProteusException(String message, Throwable cause) {
        super(message, cause);
    }
}

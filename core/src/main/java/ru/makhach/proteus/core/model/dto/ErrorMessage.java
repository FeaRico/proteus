package ru.makhach.proteus.core.model.dto;

import org.springframework.http.HttpStatus;

/**
 * Трансферный объект для сообщения с ошибкой
 */
public class ErrorMessage {
    private final Long createdAt;
    private final Integer statusCode;
    private final String statusMessage;
    private final String message;

    public ErrorMessage(Long createdAt, HttpStatus status, String message) {
        this.createdAt = createdAt;
        this.statusCode = status.value();
        this.statusMessage = status.getReasonPhrase();
        this.message = message;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public String getMessage() {
        return message;
    }
}

package ru.makhach.vesselmanager.model.transfer;

public class ErrorMessage {
    private final Long createdTime;
    private final String status;
    private final String message;

    public ErrorMessage(Long createdTime, String status, String message) {
        this.createdTime = createdTime;
        this.status = status;
        this.message = message;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}

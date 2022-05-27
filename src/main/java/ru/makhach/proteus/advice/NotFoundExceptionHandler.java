package ru.makhach.proteus.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import ru.makhach.proteus.exceptions.ResourceNotFoundException;
import ru.makhach.proteus.model.dto.ErrorMessage;

@ControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessage> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}

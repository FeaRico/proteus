package ru.makhach.proteus.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.makhach.proteus.model.dto.ErrorMessage;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ValidateExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<ErrorMessage> handleConstrainViolationException(ConstraintViolationException ex) {
        ErrorMessage errorMessage = new ErrorMessage(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}

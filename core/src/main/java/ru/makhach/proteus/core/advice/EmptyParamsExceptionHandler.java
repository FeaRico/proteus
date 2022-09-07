package ru.makhach.proteus.core.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.makhach.proteus.core.exceptions.EmptyParametersException;
import ru.makhach.proteus.core.model.dto.ErrorMessage;

/**
 * Обработка {@link EmptyParametersException}
 */
@ControllerAdvice
public class EmptyParamsExceptionHandler {
    @ExceptionHandler(EmptyParametersException.class)
    ResponseEntity<ErrorMessage> handleEmptyParametersException(EmptyParametersException ex) {
        ErrorMessage errorMessage = new ErrorMessage(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
package ru.makhach.proteus.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.makhach.proteus.core.exceptions.base.ProteusException;

/**
 * Ошибка вызова метода, требующий параметры, без параметров
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyParametersException extends ProteusException {
    private static final long serialVersionUID = 1L;

    public EmptyParametersException() {
        super("This method required at least one parameter");
    }
}

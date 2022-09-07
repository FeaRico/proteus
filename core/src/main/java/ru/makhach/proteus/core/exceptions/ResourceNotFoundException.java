package ru.makhach.proteus.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.makhach.proteus.core.exceptions.base.ProteusException;

import java.util.Locale;

/**
 * Ошибка недоступности ресурса
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ProteusException {
    private static final long serialVersionUID = 1L;
    private final Class<?> resourceClass;
    private final String fieldName;
    private final Object fieldValue;

    public ResourceNotFoundException(Class<?> resourceClass, String fieldName, Object fieldValue) {
        super(String.format("Not found %s with %s is %s", resourceClass.getSimpleName().toLowerCase(Locale.ROOT),
                fieldName, fieldValue));
        this.resourceClass = resourceClass;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceClassName() {
        return resourceClass.getSimpleName();
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
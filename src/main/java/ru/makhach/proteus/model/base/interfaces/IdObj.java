package ru.makhach.proteus.model.base.interfaces;

import java.io.Serializable;

/**
 * Интерфейс для объектов с идентификаторами
 */
public interface IdObj extends Serializable {
    Long getId();
}

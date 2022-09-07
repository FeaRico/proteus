package ru.makhach.proteus.core.model.base.interfaces;

/**
 * Интерфейс для объектов с координатами
 */
public interface CoordObj extends NamedObj {
    Double getLatitude();

    Double getLongitude();
}

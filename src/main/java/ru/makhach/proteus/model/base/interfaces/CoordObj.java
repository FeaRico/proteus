package ru.makhach.proteus.model.base.interfaces;

/**
 * Интерфейс для объектов с координатами
 */
public interface CoordObj extends NamedObj {
    Double getLatitude();

    Double getLongitude();
}

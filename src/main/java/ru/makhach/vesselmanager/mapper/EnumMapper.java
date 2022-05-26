package ru.makhach.vesselmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.makhach.vesselmanager.model.util.Status;
import ru.makhach.vesselmanager.model.util.Type;

@Mapper(componentModel = "spring")
public interface EnumMapper {
    @Named("stringTypeToEnum")
    default Type convertType(String name) {
        return Type.getTypeByName(name);
    }

    @Named("stringStatusToEnum")
    default Status convertStatus(String description) {
        return Status.getStatusByDescription(description);
    }

    @Named("enumTypeToString")
    default String convertType(Type type) {
        return type.getName();
    }

    @Named("enumStatusToString")
    default String convertStatus(Status status) {
        return status.getDescription();
    }
}

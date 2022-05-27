package ru.makhach.proteus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.makhach.proteus.model.dto.base.CountryDto;
import ru.makhach.proteus.model.entity.Country;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto convert(Country country);

    @Named("countryDtoToEntity")
    Country convert(CountryDto countryDto);

    List<CountryDto> convertToDtos(List<Country> countries);

    List<Country> convertToEntities(List<CountryDto> countriesDto);
}

package ru.makhach.vesselmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.makhach.vesselmanager.model.dto.CountryDto;
import ru.makhach.vesselmanager.model.entity.Country;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto convert(Country country);

    @Named("countryDtoToEntity")
    Country convert(CountryDto countryDto);

    List<CountryDto> convertToDtos(List<Country> countries);

    List<Country> convertToEntities(List<CountryDto> countriesDto);
}

package ru.makhach.proteus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.makhach.proteus.model.dto.base.CityDto;
import ru.makhach.proteus.model.dto.base.CountryDto;
import ru.makhach.proteus.model.entity.City;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface CityMapper {
    @Mappings({
            @Mapping(target = "countryId", source = "city.country.id")
    })
    CityDto convert(City city);

    @Named("cityDtoToEntity")
    City convert(CityDto cityDto);

    @Mappings({
            @Mapping(target = "id", source = "cityDto.id"),
            @Mapping(target = "name", source = "cityDto.name"),
            @Mapping(target = "country", source = "countryDto", qualifiedByName = "countryDtoToEntity")
    })
    City convert(CityDto cityDto, CountryDto countryDto);

    List<CityDto> convertToDtos(List<City> cities);

    @Named("citiesDtoToEntity")
    List<City> convertToEntities(List<CityDto> citiesDto);
}

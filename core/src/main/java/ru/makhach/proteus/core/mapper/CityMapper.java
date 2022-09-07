package ru.makhach.proteus.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.base.CityDto;
import ru.makhach.proteus.core.model.dto.base.CountryDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.core.model.entity.City;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface CityMapper {
    @Mappings({
            @Mapping(target = "countryId", source = "city.country.id")
    })
    CityDto convert(City city);

    @Named("cityDtoToEntity")
    @Mapping(target = "createdAt", expression = "java(System.currentTimeMillis())")
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

    default PageResponse<List<CityDto>> convertToPageResponse(Page<City> page, PageRequest request) {
        return PageResponse.<List<CityDto>>builder()
                .content(convertToDtos(page.getContent()))
                .pageElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .pageNumber(page.getNumber())
                .totalPages(page.getTotalPages())
                .sortBy(request.getSortBy())
                .sortDir(request.getSortDir())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }
}

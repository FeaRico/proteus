package ru.makhach.proteus.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.base.CountryDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.core.model.entity.Country;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryDto convert(Country country);

    @Named("countryDtoToEntity")
    @Mapping(target = "createdAt", expression = "java(System.currentTimeMillis())")
    Country convert(CountryDto countryDto);

    List<CountryDto> convertToDtos(List<Country> countries);

    List<Country> convertToEntities(List<CountryDto> countriesDto);

    default PageResponse<List<CountryDto>> convertToPageResponse(Page<Country> page, PageRequest request) {
        return PageResponse.<List<CountryDto>>builder()
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
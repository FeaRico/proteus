package ru.makhach.proteus.model.dto.filter;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PageResponse<T> {
    private final T content;
    private final Integer pageElements;
    private final Long totalElements;
    private final Integer pageNumber;
    private final Integer totalPages;
    private final String sortBy;
    private final String sortDir;
    private final Boolean isFirst;
    private final Boolean isLast;
}

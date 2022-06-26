package ru.makhach.proteus.model.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageRequest {
    private final Integer pageNum;
    private final Integer pageSize;
    private final String sortBy;
    private final String sortDir;
}

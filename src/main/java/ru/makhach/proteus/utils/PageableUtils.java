package ru.makhach.proteus.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PageableUtils {
    public static Pageable pageableFromRequest(ru.makhach.proteus.model.dto.filter.pageable.PageRequest request) {
        String sortBy = request.getSortBy();
        Sort sort = Sort.Direction.ASC
                .name()
                .equalsIgnoreCase(request.getSortDir()) ? Sort.by(sortBy)
                .ascending() : Sort.by(sortBy)
                .descending();
        return PageRequest.of(request.getPageNum(), request.getPageSize(), sort);
    }
}

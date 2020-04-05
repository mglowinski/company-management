package com.mglowinski.companymanagement.model.mapper;

import com.mglowinski.companymanagement.model.dto.PageDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface Mapper<F, T> {

    T map(F from);

    default List<T> mapAll(List<F> fromElements) {
        return fromElements.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    default PageDTO<T> mapPage(Page<F> fromPage) {
        return new PageDTO<>(
                fromPage.getNumber(),
                fromPage.getSize(),
                fromPage.getTotalPages(),
                fromPage.getTotalElements(),
                fromPage.isLast(),
                mapAll(fromPage.getContent())
        );
    }

}

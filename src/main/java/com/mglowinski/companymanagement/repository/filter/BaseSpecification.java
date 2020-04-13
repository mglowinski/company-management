package com.mglowinski.companymanagement.repository.filter;

import org.springframework.data.jpa.domain.Specification;

public interface BaseSpecification<T, R> {

    String wildcard = "%";

    Specification<T> getFilter(R request);

    default String containsLowerCase(String searchField) {
        return wildcard + searchField.toLowerCase() + wildcard;
    }

}

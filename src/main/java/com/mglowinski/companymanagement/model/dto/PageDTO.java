package com.mglowinski.companymanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageDTO<T> {

    private int page;
    private int size;
    private int totalPages;
    private int totalElements;
    private boolean last;
    private List<T> elements;
}

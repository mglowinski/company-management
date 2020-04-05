package com.mglowinski.companymanagement.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskEmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
}

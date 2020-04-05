package com.mglowinski.companymanagement.model.dto;

import lombok.Builder;
import lombok.Data;

import java.io.File;

@Data
@Builder
public class TaskAdditionalInfoDTO {

    private Long id;
    private String description;
    private File attachment;
}

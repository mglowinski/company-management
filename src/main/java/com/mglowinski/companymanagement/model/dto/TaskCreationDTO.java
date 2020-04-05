package com.mglowinski.companymanagement.model.dto;

import com.mglowinski.companymanagement.model.TaskLevel;
import com.mglowinski.companymanagement.model.TaskStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskCreationDTO {

    private String description;
    private TaskLevel level;
    private TaskStatus status;
}

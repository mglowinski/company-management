package com.mglowinski.companymanagement.model.dto;

import com.mglowinski.companymanagement.model.TaskLevel;
import com.mglowinski.companymanagement.model.TaskStatus;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TaskDTO {

    private Long id;
    private String description;
    private TaskLevel level;
    private TaskStatus status;
    private TaskEmployeeDTO employee;
    private List<TaskAdditionalInfoDTO> additionalInfos;
}

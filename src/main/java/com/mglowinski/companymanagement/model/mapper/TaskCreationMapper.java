package com.mglowinski.companymanagement.model.mapper;

import com.mglowinski.companymanagement.model.dto.TaskCreationDTO;
import com.mglowinski.companymanagement.model.entity.Task;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class TaskCreationMapper implements Mapper<TaskCreationDTO, Task> {

    @Override
    public Task map(TaskCreationDTO from) {
        return Task.builder()
                .description(from.getDescription())
                .level(from.getLevel())
                .status(from.getStatus())
                .employee(from.getEmployee())
                .taskAdditionalInfos(Collections.emptyList())
                .build();
    }

}

package com.mglowinski.companymanagement.model.mapper;

import com.mglowinski.companymanagement.model.dto.TaskDTO;
import com.mglowinski.companymanagement.model.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements Mapper<Task, TaskDTO> {

    @Override
    public TaskDTO map(Task from) {
        return TaskDTO.builder()
                .id(from.getId())
                .description(from.getDescription())
                .taskLevel(from.getTaskLevel())
                .taskStatus(from.getTaskStatus())
                .taskAdditionalInfos(from.getTaskAdditionalInfos())
                .build();
    }

}

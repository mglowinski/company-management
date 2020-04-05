package com.mglowinski.companymanagement.model.mapper;

import com.mglowinski.companymanagement.model.dto.TaskAdditionalInfoDTO;
import com.mglowinski.companymanagement.model.dto.TaskDTO;
import com.mglowinski.companymanagement.model.dto.TaskEmployeeDTO;
import com.mglowinski.companymanagement.model.entity.Employee;
import com.mglowinski.companymanagement.model.entity.Task;
import com.mglowinski.companymanagement.model.entity.TaskAdditionalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper implements Mapper<Task, TaskDTO> {

    private final Mapper<Employee, TaskEmployeeDTO> taskEmployeeMapper;
    private final Mapper<TaskAdditionalInfo, TaskAdditionalInfoDTO> taskAdditionalInfoMapper;

    @Override
    public TaskDTO map(Task from) {
        return TaskDTO.builder()
                .id(from.getId())
                .description(from.getDescription())
                .level(from.getLevel())
                .status(from.getStatus())
                .employee(taskEmployeeMapper.map(from.getEmployee()))
                .additionalInfos(taskAdditionalInfoMapper.mapAll(from.getTaskAdditionalInfos()))
                .build();
    }

}

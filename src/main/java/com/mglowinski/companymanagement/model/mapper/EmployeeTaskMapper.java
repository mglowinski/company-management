package com.mglowinski.companymanagement.model.mapper;

import com.mglowinski.companymanagement.model.dto.EmployeeTaskDTO;
import com.mglowinski.companymanagement.model.dto.TaskAdditionalInfoDTO;
import com.mglowinski.companymanagement.model.entity.Task;
import com.mglowinski.companymanagement.model.entity.TaskAdditionalInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeTaskMapper implements Mapper<Task, EmployeeTaskDTO> {

    private final Mapper<TaskAdditionalInfo, TaskAdditionalInfoDTO> taskAdditionalInfoMapper;

    @Override
    public EmployeeTaskDTO map(Task from) {
        return EmployeeTaskDTO.builder()
                .id(from.getId())
                .description(from.getDescription())
                .level(from.getLevel())
                .status(from.getStatus())
                .additionalInfos(taskAdditionalInfoMapper.mapAll(from.getTaskAdditionalInfos()))
                .build();
    }

}

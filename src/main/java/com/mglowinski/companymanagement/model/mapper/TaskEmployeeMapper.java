package com.mglowinski.companymanagement.model.mapper;

import com.mglowinski.companymanagement.model.dto.TaskEmployeeDTO;
import com.mglowinski.companymanagement.model.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class TaskEmployeeMapper implements Mapper<Employee, TaskEmployeeDTO> {

    @Override
    public TaskEmployeeDTO map(Employee from) {
        if (from != null) {
            return TaskEmployeeDTO.builder()
                    .id(from.getId())
                    .firstName(from.getFirstName())
                    .lastName(from.getLastName())
                    .build();
        }
        return null;
    }

}

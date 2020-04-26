package com.mglowinski.companymanagement.model.mapper;

import com.mglowinski.companymanagement.model.dto.EmployeeDTO;
import com.mglowinski.companymanagement.model.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper implements Mapper<Employee, EmployeeDTO> {

    private final EmployeeTaskMapper employeeTaskMapper;

    @Override
    public EmployeeDTO map(Employee from) {
        return EmployeeDTO.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .email(from.getEmail())
                .address(from.getAddress())
                .roles(from.getRoles())
                .tasks(employeeTaskMapper.mapAll(from.getTasks()))
                .build();
    }

}

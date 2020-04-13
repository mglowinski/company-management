package com.mglowinski.companymanagement.service.impl;

import com.mglowinski.companymanagement.model.EmployeeSearchQuery;
import com.mglowinski.companymanagement.model.dto.EmployeeDTO;
import com.mglowinski.companymanagement.model.dto.PageDTO;
import com.mglowinski.companymanagement.model.entity.Employee;
import com.mglowinski.companymanagement.model.mapper.Mapper;
import com.mglowinski.companymanagement.repository.EmployeeRepository;
import com.mglowinski.companymanagement.repository.filter.BaseSpecification;
import com.mglowinski.companymanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final BaseSpecification<Employee, EmployeeSearchQuery> userListSpecification;
    private final Mapper<Employee, EmployeeDTO> employeeMapper;

    @Override
    public PageDTO<EmployeeDTO> getEmployees(EmployeeSearchQuery employeeSearchQuery,
                                             Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAll(
                userListSpecification.getFilter(employeeSearchQuery), pageable);
        return employeeMapper.mapPage(employeePage);
    }

}

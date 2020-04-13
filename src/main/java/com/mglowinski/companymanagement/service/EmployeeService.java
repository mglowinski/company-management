package com.mglowinski.companymanagement.service;

import com.mglowinski.companymanagement.model.EmployeeSearchQuery;
import com.mglowinski.companymanagement.model.dto.EmployeeDTO;
import com.mglowinski.companymanagement.model.dto.PageDTO;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    PageDTO<EmployeeDTO> getEmployees(EmployeeSearchQuery employeeSearchQuery, Pageable pageable);
}

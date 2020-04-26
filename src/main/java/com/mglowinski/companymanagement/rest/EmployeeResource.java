package com.mglowinski.companymanagement.rest;

import com.mglowinski.companymanagement.model.EmployeeSearchQuery;
import com.mglowinski.companymanagement.model.dto.EmployeeDTO;
import com.mglowinski.companymanagement.model.dto.PageDTO;
import com.mglowinski.companymanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeResource {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<PageDTO<EmployeeDTO>> getEmployees(EmployeeSearchQuery employeeSearchQuery,
                                                             Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeService.getEmployees(employeeSearchQuery, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(employeeService.getEmployee(id));
    }

}

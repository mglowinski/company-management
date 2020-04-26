package com.mglowinski.companymanagement.model.dto;

import com.mglowinski.companymanagement.model.entity.Address;
import com.mglowinski.companymanagement.model.entity.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Set<Role> roles;
    private List<EmployeeTaskDTO> tasks;
}

package com.mglowinski.companymanagement.repository.filter;

import com.mglowinski.companymanagement.model.EmployeeSearchQuery;
import com.mglowinski.companymanagement.model.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeListSpecification implements BaseSpecification<Employee, EmployeeSearchQuery> {

    @Override
    public Specification<Employee> getFilter(EmployeeSearchQuery employeeSearchQuery) {
        return firstNameContains(employeeSearchQuery.getFirstName())
                .or(lastNameContains(employeeSearchQuery.getLastName()));
    }

    private Specification<Employee> firstNameContains(String firstName) {
        return attributeContains("firstName", firstName);
    }

    private Specification<Employee> lastNameContains(String lastName) {
        return attributeContains("lastName", lastName);
    }

    private Specification<Employee> attributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if (value == null) {
                return null;
            }

            return cb.like(
                    cb.lower(root.get(attribute)),
                    containsLowerCase(value));
        };
    }

}

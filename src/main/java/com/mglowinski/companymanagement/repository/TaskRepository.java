package com.mglowinski.companymanagement.repository;

import com.mglowinski.companymanagement.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

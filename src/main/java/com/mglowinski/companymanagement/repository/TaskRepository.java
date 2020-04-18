package com.mglowinski.companymanagement.repository;

import com.mglowinski.companymanagement.model.TaskStatus;
import com.mglowinski.companymanagement.model.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t from Task t where (:status is null or t.status = :status)")
    Page<Task> findAllByStatus(TaskStatus status, Pageable pageable);
}

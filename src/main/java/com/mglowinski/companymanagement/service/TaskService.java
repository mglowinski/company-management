package com.mglowinski.companymanagement.service;

import com.mglowinski.companymanagement.model.TaskStatus;
import com.mglowinski.companymanagement.model.dto.PageDTO;
import com.mglowinski.companymanagement.model.dto.TaskCreationDTO;
import com.mglowinski.companymanagement.model.dto.TaskDTO;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    PageDTO<TaskDTO> getTasks(TaskStatus taskStatus, Pageable pageable);

    TaskDTO createTask(TaskCreationDTO taskCreationDTO);
}

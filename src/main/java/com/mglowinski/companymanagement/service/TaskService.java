package com.mglowinski.companymanagement.service;

import com.mglowinski.companymanagement.model.dto.PageDTO;
import com.mglowinski.companymanagement.model.dto.TaskDTO;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    PageDTO<TaskDTO> getTasks(Pageable pageable);
}

package com.mglowinski.companymanagement.rest;

import com.mglowinski.companymanagement.model.TaskStatus;
import com.mglowinski.companymanagement.model.dto.PageDTO;
import com.mglowinski.companymanagement.model.dto.TaskCreationDTO;
import com.mglowinski.companymanagement.model.dto.TaskDTO;
import com.mglowinski.companymanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskResource {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<PageDTO<TaskDTO>> getTasks(@RequestParam(required = false) TaskStatus status,
                                                     Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks(status, pageable));
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskCreationDTO taskCreationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createTask(taskCreationDTO));
    }

}

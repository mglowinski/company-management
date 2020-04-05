package com.mglowinski.companymanagement.rest;

import com.mglowinski.companymanagement.model.dto.PageDTO;
import com.mglowinski.companymanagement.model.dto.TaskDTO;
import com.mglowinski.companymanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskResource {

    private final TaskService taskService;

    @GetMapping
    public ResponseEntity<PageDTO<TaskDTO>> getTasks(Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(taskService.getTasks(pageable));
    }

}

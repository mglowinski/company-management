package com.mglowinski.companymanagement.service.impl;

import com.mglowinski.companymanagement.model.dto.PageDTO;
import com.mglowinski.companymanagement.model.dto.TaskCreationDTO;
import com.mglowinski.companymanagement.model.dto.TaskDTO;
import com.mglowinski.companymanagement.model.entity.Task;
import com.mglowinski.companymanagement.model.mapper.Mapper;
import com.mglowinski.companymanagement.repository.TaskRepository;
import com.mglowinski.companymanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final Mapper<Task, TaskDTO> taskMapper;
    private final Mapper<TaskCreationDTO, Task> taskCreationMapper;

    @Override
    public PageDTO<TaskDTO> getTasks(Pageable pageable) {
        Page<Task> tasks = taskRepository.findAll(pageable);
        return taskMapper.mapPage(tasks);
    }

    @Override
    public TaskDTO createTask(TaskCreationDTO taskCreationDTO) {
        Task task = taskCreationMapper.map(taskCreationDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.map(savedTask);
    }

}

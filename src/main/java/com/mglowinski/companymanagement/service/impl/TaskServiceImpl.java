package com.mglowinski.companymanagement.service.impl;

import com.mglowinski.companymanagement.model.TaskStatus;
import com.mglowinski.companymanagement.model.dto.PageDTO;
import com.mglowinski.companymanagement.model.dto.TaskCreationDTO;
import com.mglowinski.companymanagement.model.dto.TaskDTO;
import com.mglowinski.companymanagement.model.dto.TaskEmployeeAssignDTO;
import com.mglowinski.companymanagement.model.entity.Employee;
import com.mglowinski.companymanagement.model.entity.Task;
import com.mglowinski.companymanagement.model.mapper.Mapper;
import com.mglowinski.companymanagement.repository.EmployeeRepository;
import com.mglowinski.companymanagement.repository.TaskRepository;
import com.mglowinski.companymanagement.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final Mapper<Task, TaskDTO> taskMapper;
    private final Mapper<TaskCreationDTO, Task> taskCreationMapper;

    @Override
    public PageDTO<TaskDTO> getTasks(TaskStatus taskStatus, Pageable pageable) {
        Page<Task> tasks = taskRepository.findAllByStatus(taskStatus, pageable);
        return taskMapper.mapPage(tasks);
    }

    @Override
    public TaskDTO createTask(TaskCreationDTO taskCreationDTO) {
        Task task = taskCreationMapper.map(taskCreationDTO);
        Task savedTask = taskRepository.save(task);
        return taskMapper.map(savedTask);
    }

    @Override
    public TaskDTO assignEmployee(Long taskId, TaskEmployeeAssignDTO taskEmployeeAssignDTO) {
        Employee employee = employeeRepository.findById(taskEmployeeAssignDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with given id"));

        return taskRepository.findById(taskId)
                .map(task -> {
                    task.setEmployee(employee);
                    return taskRepository.save(task);
                })
                .map(taskMapper::map)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with given id"));
    }

}

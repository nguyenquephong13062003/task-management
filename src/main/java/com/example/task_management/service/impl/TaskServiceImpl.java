package com.example.task_management.service.impl;

import com.example.task_management.model.Task;
import com.example.task_management.repository.ITaskRepository;
import com.example.task_management.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
}

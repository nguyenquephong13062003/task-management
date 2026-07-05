package com.example.task_management.service;

import com.example.task_management.model.Task;

import java.util.List;

public interface ITaskService {
    List<Task> findAllTasks();

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    Task deleteTask(Long id);
}

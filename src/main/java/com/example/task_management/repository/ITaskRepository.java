package com.example.task_management.repository;

import com.example.task_management.model.Task;

import java.util.List;

public interface ITaskRepository {

    List<Task> findAll();

    Task save(Task task);

    Task findById(Long id);

    Task save(Long id, Task task);

    Task deleteById(Long id);
}

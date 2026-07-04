package com.example.task_management.repository;

import com.example.task_management.model.Task;

import java.util.List;

public interface ITaskRepository {

    List<Task> findAll();

}

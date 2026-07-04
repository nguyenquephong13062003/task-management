package com.example.task_management.service.impl;

import com.example.task_management.model.Task;
import com.example.task_management.model.User;
import com.example.task_management.repository.ITaskRepository;
import com.example.task_management.service.ITaskService;
import com.example.task_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepository taskRepository;
    private final IUserService userService;

    @Autowired
    public TaskServiceImpl(ITaskRepository taskRepository, IUserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        User assignedUser = userService.findUserById(task.getAssignedTo());
        if (assignedUser == null) {
            return null;
        }
        return taskRepository.add(task);
    }

}

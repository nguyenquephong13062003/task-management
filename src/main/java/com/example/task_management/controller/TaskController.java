package com.example.task_management.controller;

import com.example.task_management.model.Task;
import com.example.task_management.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private final ITaskService taskService;

    @Autowired
    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(
            @RequestParam(required = false) String search) {

        List<Task> tasks = taskService.findAllTasks();

        if (search != null && !search.isBlank()) {
            tasks = tasks.stream()
                    .filter(task ->
                            task.getTitle()
                                    .toLowerCase()
                                    .contains(search.toLowerCase()))
                    .toList();
        }

        return ResponseEntity.ok(tasks);

    }

    @PostMapping
    public ResponseEntity<?> createTask(
            @RequestBody Task task) {

        Task createdTask = taskService.createTask(task);

        if (createdTask == null) {
            return ResponseEntity
                    .badRequest()
                    .body("Assigned user does not exist.");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTask);
    }

}

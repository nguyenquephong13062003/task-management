package com.example.task_management.repository.impl;

import com.example.task_management.model.Task;
import com.example.task_management.repository.ITaskRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements ITaskRepository {

    private final List<Task> tasks = new ArrayList<>(
            List.of(
                    new Task(1L, "System Initialization",
                            "Initialize project and configure application",
                            "HIGH", 1L),

                    new Task(2L, "Design Database",
                            "Design database schema",
                            "HIGH", 2L),

                    new Task(3L, "Create User API",
                            "Develop CRUD APIs for User",
                            "NORMAL", 3L),

                    new Task(4L, "Implement Login",
                            "Implement authentication feature",
                            "HIGH", 4L),

                    new Task(5L, "Write Unit Tests",
                            "Create unit tests for User module",
                            "LOW", 2L),

                    new Task(6L, "Optimize Queries",
                            "Improve database query performance",
                            "NORMAL", 3L),

                    new Task(7L, "Update Documentation",
                            "Write API documentation",
                            "LOW", 4L),

                    new Task(8L, "Implement Task API",
                            "Develop CRUD APIs for Task",
                            "HIGH", 2L),

                    new Task(9L, "Review Source Code",
                            "Perform code review",
                            "NORMAL", 3L),

                    new Task(10L, "Fix Bugs",
                            "Resolve reported issues",
                            "HIGH", 4L),

                    new Task(11L, "Refactor Service",
                            "Improve service layer structure",
                            "NORMAL", 2L),

                    new Task(12L, "Configure Security",
                            "Configure Spring Security",
                            "HIGH", 3L),

                    new Task(13L, "Prepare Demo",
                            "Prepare project demonstration",
                            "LOW", 4L),

                    new Task(14L, "Deploy Application",
                            "Deploy application to server",
                            "HIGH", 2L),

                    new Task(15L, "Final Testing",
                            "Execute final integration testing",
                            "NORMAL", 3L)
            )
    );

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    private Long generateNextId() {
        return tasks.stream()
                .map(Task::getId)
                .max(Long::compareTo)
                .orElse(0L) + 1;
    }

    @Override
    public Task save(Task task) {
        task.setId(generateNextId());
        tasks.add(task);
        return task;
    }

    @Override
    public Task findById(Long id) {

        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

    @Override
    public Task save(Long id, Task task) {

        Task existingTask = findById(id);

        if (existingTask == null) {
            return null;
        }

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setPriority(task.getPriority());
        existingTask.setAssignedTo(task.getAssignedTo());

        return existingTask;

    }

    @Override
    public Task deleteById(Long id) {

        Task existingTask = findById(id);

        if (existingTask == null) {
            return null;
        }

        tasks.remove(existingTask);

        return existingTask;

    }

}

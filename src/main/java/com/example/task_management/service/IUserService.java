package com.example.task_management.service;

import com.example.task_management.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUsers();

    User findUserById(Long id);
}

package com.example.task_management.service;

import com.example.task_management.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUsers();

    User findUserById(Long id);

    User createUser(User user);

    User updateUser(Long id, User user);

    User deleteUser(Long id);
}

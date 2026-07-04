package com.example.task_management.repository;

import com.example.task_management.model.User;

import java.util.List;

public interface IUserRepository {

    List<User> findAll();

}

package com.example.task_management.repository.impl;

import com.example.task_management.model.User;
import com.example.task_management.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private final List<User> users = new ArrayList<>(
            List.of(
                    new User(1L, "admin", "admin@example.com", "ADMIN"),
                    new User(2L, "john", "john@example.com", "USER"),
                    new User(3L, "alice", "alice@example.com", "USER"),
                    new User(4L, "bob", "bob@example.com", "USER")
            )
    );

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
}

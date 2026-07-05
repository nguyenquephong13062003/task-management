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

    private Long generateNextId() {
        return users.stream()
                .map(User::getId)
                .max(Long::compareTo)
                .orElse(0L) + 1;
    }

    @Override
    public User save(User user) {
        user.setId(generateNextId());
        users.add(user);
        return user;
    }

    @Override
    public User save(Long id, User user) {

        User existingUser = findById(id);

        if (existingUser == null) {
            return null;
        }

        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());

        return existingUser;

    }

    @Override
    public User deleteById(Long id) {

        User existingUser = findById(id);

        if (existingUser == null) {
            return null;
        }

        users.remove(existingUser);

        return existingUser;

    }

}

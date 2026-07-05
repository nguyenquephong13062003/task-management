package com.example.task_management.controller;

import com.example.task_management.model.User;
import com.example.task_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(
            @RequestParam(required = false) String search) {

        List<User> users = userService.findAllUsers();

        if (search != null && !search.isBlank()) {
            users = users.stream()
                    .filter(user ->
                            user.getUsername()
                                    .toLowerCase()
                                    .contains(search.toLowerCase()))
                    .toList();
        }

        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<?> createUser(
            @RequestBody User user) {

        User createdUser = userService.createUser(user);

        if (createdUser == null) {
            return ResponseEntity
                    .badRequest()
                    .body("User cannot be created.");
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        User updatedUser = userService.updateUser(id, user);

        if (updatedUser == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User not found.");
        }

        return ResponseEntity.ok(updatedUser);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id) {

        User deletedUser = userService.deleteUser(id);

        if (deletedUser == null) {
            return  ResponseEntity
                    .notFound()
                    .build();
        }

        return ResponseEntity
                .noContent()
                .build();

    }

}

package com.example.task_management.controller;

import com.example.task_management.model.User;
import com.example.task_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}

package com.example.task_management.service.impl;

import com.example.task_management.model.User;
import com.example.task_management.repository.IUserRepository;
import com.example.task_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {

//        User existingUser = userRepository.findById(id);
//
//        if (existingUser == null) {
//            return null;
//        }

        return userRepository.save(id, user);

    }

    @Override
    public User deleteUser(Long id) {

//        User existingUser = userRepository.findById(id);
//
//        if (existingUser == null) {
//            return null;
//        }

        return userRepository.deleteById(id);

    }

}

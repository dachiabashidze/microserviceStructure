package com.dachiabashidze.user_service.service;

import com.dachiabashidze.user_service.model.User;
import com.dachiabashidze.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers() {

        return new ArrayList<>(userRepository.findAll());
    }

    public Optional<User> getUser(String name) {
        return userRepository.findById(name);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(String name) {
        userRepository.deleteById(name);
    }
}

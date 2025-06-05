package com.dachiabashidze.user_service.resources;

import com.dachiabashidze.user_service.model.User;
import com.dachiabashidze.user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserResource {


    UserService userService;

    public UserResource(UserService userService){
        this.userService = userService;
    }

        //return all users
    @GetMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
        //return user by name
    @GetMapping("/{name}")
    public Optional<User> getUser(@PathVariable String name){
        return userService.getUser(name);
    }
    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping("/{name}")
    public void deleteUser(@PathVariable String name){
        userService.deleteUser(name);
    }

}

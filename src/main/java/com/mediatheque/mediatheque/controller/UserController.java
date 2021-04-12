package com.mediatheque.mediatheque.controller;

import com.mediatheque.mediatheque.entities.User;
import com.mediatheque.mediatheque.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser(){ return userService.getUser(); }

    @PostMapping(value = "/createuser")
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }
}

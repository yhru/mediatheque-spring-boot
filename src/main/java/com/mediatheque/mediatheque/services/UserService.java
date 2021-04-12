package com.mediatheque.mediatheque.services;

import com.mediatheque.mediatheque.entities.User;
import com.mediatheque.mediatheque.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/createuser")
    public User addNewUser(User user) {
        System.out.println(user);
        return userRepository.saveAndFlush(user);
    }
}

package com.fuser.english.controller;

import com.fuser.english.entity.User;
import com.fuser.english.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class RestUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Optional<User> getUserInfo(@PathVariable int id){
        return userService.getUserInfo(id);
    }

    @GetMapping("/user/getAll")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
}

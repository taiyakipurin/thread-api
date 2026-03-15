package com.taiyakipurin.threadapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.taiyakipurin.threadapi.service.UserService;
import com.taiyakipurin.threadapi.entity.User;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController
{
    UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> users()
    {
        return userService.getAllUsers();
    }

}

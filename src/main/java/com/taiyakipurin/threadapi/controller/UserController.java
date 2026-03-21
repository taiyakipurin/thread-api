package com.taiyakipurin.threadapi.controller;

import com.taiyakipurin.threadapi.dto.GetUserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{id}")
    public GetUserResponse userById(@PathVariable Long id)
    {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable Long id)
    {
        userService.deleteUserById(id);
        return "User deleted";
    }
}

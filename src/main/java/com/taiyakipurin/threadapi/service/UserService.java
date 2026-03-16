package com.taiyakipurin.threadapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.taiyakipurin.threadapi.repository.UserRepository;
import com.taiyakipurin.threadapi.entity.User;

@Service
public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User getUserById(Long id)
    {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUserById(Long id)
    {
        User user = userRepository
                .findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}

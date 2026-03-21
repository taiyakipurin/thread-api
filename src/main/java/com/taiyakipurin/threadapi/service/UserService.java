package com.taiyakipurin.threadapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.taiyakipurin.threadapi.repository.UserRepository;
import com.taiyakipurin.threadapi.repository.PostRepository;
import com.taiyakipurin.threadapi.entity.User;
import com.taiyakipurin.threadapi.dto.GetUserResponse;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository,
                       PostRepository postRepository)
    {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public GetUserResponse getUserById(Long id)
    {
        GetUserResponse response = new GetUserResponse();
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        response.setUserId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setCreatedAt(user.getCreatedAt());
        response.setPostCount(postRepository.countByAuthor(user));

        return response;
    }

    public void deleteUserById(Long id)
    {
        User user = userRepository
                .findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        userRepository.delete(user);
    }
}

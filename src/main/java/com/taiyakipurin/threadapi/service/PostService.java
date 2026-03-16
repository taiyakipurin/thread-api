package com.taiyakipurin.threadapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.taiyakipurin.threadapi.repository.PostRepository;
import com.taiyakipurin.threadapi.repository.UserRepository;
import com.taiyakipurin.threadapi.entity.Post;
import com.taiyakipurin.threadapi.entity.User;
import com.taiyakipurin.threadapi.dto.CreatePostRequest;
import com.taiyakipurin.threadapi.dto.PostResponse;

@Service
public class PostService
{
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository)
    {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostResponse createPost(CreatePostRequest request)
    {
        User user = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setAuthor(user);

        postRepository.save(post);

        PostResponse response = new PostResponse();

        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setAuthorId(post
                .getAuthor()
                .getId());
        response.setContent(post.getContent());
        response.setScore(post.getScore());
        response.setCreatedAt(post.getCreatedAt());

        return response;
    }

    public List<Post> getAllPosts()
    {
        return postRepository.findAll();
    }

    public PostResponse getPostById(Long id)
    {
        Post post = postRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        PostResponse response = new PostResponse();

        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setScore(post.getScore());
        response.setAuthorId(post
                .getAuthor().getId());
        response.setContent(post.getContent());
        response.setCreatedAt(post.getCreatedAt());

        return response;
    }
}

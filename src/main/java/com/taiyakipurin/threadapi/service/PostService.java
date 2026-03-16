package com.taiyakipurin.threadapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.taiyakipurin.threadapi.repository.PostRepository;
import com.taiyakipurin.threadapi.repository.UserRepository;
import com.taiyakipurin.threadapi.entity.Post;
import com.taiyakipurin.threadapi.entity.User;
import com.taiyakipurin.threadapi.dto.CreatePostRequest;

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

    public Post createPost(CreatePostRequest request)
    {
        User user = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setAuthor(user);

        return postRepository.save(post);
    }

    public List<Post> getAllPosts()
    {
        return postRepository.findAll();
    }

    public Post getPostById(Long id)
    {
        return postRepository.findById(id).orElse(null);
    }
}

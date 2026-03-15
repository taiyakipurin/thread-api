package com.taiyakipurin.threadapi.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.taiyakipurin.threadapi.repository.PostRepository;
import com.taiyakipurin.threadapi.entity.Post;

@Service
public class PostService
{
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository)
    {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post)
    {
        return postRepository.save(post);
    }

    public List<Post> getAllPosts()
    {
        return postRepository.findAll();
    }
}

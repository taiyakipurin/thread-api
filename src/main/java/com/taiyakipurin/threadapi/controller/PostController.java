package com.taiyakipurin.threadapi.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import com.taiyakipurin.threadapi.entity.Post;
import com.taiyakipurin.threadapi.service.PostService;
import com.taiyakipurin.threadapi.dto.CreatePostRequest;

@RestController
@RequestMapping("/api/v1")
public class PostController
{
    PostService postService;

    public PostController(PostService postService)
    {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> posts()
    {
        return postService.getAllPosts();
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody CreatePostRequest request)
    {
        System.out.println("request reached dto");
        return postService.createPost(request);
    }


}

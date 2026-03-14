package com.taiyakipurin.threadapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CommentController
{
    @GetMapping("/comments")
    public String comments()
    {
        return "comments";
    }
}

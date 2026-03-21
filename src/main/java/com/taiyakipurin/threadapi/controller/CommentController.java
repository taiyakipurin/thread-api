package com.taiyakipurin.threadapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

import com.taiyakipurin.threadapi.dto.CreateCommentRequest;
import com.taiyakipurin.threadapi.service.CommentService;
import com.taiyakipurin.threadapi.entity.Comment;

@RestController
@RequestMapping("/api/v1")
public class CommentController
{
    private final CommentService commentService;

    public CommentController(CommentService commentService)
    {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody CreateCommentRequest request)
    {
        return commentService.createComment(request);
    }

    @GetMapping("/comments")
    public List<Comment> comments()
    {
        return commentService.getAllComments();
    }

    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable Long id)
    {
        return commentService.getCommentById(id);
    }

    @DeleteMapping("/comments/{id}")
    public String deleteComment(@PathVariable Long id)
    {
        return commentService.deleteCommentById(id);
    }
}

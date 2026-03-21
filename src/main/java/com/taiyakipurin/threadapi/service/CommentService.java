package com.taiyakipurin.threadapi.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.taiyakipurin.threadapi.repository.CommentRepository;
import com.taiyakipurin.threadapi.repository.UserRepository;
import com.taiyakipurin.threadapi.repository.PostRepository;
import com.taiyakipurin.threadapi.entity.User;
import com.taiyakipurin.threadapi.entity.Comment;
import com.taiyakipurin.threadapi.entity.Post;
import com.taiyakipurin.threadapi.dto.CreateCommentRequest;

@Service
public class CommentService
{
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,
                          UserRepository userRepository,
                          PostRepository postRepository)
    {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(CreateCommentRequest request)
    {
        User user = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postRepository.findById(request.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment();

        comment.setAuthor(user);
        comment.setPost(post);
        comment.setContent(request.getContent());

        commentRepository.save(comment);

//        return "comment";
        return comment;
    }

    public List<Comment> getAllComments()
    {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId)
    {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    public String deleteCommentById(Long id)
    {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        commentRepository.delete(comment);

        return "Comment has been deleted";
    }


}

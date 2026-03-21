package com.taiyakipurin.threadapi.service;

import java.util.ArrayList;
import java.util.List;

import com.taiyakipurin.threadapi.entity.Comment;
import org.springframework.stereotype.Service;
import com.taiyakipurin.threadapi.repository.PostRepository;
import com.taiyakipurin.threadapi.repository.UserRepository;
import com.taiyakipurin.threadapi.repository.CommentRepository;
import com.taiyakipurin.threadapi.entity.Post;
import com.taiyakipurin.threadapi.entity.User;
import com.taiyakipurin.threadapi.dto.CreatePostRequest;
import com.taiyakipurin.threadapi.dto.PostDto;
import com.taiyakipurin.threadapi.dto.PostDetailDto;
import com.taiyakipurin.threadapi.dto.PostAuthorDto;
import com.taiyakipurin.threadapi.dto.CommentDto;

@Service
public class PostService
{
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository,
                       CommentRepository commentRepository)
    {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public PostDto createPost(CreatePostRequest request)
    {
        User user = userRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setAuthor(user);

        postRepository.save(post);

        PostDto response = new PostDto();

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

    public PostDetailDto getPostById(Long id)
    {
        Post post = postRepository
                .findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        PostAuthorDto user = new PostAuthorDto();
        user.setUserId(post.getAuthor()
                .getId());
        user.setUsername(post.getAuthor()
                .getUsername());

        List<Comment> commentsArray = commentRepository.findByPostId(post.getId());
        List<CommentDto> comments = commentsArray.stream()
                .map(comment -> {
                    CommentDto dto = new CommentDto();
                    dto.setAuthorId(comment.getAuthor().getId());
                    dto.setCommentId(comment.getId());
                    dto.setRating(comment.getRating());
                    dto.setContent(comment.getContent());

                    return dto;
                })
                .toList();

//        for (Comment comment: commentsArray)
//        {
//            CommentDto out = new CommentDto();
//
//            out.setCommentId(comment.getId());
//            out.setAuthorId(comment.getAuthor().getId());
//            out.setRating(comment.getRating());
//            out.setContent(comment.getContent());
//
//            comments.add(out);
//        }

        PostDetailDto response = new PostDetailDto();
        response.setId(post.getId());
        response.setTitle(post.getTitle());
        response.setScore(post.getScore());
        response.setAuthor(user);
        response.setComments(comments);
        response.setContent(post.getContent());
        response.setCreatedAt(post.getCreatedAt());

        return response;
    }
}

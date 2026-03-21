package com.taiyakipurin.threadapi.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostDetailDto
{
    private Long id;
    private String title;
    private PostAuthorDto author;
    private String content;
    private int score;
    private List<CommentDto> comments;
    private LocalDateTime createdAt;

    public PostDetailDto()
    {
    }

    public Long getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public PostAuthorDto getAuthor()
    {
        return author;
    }

    public String getContent()
    {
        return content;
    }

    public int getScore()
    {
        return score;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public List<CommentDto> getComments()
    {
        return comments;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(PostAuthorDto author)
    {
        this.author = author;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setComments(List<CommentDto> comments)
    {
        this.comments = comments;
    }

}

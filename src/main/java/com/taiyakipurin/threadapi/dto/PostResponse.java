package com.taiyakipurin.threadapi.dto;

import java.time.LocalDateTime;

public class PostResponse
{
    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private int score;
    private LocalDateTime createdAt;

    public  PostResponse()
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

    public Long getAuthorId()
    {
        return authorId;
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

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
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

}

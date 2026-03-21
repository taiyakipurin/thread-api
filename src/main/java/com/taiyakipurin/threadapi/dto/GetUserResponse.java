package com.taiyakipurin.threadapi.dto;

import java.time.LocalDateTime;

public class GetUserResponse
{
    private Long userId;
    private String username;
    private String email;
    private LocalDateTime createdAt;
    private Long postCount;

    public Long getUserId()
    {
        return userId;
    }

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public Long getPostCount()
    {
        return postCount;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPostCount(Long postCount)
    {
        this.postCount = postCount;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }
}

package com.taiyakipurin.threadapi.dto;

public class PostAuthorDto
{
    private Long userId;
    private String username;

    public Long getUserId()
    {
        return userId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}

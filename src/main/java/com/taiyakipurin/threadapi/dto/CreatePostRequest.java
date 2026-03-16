package com.taiyakipurin.threadapi.dto;

public class CreatePostRequest
{
    private String title;
    private String content;
    private Long authorId;

    public CreatePostRequest()
    {
    }

    public String getTitle()
    {
        return title;
    }

    public String getContent()
    {
        return content;
    }

    public Long getAuthorId()
    {
        return authorId;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }
}

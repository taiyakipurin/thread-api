package com.taiyakipurin.threadapi.dto;

public class CreateCommentRequest
{
    private Long authorId;
    private String content;
    private Long postId;

    public Long getAuthorId()
    {
        return authorId;
    }

    public String getContent()
    {
        return content;
    }

    public Long getPostId()
    {
        return postId;
    }

    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }
}

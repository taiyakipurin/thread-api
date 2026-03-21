package com.taiyakipurin.threadapi.dto;

public class CommentDto
{
    private Long commentId;
    private Long authorId;
    private Long rating;
    private String content;

    public Long getCommentId()
    {
        return commentId;
    }

    public Long getAuthorId()
    {
        return authorId;
    }

    public Long getRating()
    {
        return rating;
    }

    public String getContent()
    {
        return content;
    }

    public void setCommentId(Long id)
    {
        this.commentId = id;
    }

    public void setAuthorId(Long id)
    {
        this.authorId = id;
    }

    public void setRating(Long rating)
    {
        this.rating = rating;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}

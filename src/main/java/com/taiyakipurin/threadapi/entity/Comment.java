package com.taiyakipurin.threadapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.taiyakipurin.threadapi.entity.Post;

@Entity
@Table(name="comments")
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Long rating;

    public Long getId()
    {
        return id;
    }

    public User getAuthor()
    {
        return author;
    }

    public String getContent()
    {
        return content;
    }

    public Post getPost()
    {
        return post;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public Long getRating()
    {
        return rating;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setPost(Post post)
    {
        this.post = post;
    }

    public void setRating(Long rating)
    {
        this.rating = rating;
    }

    @PrePersist
    public void prePersist()
    {
        this.createdAt = LocalDateTime.now();
        this.rating = 0L;
    }



}

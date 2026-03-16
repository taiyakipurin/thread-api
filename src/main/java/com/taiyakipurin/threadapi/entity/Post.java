package com.taiyakipurin.threadapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private int score;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Post()
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

    public User getAuthor()
    {
        return author;
    }

    public int getScore()
    {
        return score;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public String getContent()
    {
        return content;
    }

    public void setAuthor(User author)
    {
        this.author = author;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @PrePersist
    public void prePersist()
    {
        this.createdAt = LocalDateTime.now();
        this.score = 0;
    }
}

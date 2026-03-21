package com.taiyakipurin.threadapi.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    public User()
    {

    }

    public Long getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public List<Post> getPosts()
    {
        return posts;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPost(Post post)
    {
        this.posts.add(post);
    }

    @PrePersist
    public void prePersist()
    {
        this.createdAt = LocalDateTime.now();
    }
}

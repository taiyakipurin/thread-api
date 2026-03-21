package com.taiyakipurin.threadapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taiyakipurin.threadapi.entity.Post;
import com.taiyakipurin.threadapi.entity.User;

public interface PostRepository extends JpaRepository<Post, Long>
{
    long countByAuthor(User author);
}
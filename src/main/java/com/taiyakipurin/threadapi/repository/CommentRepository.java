package com.taiyakipurin.threadapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taiyakipurin.threadapi.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long>
{
    List<Comment> findByPostId(Long id);
}

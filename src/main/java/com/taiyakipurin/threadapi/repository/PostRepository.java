package com.taiyakipurin.threadapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taiyakipurin.threadapi.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>
{

}
package com.example.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.homework.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

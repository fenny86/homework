package com.example.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.homework.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

package com.example.homework.entity;

import lombok.*;

import org.hibernate.Hibernate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
@Entity
@Table(name = "Post")
@Setter
@Getter
@ToString(callSuper = true)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostID")
    private Long postID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @Column(name = "Content")
    private String content;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Post post = (Post) o;
        return getPostID() != null && Objects.equals(getPostID(), post.getPostID());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


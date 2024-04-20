package com.example.homework.entity;

import lombok.*;

import org.hibernate.Hibernate;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Comment")
@Setter
@Getter
@ToString(callSuper = true)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CommentID")
    private Long commentID;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "PostID", nullable = false)
    private Post post;

    @Column(name = "Content")
    private String content;

    @Column(name = "CreatedAt")
    private Date createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Comment comment = (Comment) o;
        return commentID != null && Objects.equals(commentID, comment.commentID);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

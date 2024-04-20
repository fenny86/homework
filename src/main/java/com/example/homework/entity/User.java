package com.example.homework.entity;

import lombok.*;

import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Setter
@Getter
@ToString(callSuper = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userID;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Biography")
    private String biography;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return getUserID() != null && Objects.equals(getUserID(), user.getUserID());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
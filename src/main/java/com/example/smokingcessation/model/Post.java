package com.example.smokingcessation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document
public class Post {
    @Id
    private String id;
    private String title;
    private String body;
    @DBRef
    private User user;
    private LocalDateTime dateTime;

    @DBRef
    private Set<Comment> comments;

    public Post() {
    }

    public Post(String title, String body, User user){
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = new HashSet<Comment>();
        this.dateTime = LocalDateTime.now();
    }

    public Post(String title, String body, LocalDateTime dateTime, HashSet<Comment> comments, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.dateTime = dateTime;
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(HashSet<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
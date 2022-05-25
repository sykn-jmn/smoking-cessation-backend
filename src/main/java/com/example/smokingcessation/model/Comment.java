package com.example.smokingcessation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Comment {
    @Id
    private String id;
    private String comment;
    @DBRef
    private User user;
    private LocalDateTime dateTime;

    public Comment(User user, String comment, LocalDateTime dateTime) {
        this.comment = comment;
        this.dateTime = dateTime;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment() {
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

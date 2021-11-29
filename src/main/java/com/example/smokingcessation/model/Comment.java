package com.example.smokingcessation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(columnDefinition = "longtext")
    private String comment;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @OneToMany(mappedBy = "comment")
    private Set<Comment> replies = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment repliedFrom;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime dateTime;

    public Comment(User user, String comment, Post post, LocalDateTime dateTime) {
        this.comment = comment;
        this.post = post;
        this.dateTime = dateTime;
        this.repliedFrom = null;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addAllReplies(ArrayList<Comment> comments){
        this.replies.addAll(comments);
    }

    public Comment() {
    }

    public Comment(User commenter, String comment, Post post, HashSet<Comment> replies, Comment repliedFrom, LocalDateTime dateTime) {
        this.comment = comment;
        this.post = post;
        this.replies = replies;
        this.repliedFrom = repliedFrom;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Set<Comment> getReplies() {
        return replies;
    }

    public void setReplies(HashSet<Comment> replies) {
        this.replies = replies;
    }

    public Comment getRepliedFrom() {
        return repliedFrom;
    }

    public void setRepliedFrom(Comment repliedFrom) {
        this.repliedFrom = repliedFrom;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

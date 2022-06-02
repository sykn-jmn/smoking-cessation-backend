package com.example.smokingcessation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class SmokingRecord {
    @Id
    private String id;
    @DBRef
    private User user;
    @DBRef
    private Cigarette cigarette;
    private Integer quantity;
    private LocalDateTime dateTime;

    public SmokingRecord() {
    }

    public SmokingRecord(User user, Cigarette cigarette, Integer quantity, LocalDateTime dateTime) {
        this.user = user;
        this.cigarette = cigarette;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }

    public SmokingRecord(String id, User user, Cigarette cigarette, Integer quantity, LocalDateTime dateTime) {
        this.id = id;
        this.user = user;
        this.cigarette = cigarette;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cigarette getCigarette() {
        return cigarette;
    }

    public void setCigarette(Cigarette cigarette) {
        this.cigarette = cigarette;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

package com.example.smokingcessation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Session{

    @Id
    private String id;
    private String uuid;
    private String userID;

    public String getId() {
        return id;
    }

    public Session(String userID) {
        this.uuid = UUID.randomUUID().toString();
        this.userID = userID;
    }

    public Session() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}

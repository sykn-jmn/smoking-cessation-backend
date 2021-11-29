package com.example.smokingcessation.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="session")
public class Session{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = false)
    private String uuid;
    private Long userID;

    public Long getId() {
        return id;
    }

    public Session(Long userID) {
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}

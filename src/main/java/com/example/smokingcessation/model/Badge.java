package com.example.smokingcessation.model;

import javax.persistence.*;

@Entity
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idgen")
    @SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "badgeSeq")
    @Column(nullable = false,updatable = false)
    public Long id;
    public String title;
    public String description;
    public int daysFreeGoal;
    public int moneySavedGoal;

    public Badge() {
    }

    public Badge(String title, String description, int daysFreeGoal,int  moneySavedGoal) {
        this.title = title;
        this.description = description;
        this.daysFreeGoal = daysFreeGoal;
        this.moneySavedGoal = moneySavedGoal;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDaysFreeGoal() {
        return daysFreeGoal;
    }

    public void setDaysFreeGoal(int daysFreeGoal) {
        this.daysFreeGoal = daysFreeGoal;
    }

    public int getMoneySavedGoal() {
        return moneySavedGoal;
    }

    public void setMoneySavedGoal(int moneySavedGoal) {
        this.moneySavedGoal = moneySavedGoal;
    }
}

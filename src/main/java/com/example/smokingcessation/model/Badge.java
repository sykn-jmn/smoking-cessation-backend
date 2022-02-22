package com.example.smokingcessation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Badge {
    @Id
    public String id;
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

    public String getId() {
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

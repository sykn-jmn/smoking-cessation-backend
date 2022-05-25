package com.example.smokingcessation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Document
public class User implements Comparable<User>{

    @Id
    private String id;
    private String username;
    private String password;
    private LocalDate lastShowDailyChallenge;
    private LocalDateTime startingDate;
    private double amountAddedPerSecond;
    private LocalDateTime stoppedSmokingDate;
    private int timesSmokedSinceStart;
    private double cost;
    private int timesADay;
    private String city;
    private byte[] profileByte;

    public User(String username, String password, double cost, int timesADay, String city, byte[] profileByte) {
        this.username = username;
        this.password = password;
        this.lastShowDailyChallenge = LocalDate.of(1999,2,10);
        this.startingDate = LocalDateTime.now();
        double perDay = cost * timesADay;
        double perHour = perDay/24;
        double perMinute = perHour/60;
        double perSecond = perMinute/60;
        this.amountAddedPerSecond = perSecond;
        this.stoppedSmokingDate = LocalDateTime.now().plus(8,ChronoUnit.HOURS);
        timesSmokedSinceStart=0;
        this.cost = cost;
        this.timesADay = timesADay;
        this.city = city;
        this.profileByte = profileByte;
    }

    public User(String username,String password, String city, LocalDate showDailyChallenge, LocalDateTime startingDate, double amountAddedPerSecond, LocalDateTime stoppedSmokingDate, int timesSmokedSinceStart, double cost, int timesADay, byte[] profileByte) {
        this.username = username;
        this.password = password;
        this.city = city;
        this.lastShowDailyChallenge = showDailyChallenge;
        this.startingDate = startingDate;
        this.amountAddedPerSecond = amountAddedPerSecond;
        this.stoppedSmokingDate = stoppedSmokingDate;
        this.timesSmokedSinceStart = timesSmokedSinceStart;
        this.cost = cost;
        this.timesADay = timesADay;
        this.profileByte = profileByte;
    }

    public User() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore(){
        int score = 0;
        score += ChronoUnit.DAYS.between(getStoppedSmokingDate(), LocalDateTime.now()) * 10;
        score -= getTimesSmokedSinceStart();
        return score;
    }


    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getLastShowDailyChallenge() {
        return lastShowDailyChallenge;
    }

    public void setLastShowDailyChallenge(LocalDate lastShowDailyChallenge) {
        this.lastShowDailyChallenge = lastShowDailyChallenge;
    }

    public LocalDateTime getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public double getAmountAddedPerSecond() {
        return amountAddedPerSecond;
    }

    public LocalDateTime getStoppedSmokingDate() {
        return stoppedSmokingDate;
    }

    public void setAmountAddedPerSecond(double amountAddedPerSecond) {
        this.amountAddedPerSecond = amountAddedPerSecond;
    }

    public void setStoppedSmokingDate(LocalDateTime stoppedSmokingDate) {
        this.stoppedSmokingDate = stoppedSmokingDate;
    }

    public int getTimesSmokedSinceStart() {
        return timesSmokedSinceStart;
    }

    public void setTimesSmokedSinceStart(int timesSmokedSinceStart) {
        this.timesSmokedSinceStart = timesSmokedSinceStart;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getTimesADay() {
        return timesADay;
    }

    public void setTimesADay(int timesADay) {
        this.timesADay = timesADay;
    }

    @Override
    public int compareTo(User o) {
        return o.getScore()-getScore();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public byte[] getProfileByte() {
        return profileByte;
    }

    public void setProfileByte(byte[] profileByte) {
        this.profileByte = profileByte;
    }
}

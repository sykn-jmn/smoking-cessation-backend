package com.example.smokingcessation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
    private LocalDateTime stoppedSmokingDate;
    private int timesSmokedSinceStart;
    private int timesADay;
    private String city;
    @DBRef
    private Cigarette cigarette;
    private byte[] profileByte;

    public User(String username, String password, String city, byte[] profileByte, Cigarette cigarette) {
        this.username = username;
        this.password = password;
        this.lastShowDailyChallenge = LocalDate.of(1999,2,10);
        this.startingDate = LocalDateTime.now().plus(8,ChronoUnit.HOURS);
        this.stoppedSmokingDate = LocalDateTime.now().plus(8,ChronoUnit.HOURS);
        timesSmokedSinceStart=0;
        this.timesADay = 25;
        this.city = city;
        this.profileByte = profileByte;
        this.cigarette = cigarette;
    }

    public User() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cigarette getCigarette() {
        return cigarette;
    }

    public void setCigarette(Cigarette cigarette) {
        this.cigarette = cigarette;
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
        double perDay = cigarette.getPrice() * timesADay;
        double perHour = perDay/24;
        double perMinute = perHour/60;
        double perSecond = perMinute/60;
        return perSecond;
    }

    public LocalDateTime getStoppedSmokingDate() {
        return stoppedSmokingDate;
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
        return cigarette.getPrice();
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

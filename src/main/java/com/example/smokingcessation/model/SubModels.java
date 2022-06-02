package com.example.smokingcessation.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SubModels {

    public static class SmokingRecordDTO{
        Integer numberOfTimesSmoked;

        public SmokingRecordDTO() {
        }

        public SmokingRecordDTO(Integer numberOfTimesSmoked) {
            this.numberOfTimesSmoked = numberOfTimesSmoked;
        }

        public Integer getNumberOfTimesSmoked() {
            return numberOfTimesSmoked;
        }

        public void setNumberOfTimesSmoked(Integer numberOfTimesSmoked) {
            this.numberOfTimesSmoked = numberOfTimesSmoked;
        }
    }

    public static class SentPost{
        String title;
        String sessionID;
        String body;

        public SentPost(String title, String sessionID, String body) {
            this.title = title;
            this.sessionID = sessionID;
            this.body = body;
        }

        public SentPost() {
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }

    public static class UserProfile{
        String username;

        LocalDateTime startingDate;

        String city;

        Integer leaderboardPosition;

        public UserProfile(String username, LocalDateTime startingDate, String city, Integer leaderboardPosition) {
            this.username = username;
            this.startingDate = startingDate;
            this.city = city;
            this.leaderboardPosition = leaderboardPosition;
        }

        public UserProfile() {
        }

        public LocalDateTime getStartingDate() {
            return startingDate;
        }

        public void setStartingDate(LocalDateTime startingDate) {
            this.startingDate = startingDate;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getLeaderboardPosition() {
            return leaderboardPosition;
        }

        public void setLeaderboardPosition(Integer leaderboardPosition) {
            this.leaderboardPosition = leaderboardPosition;
        }
    }

    public static class PassedSession{
        String sessionID;

        public PassedSession(String sessionID) {
            this.sessionID = sessionID;
        }

        public PassedSession() {
        }

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }
    }

    public static class AddedComment{
        private String comment;
        private String postId;
        private String sessionID;

        @Override
        public String toString() {
            return "AddedComment{" +
                    "comment='" + comment + '\'' +
                    ", postId=" + postId +
                    ", sessionID=" + sessionID +
                    '}';
        }

        public AddedComment() {
        }

        public AddedComment(String comment, String postId, String sessionID) {
            this.comment = comment;
            this.postId = postId;
            this.sessionID = sessionID;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }
    }

    public static class UserRegistration{
        private String username;
        private String password;
        private Cigarette cigarette;
        private String city;

        public UserRegistration(String username, String password, Cigarette cigarette, String city) {
            this.username = username;
            this.password = password;
            this.cigarette = cigarette;
            this.city = city;
        }

        public UserRegistration() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
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

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static class LeaderBoardUser{
        private String username;
        private Integer score;
        private String city;
        public LeaderBoardUser(){};
        public LeaderBoardUser(String username, Integer score, String city) {
            this.username = username;
            this.score = score;
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "LeaderBoardUser{" +
                    "username='" + username + '\'' +
                    ", score=" + score +
                    ", city='" + city + '\'' +
                    '}';
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }

    public static class Login{
        String username;
        String password;

        public Login(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class ResponseUser{
        private Long id;
        private LocalDate lastShowDailyChallenge;
        private LocalDateTime startingDate;
        private double amountAddedPerSecond;
        private LocalDateTime stoppedSmokingDate;
        private int timesSmokedSinceStart;
        private double cost;
        private int timesADay;

        public ResponseUser(){};

        public void setId(Long id) {
            this.id = id;
        }

        public ResponseUser(Long id,
                            LocalDate lastShowDailyChallenge,
                            LocalDateTime startingDate,
                            double amountAddedPerSecond,
                            LocalDateTime stoppedSmokingDate,
                            int timesSmokedSinceStart,
                            double cost,
                            int timesADay) {
            this.id = id;
            this.lastShowDailyChallenge = lastShowDailyChallenge;
            this.startingDate = startingDate;
            this.amountAddedPerSecond = amountAddedPerSecond;
            this.stoppedSmokingDate = stoppedSmokingDate;
            this.timesSmokedSinceStart = timesSmokedSinceStart;
            this.cost = cost;
            this.timesADay = timesADay;
        }

        public Long getId() {
            return id;
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

        public void setAmountAddedPerSecond(double amountAddedPerSecond) {
            this.amountAddedPerSecond = amountAddedPerSecond;
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
    }

    public static class SmokingData{
        private String sessionID;
        private Cigarette cigarette;

        public SmokingData(String sessionID, Cigarette cigarette) {
            this.sessionID = sessionID;
            this.cigarette = cigarette;
        }

        public SmokingData() {
        }

        public String getSessionID() {return sessionID;}
        public void setId(String sessionID) { this.sessionID = sessionID; }
        public Cigarette getCigarette() { return cigarette; }
        public void setCigarette(Cigarette cigarette) { this.cigarette = cigarette; }
    }

    public static class SavedMoneyData{
        private Cigarette cigarette;
        private Integer timesSmokedSinceStart;
        private LocalDateTime startingDate;
        public Cigarette getCigarette() {
            return cigarette;
        }
        public void setCigarette(Cigarette cigarette) {
            this.cigarette = cigarette;
        }
        public Integer getTimesSmokedSinceStart() {
            return timesSmokedSinceStart;
        }
        public void setTimesSmokedSinceStart(Integer timesSmokedSinceStart) {
            this.timesSmokedSinceStart = timesSmokedSinceStart;
        }

        public LocalDateTime getStartingDate() {
            return startingDate;
        }

        public void setStartingDate(LocalDateTime startingDate) {
            this.startingDate = startingDate;
        }

        public SavedMoneyData() {
        }

        public SavedMoneyData(Cigarette cigarette, Integer timesSmokedSinceStart, LocalDateTime startingDate) {
            this.cigarette = cigarette;
            this.timesSmokedSinceStart = timesSmokedSinceStart;
            this.startingDate = startingDate;
        }
    }

    public static class UserBadge{
        private String name;
        private String description;
        private Boolean obtained;
        public UserBadge(){}
        public UserBadge(String name, String description, Boolean obtained) {
            this.name = name;
            this.description = description;
            this.obtained = obtained;
        }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public Boolean getObtained() { return obtained; }
        public void setObtained(Boolean obtained) { this.obtained = obtained; }
    }

    public static class StoppedSmokingDate{
        private String sessionID;
        private String stoppedSmokingDate;

        public StoppedSmokingDate(String stoppedSmokingDate) {
            this.stoppedSmokingDate = stoppedSmokingDate;
        }

        public StoppedSmokingDate() {
        }

        public String getStoppedSmokingDate() {
            return stoppedSmokingDate;
        }

        public void setStoppedSmokingDate(String stoppedSmokingDate) {
            this.stoppedSmokingDate = stoppedSmokingDate;
        }

        public String getSessionID() {
            return sessionID;
        }
    }

    public static class ProfileImageUpdate {
        String base64;
        String sessionID;

        public ProfileImageUpdate(String base64, String sessionID) {
            this.base64 = base64;
            this.sessionID = sessionID;
        }

        public String getBase64() {
            return base64;
        }

        public void setBase64(String base64) {
            this.base64 = base64;
        }

        public String getSessionID() {
            return sessionID;
        }

        public void setSessionID(String sessionID) {
            this.sessionID = sessionID;
        }

        public ProfileImageUpdate() {
        }
    }
}

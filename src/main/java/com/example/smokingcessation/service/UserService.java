package com.example.smokingcessation.service;

import com.example.smokingcessation.model.*;
import com.example.smokingcessation.repo.PostRepository;
import com.example.smokingcessation.repo.SessionRepository;
import com.example.smokingcessation.repo.SmokingRecordRepository;
import com.example.smokingcessation.repo.UserRepository;
import com.example.smokingcessation.security.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {

    private UserRepository userRepository;
    private final PostRepository postRepository;
    private final SessionRepository sessionRepository;
    private final SmokingRecordRepository smokingRecordRepository;

    @Autowired
    public UserService(UserRepository userRepository, SessionRepository sessionRepository, PostRepository postRepository, SmokingRecordRepository smokingRecordRepository){
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
        this.postRepository = postRepository;
        this.smokingRecordRepository = smokingRecordRepository;
    }

    public void post(SubModels.SentPost sentPost){
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sentPost.getSessionID());
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        Post post = new Post(sentPost.getTitle(), sentPost.getBody(), user);
        postRepository.save(post);
    }

    public User getUser(String id){
        return userRepository.findById(id).get();
    }

    @Transactional
    public LocalDate getLastShowDailyTask(String sessionID){
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        LocalDate toReturn = user.getLastShowDailyChallenge();
        user.setLastShowDailyChallenge(LocalDate.now());
        userRepository.save(user);
        return toReturn;
    }

    @Transactional
    public void saveUser(User user){
        userRepository.save(user);
    }

    public LocalDateTime getStartingDate(String id) {
        return userRepository.findById(id).get().getStartingDate();
    }

    @Transactional
    public Double saveSmokingData(String sessionID, Cigarette cigarette) {
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        user.setCigarette(cigarette);
        userRepository.save(user);
        return 0.0;
    }

    public SubModels.SavedMoneyData getSavedMoneyData(String sessionID){
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        SubModels.SavedMoneyData savedMoneyData = new SubModels.SavedMoneyData(
                user.getCigarette(),
                user.getTimesSmokedSinceStart(),
                user.getStartingDate()
        );
        return savedMoneyData;
    }

    public LocalDateTime getStoppedSmokingDate(String sessionID){
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        LocalDateTime stoppedSmokingDate = smokingRecordRepository.findFirstByUser_IdOrderByDateTimeDesc(userID).getDateTime();
        return stoppedSmokingDate;
    }

    public Double getAmountAddedPerSecond(String id){
        User user = userRepository.findById(id).get();
        return user.getAmountAddedPerSecond();
    }

    public Integer getTimesSmokedSinceStart(String id){
        User user = userRepository.findById(id).get();
        return user.getTimesSmokedSinceStart();
    }

    @Transactional
    public LocalDateTime setStoppedSmokingDate(String sessionID, String date){
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        String[] dateTime = date.split("T");
        String[] dates = dateTime[0].split("-");
        String[] times = dateTime[1].split(":");
        System.out.println(date);
        System.out.println(dates[0]+'-'+dates[1]+'-'+dates[2]+'-'+times[0]+'-'+times[1]+'-'+times[2]);
        LocalDateTime newStoppedSmokingDate = LocalDateTime.of(Integer.parseInt(dates[0]),
                Integer.parseInt(dates[1]),Integer.parseInt(dates[2]),
                Integer.parseInt(times[0]),Integer.parseInt(times[1]),
                Integer.parseInt(times[2].split("\\.")[0]));
        User user = userRepository.findById(userID).get();
        user.setStoppedSmokingDate(newStoppedSmokingDate);
        userRepository.save(user);
        return newStoppedSmokingDate;
    }

    public List<SubModels.LeaderBoardUser> getLeaderBoard(){
        List<User> users = userRepository.findAll();
        Collections.sort(users);
        List<SmokingRecord> smokingRecords = smokingRecordRepository.findAll();
        List<SubModels.LeaderBoardUser> scores = new ArrayList<>();
        smokingRecords.forEach(smokingRecord -> {
            Optional<SubModels.LeaderBoardUser> scoreWithCurrentUser = scores
                    .stream().filter(score->score.getUsername().equals(smokingRecord.getUser().getUsername()))
                    .findAny();
            int currScore = (25-smokingRecord.getQuantity());
            if(scoreWithCurrentUser.isPresent()){
                SubModels.LeaderBoardUser score = scoreWithCurrentUser.get();
                score.setScore(score.getScore()+currScore);
            }else{
                scores.add(new SubModels.LeaderBoardUser(smokingRecord.getUser().getUsername(),currScore,smokingRecord.getUser().getCity()));
            }
        });

        List<SubModels.LeaderBoardUser> sortedLeaderboard = scores
                .stream()
                .sorted(Comparator.comparingInt(SubModels.LeaderBoardUser::getScore).reversed())
                .limit(10)
                .collect(Collectors.toList());

        return sortedLeaderboard;
    }

    private int getUserLeaderboardPosition(String userID){
        List<User> users = userRepository.findAll();
        Collections.sort(users);
        for(int i = 0; i < 10 && i <users.size(); i++){
            if(users.get(i).getId().equalsIgnoreCase(userID)) return i+1;
        }
        throw new IllegalStateException("Invalid User Id");
    }

    @Transactional
    public void showDailyTask(String sessionID) {
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        user.setLastShowDailyChallenge(LocalDate.now());
        userRepository.save(user);
    }

    public User signUpUser(User user){
        boolean userExists = userRepository.findUserByUsername(user.getUsername())
                .isPresent();
        if(userExists){
            throw new IllegalStateException("Username already taken");
        }
        String hashedPassword = MD5Utils.hash(user.getPassword());
        user.setPassword(hashedPassword);

        user = userRepository.save(user);
        return user;
    }


    @Transactional
    public String login(SubModels.Login loginData) {
        Optional<User> userOptional = userRepository.findUserByUsername(loginData.getUsername());
        if(userOptional.isPresent()){
            String sessionId = null;
            User user = userOptional.get();
            String hashedPassword = MD5Utils.hash(loginData.getPassword());
            if(hashedPassword.equals(user.getPassword())){
                Optional<Session> session = sessionRepository.findSessionByUserID(user.getId());
                if(session.isPresent()){
                    sessionId = session.get().getUuid();
                }else{
                    Session newSession = new Session(user.getId());
                    Session updatedNewSession = sessionRepository.save(newSession);
                    sessionId = updatedNewSession.getUuid();
                }
            }else{
                return "Invalid Login";
            }
            return sessionId;
        }
        else{
            return "Invalid Login";
        }
    }

    public byte[] getUserProfile(String sessionID) {
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        return user.getProfileByte();
    }

    public SubModels.UserProfile getProfileInfo(String sessionID) {
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        return new SubModels.UserProfile(
                user.getUsername(),
                user.getStartingDate(),
                user.getCity(),
                getUserLeaderboardPosition(userID));
    }

    public Boolean updateProfileImage(SubModels.ProfileImageUpdate profileImageUpdate) {
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(profileImageUpdate.getSessionID());
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        byte[] byteArray = base64ImageToByteArray(profileImageUpdate.getBase64());
        user.setProfileByte(byteArray);
        userRepository.save(user);
        return true;
    }

    public byte[] base64ImageToByteArray(String base64Image){
        String partSeparator = ",";
        if (base64Image.contains(partSeparator)) base64Image = base64Image.split(partSeparator)[1];
        byte[] decodedImg = Base64.getDecoder().decode(base64Image.getBytes(StandardCharsets.UTF_8));
        return decodedImg;
    }

    public boolean checkSession(String sessionID) {
        return sessionRepository.findSessionByUuid(sessionID).isPresent();
    }

    @Transactional
    public void removeSession(String sessionID) {
        sessionRepository.removeSessionByUuid(sessionID);
    }

    public List<SmokingRecord> getSmokingRecord(String sessionID) {
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        System.out.println("Getting Smoking Records");
        List<SmokingRecord> smokingRecords = smokingRecordRepository.findByUser_IdOrderByDateTimeAsc(userID);
        System.out.println("Finished Getting Smoking Records");
        return smokingRecords;
    }

    public Void submitSmokingRecord(String sessionID, SubModels.SmokingRecordDTO smokingRecordDTO) {
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        String userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        SmokingRecord smokingRecord = new SmokingRecord(user, user.getCigarette(), smokingRecordDTO.getNumberOfTimesSmoked(), LocalDateTime.now().plus(8, ChronoUnit.HOURS));
        smokingRecordRepository.save(smokingRecord);
        return null;
    }
}

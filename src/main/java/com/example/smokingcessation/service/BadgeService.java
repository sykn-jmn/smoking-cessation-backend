package com.example.smokingcessation.service;

import com.example.smokingcessation.model.Badge;
import com.example.smokingcessation.model.Session;
import com.example.smokingcessation.model.SubModels;
import com.example.smokingcessation.model.User;
import com.example.smokingcessation.repo.BadgeRepository;
import com.example.smokingcessation.repo.SessionRepository;
import com.example.smokingcessation.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BadgeService {
    private BadgeRepository badgeRepository;
    private UserRepository userRepository;
    private SessionRepository sessionRepository;

    @Autowired
    public BadgeService(BadgeRepository badgeRepository, UserRepository userRepository, SessionRepository sessionRepository) {
        this.badgeRepository = badgeRepository;
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }

    public List<SubModels.UserBadge> getUserBadges(String sessionID){
        Optional<Session> sessionOptional = sessionRepository.findSessionByUuid(sessionID);
        if(!sessionOptional.isPresent()){
            throw new IllegalStateException("Invalid Session");
        }
        Session session = sessionOptional.get();
        Long userID = session.getUserID();
        User user = userRepository.findById(userID).get();
        List<Badge> badges = badgeRepository.findAll();
        ArrayList<SubModels.UserBadge> userBadges = new ArrayList<>();
        for(Badge badge: badges){
            userBadges.add(new SubModels.UserBadge(badge.getTitle(),badge.getDescription(),achievedBadge(user,badge)));
        }
        return userBadges;
    }

    public Boolean achievedBadge(User user, Badge badge){
        return daysSinceSmokeFree(user)>=badge.getDaysFreeGoal() ||
                amountSavedSoFar(user)>=badge.getMoneySavedGoal();
    }

    public double amountSavedSoFar(User user){
        long secondsSinceStart = ChronoUnit.SECONDS.between(user.getStartingDate(),LocalDateTime.now());
        return user.getAmountAddedPerSecond()*secondsSinceStart;
    }

    public long daysSinceSmokeFree(User user){
        return ChronoUnit.DAYS.between(user.getStoppedSmokingDate(), LocalDateTime.now());
    }
}

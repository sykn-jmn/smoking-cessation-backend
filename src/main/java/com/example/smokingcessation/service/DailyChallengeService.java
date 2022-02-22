package com.example.smokingcessation.service;

import com.example.smokingcessation.model.DailyChallenge;
import com.example.smokingcessation.repo.DailyChallengesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DailyChallengeService {
    private DailyChallengesRepository dailyChallengesRepository;
    private Random random = new Random();

    @Autowired
    public DailyChallengeService(DailyChallengesRepository dailyChallengesRepository){
        this.dailyChallengesRepository = dailyChallengesRepository;
    }

    public String getRandomChallenge(){
        Random rand = new Random();
        List<DailyChallenge> dailyChallengeList = dailyChallengesRepository.findAll();
        return dailyChallengeList.get(random.nextInt(dailyChallengeList.size())).getQuote();
    }
}

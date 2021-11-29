package com.example.smokingcessation.service;

import com.example.smokingcessation.repo.DailyChallengesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DailyChallengeService {
    private DailyChallengesRepository dailyChallengesRepository;

    @Autowired
    public DailyChallengeService(DailyChallengesRepository dailyChallengesRepository){
        this.dailyChallengesRepository = dailyChallengesRepository;
    }

    public String getRandomChallenge(){
        Random rand = new Random();
        int randomId = rand.nextInt((int)dailyChallengesRepository.count())+1;
        return this.dailyChallengesRepository.findById((long)randomId).get().getQuote();
    }
}

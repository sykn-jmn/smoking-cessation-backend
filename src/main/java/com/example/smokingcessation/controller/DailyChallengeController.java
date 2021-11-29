package com.example.smokingcessation.controller;

import com.example.smokingcessation.service.DailyChallengeService;
import com.example.smokingcessation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@RestController
public class DailyChallengeController {

    private DailyChallengeService dailyChallengeService;
    private UserService userService;

    @Autowired
    public DailyChallengeController(DailyChallengeService dailyChallengeService, UserService userService) {
        this.dailyChallengeService = dailyChallengeService;
        this.userService = userService;
    }

    @GetMapping("/randomChallenge/{sessionID}")
    public String getRandomChallenge(@PathVariable("sessionID") String sessionID){
        userService.showDailyTask(sessionID);
        return dailyChallengeService.getRandomChallenge();
    }
}

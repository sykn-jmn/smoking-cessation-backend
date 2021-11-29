package com.example.smokingcessation.controller;

import com.example.smokingcessation.model.SubModels;
import com.example.smokingcessation.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@RestController
public class BadgeController {

    private BadgeService badgeService;

    @Autowired
    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping("/badges/{sessionID}")
    public ResponseEntity<List<SubModels.UserBadge>> getUserBadges(@PathVariable("sessionID") String sessionID){
        List<SubModels.UserBadge> userBadges = badgeService.getUserBadges(sessionID);
        return new ResponseEntity<>(userBadges, HttpStatus.OK);
    }
}

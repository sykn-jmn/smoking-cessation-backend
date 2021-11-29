package com.example.smokingcessation.controller;

import com.example.smokingcessation.model.Cigarette;
import com.example.smokingcessation.model.Post;
import com.example.smokingcessation.model.SubModels;
import com.example.smokingcessation.service.CigaretteService;
import com.example.smokingcessation.service.PostService;
import com.example.smokingcessation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin
@RestController
public class GeneralController {
    private final UserService userService;
    private final CigaretteService cigaretteService;
    private final PostService postService;

    @Autowired
    public GeneralController(UserService userService, CigaretteService cigaretteService, PostService postService) {
        this.userService = userService;
        this.cigaretteService = cigaretteService;
        this.postService = postService;
    }

    @GetMapping("/latestPosts")
    public ResponseEntity<List<Post>> getLatestPosts(){
        return new ResponseEntity<>(postService.getLatestPosts(), HttpStatus.OK);
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<SubModels.LeaderBoardUser>> getAmountAddedPerSecond(){
        List<SubModels.LeaderBoardUser> leaderboard = userService.getLeaderBoard();
        return new ResponseEntity<>(leaderboard,HttpStatus.OK);
    }

    @GetMapping("/cigarettes")
    public ResponseEntity<List<Cigarette>> getAllCigarettes(){
        List<Cigarette> cigarettes = cigaretteService.getAllCigarettes();
        return new ResponseEntity<>(cigarettes, HttpStatus.OK);
    }

    @PostMapping(
            value = "/addComment",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Boolean> addComment(@RequestBody SubModels.AddedComment addedComment){
        System.out.println(addedComment.toString());
        postService.addComment(addedComment.getComment(),addedComment.getPostId(),addedComment.getSessionID());
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

    @PostMapping(
            value = "/login",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<String> login(@RequestBody SubModels.Login loginData){
        System.out.println(loginData.getUsername()+" loggedIn");
        System.out.println("Password is "+loginData.getPassword());
        return new ResponseEntity<>(userService.login(loginData), HttpStatus.OK);
    }
}

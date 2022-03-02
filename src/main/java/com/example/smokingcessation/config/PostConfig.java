package com.example.smokingcessation.config;

import com.example.smokingcessation.model.Comment;
import com.example.smokingcessation.model.DailyChallenge;
import com.example.smokingcessation.model.Post;
import com.example.smokingcessation.repo.CommentRepository;
import com.example.smokingcessation.repo.DailyChallengesRepository;
import com.example.smokingcessation.repo.PostRepository;
import com.example.smokingcessation.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

//@Configuration
public class PostConfig {
//    @Bean
    CommandLineRunner commandLineRunnerPost(PostRepository postRepository, CommentRepository commentRepository, UserRepository userRepository){
        return args -> {

        };
    }
}

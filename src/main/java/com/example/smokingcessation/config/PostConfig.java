package com.example.smokingcessation.config;

import com.example.smokingcessation.repo.CommentRepository;
import com.example.smokingcessation.repo.PostRepository;
import com.example.smokingcessation.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class PostConfig {
//    @Bean
    CommandLineRunner commandLineRunnerPost(PostRepository postRepository, CommentRepository commentRepository, UserRepository userRepository){
        return args -> {

        };
    }
}

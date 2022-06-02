package com.example.smokingcessation.config;

import com.example.smokingcessation.model.Cigarette;
import com.example.smokingcessation.model.DailyChallenge;
import com.example.smokingcessation.repo.CigaretteRepository;
import com.example.smokingcessation.repo.DailyChallengesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//@Configuration
public class CigaretteConfig {
//    @Bean
    CommandLineRunner commandLineRunnerCigarette(CigaretteRepository repository){
        return args -> {
        };
    }
}

package com.example.smokingcessation.config;

import com.example.smokingcessation.model.Badge;
import com.example.smokingcessation.model.DailyChallenge;
import com.example.smokingcessation.repo.BadgeRepository;
import com.example.smokingcessation.repo.DailyChallengesRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

//@Configuration
public class BadgeConfig {
//    @Bean
    CommandLineRunner commandLineRunnerBadge(BadgeRepository repository){
        return args -> {
            ArrayList<Badge> badges = new ArrayList<>();
            badges.add(new Badge("New Start", "Created an account in UPOS",0,Integer.MAX_VALUE));
            badges.add(new Badge("1 Day Free", "Have not smoked for 1 day",1,Integer.MAX_VALUE));
            badges.add(new Badge("3 Days Free", "Have not smoked for 3 days",3,Integer.MAX_VALUE));
            badges.add(new Badge("1 Week Free", "Have not smoked for 1 week",7,Integer.MAX_VALUE));
            badges.add(new Badge("2 Weeks Free", "Have not smoked for 2 weeks",14,Integer.MAX_VALUE));
            badges.add(new Badge("Richer by 100", "Saved a total of PHP 100.00",Integer.MAX_VALUE,100));
            badges.add(new Badge("Richer by 500", "Saved a total of PHP 500.00",Integer.MAX_VALUE,500));
            badges.add(new Badge("Richer by 1K", "Saved a total of PHP 1000.00",Integer.MAX_VALUE,1000));
            badges.add(new Badge("Richer by 2K", "Saved a total of PHP 2000.00",Integer.MAX_VALUE,2000));
            repository.saveAll(badges);
        };
    }
}


/*
{name: "1 Day Free", description: "Have not smoked for 1 day", obtained: true},
      {name: "3 Days Free", description: "Have not smoked for 3 days", obtained: true},
      {name: , obtained: false},
      {name: , obtained: false},
      {name: , obtained: true},
      {name: , obtained: true},
      {name: , obtained: false},
      {name: , obtained: false}

 */
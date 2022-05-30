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
            badges.add(new Badge("New Start|Bagong Umpisa", "Created an account in UPOS|Nakagawa ng account sa UPOS",0,Integer.MAX_VALUE));
            badges.add(new Badge("1 Day Free|Isang Araw Walang Yosi", "Have not smoked for 1 day|Isang araw ng hindi nakapagyosi",1,Integer.MAX_VALUE));
            badges.add(new Badge("3 Days Free|Tatlong Araw Walang Yosi", "Have not smoked for 3 days|Tatlong araw ng hindi nakapagyosi",3,Integer.MAX_VALUE));
            badges.add(new Badge("1 Week Free|Isang Linggo Walang Yosi", "Have not smoked for 1 week|Isang linggo ng hindi nakapagyosi",7,Integer.MAX_VALUE));
            badges.add(new Badge("2 Weeks Free|Dalawang Linggo Walang Yosi", "2 Weeks Free|Dalawang Linggo Walang Yosi",14,Integer.MAX_VALUE));
            badges.add(new Badge("Richer by 100|Yumaman ng 100", "Saved a total of PHP 100.00|Nakapagtipid ng 100.00",Integer.MAX_VALUE,100));
            badges.add(new Badge("Richer by 500|Yumaman ng 500", "Saved a total of PHP 500.00|Nakapagtipid ng 500.00",Integer.MAX_VALUE,500));
            badges.add(new Badge("Richer by 1K|Yumaman ng 1000", "Saved a total of PHP 1000.00|Nakapagtipid ng 1000.00",Integer.MAX_VALUE,1000));
            badges.add(new Badge("Richer by 2K|Yumaman ng 2000", "Saved a total of PHP 2000.00|Nakapagtipid ng 2000.00",Integer.MAX_VALUE,2000));
            repository.saveAll(badges);
        };
    }
}
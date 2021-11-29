package com.example.smokingcessation.config;

import com.example.smokingcessation.model.DailyChallenge;
import com.example.smokingcessation.model.User;
import com.example.smokingcessation.repo.DailyChallengesRepository;
import com.example.smokingcessation.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Configuration
public class DailyChallengesConfig {
    @Bean
    CommandLineRunner commandLineRunnerChallenge(DailyChallengesRepository repository){
        return args -> {
            ArrayList<DailyChallenge> dailyChallenges = new ArrayList<>();
            dailyChallenges.add(new DailyChallenge("Urges for tobacco are likely to be strongest in the situations where you smoked or chewed tobacco most often, such as at parties or bars, or while feeling stressed or sipping coffee. Identify your trigger situations and have a plan in place to avoid them entirely or get through them without using tobacco."));
            dailyChallenges.add(new DailyChallenge("If you feel like you're going to give in to your tobacco craving, tell yourself that you must first wait 10 more minutes — and then do something to distract yourself for that period of time. Try going to a public, smoke-free zone. These simple tricks may be enough to derail your tobacco craving."));
            dailyChallenges.add(new DailyChallenge("Give your mouth something to do to fight a tobacco craving. Chew on sugarless gum or hard candy, or munch on raw carrots, celery, nuts or sunflower seeds — something crunchy and satisfying."));
            dailyChallenges.add(new DailyChallenge("Physical activity can help distract you from tobacco cravings and reduce their intensity. Even short burst of physical activity — such as running up and down the stairs a few times — can make a tobacco craving go away. Get out for a walk or jog."));
            dailyChallenges.add(new DailyChallenge("Smoking may have been your way to deal with stress. Resisting a tobacco craving can itself be stressful. Take the edge off stress by practicing relaxation techniques, such as deep-breathing exercises, muscle relaxation, yoga, visualization, massage or listening to calming music."));
            dailyChallenges.add(new DailyChallenge("Touch base with a family member, friend or support group member for help in your effort to resist a tobacco craving. Chat on the phone, go for a walk together, share a few laughs, or get together to commiserate about your cravings. A free telephone quit line — 800-QUIT-NOW (800-784-8669) — provides support and counseling"));
            dailyChallenges.add(new DailyChallenge("Join an online stop-smoking program. Or read a quitter's blog and post encouraging thoughts for someone else who might be struggling with tobacco cravings. Learn from how others have handled their tobacco cravings."));
            dailyChallenges.add(new DailyChallenge("Remember, trying something to beat the urge is always better than doing nothing. And each time you resist a tobacco craving, you're one step closer to being totally tobacco-free."));
            repository.saveAll(dailyChallenges);
        };
    }
}
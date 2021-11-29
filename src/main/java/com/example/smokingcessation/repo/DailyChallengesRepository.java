package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.DailyChallenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyChallengesRepository extends JpaRepository<DailyChallenge, Long> {
}

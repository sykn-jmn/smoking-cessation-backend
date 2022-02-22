package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.DailyChallenge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DailyChallengesRepository extends MongoRepository<DailyChallenge, String> {
}

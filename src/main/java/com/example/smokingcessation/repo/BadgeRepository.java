package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.Badge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BadgeRepository extends MongoRepository<Badge, String> {
}

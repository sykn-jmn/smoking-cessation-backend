package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SessionRepository extends MongoRepository<Session, String> {
    Long removeSessionByUserID(String id);
    Optional<Session> findSessionByUuid(String uuid);
    void removeSessionByUuid(String uuid);
}

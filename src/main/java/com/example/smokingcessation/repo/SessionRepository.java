package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, String> {
    Long removeSessionByUserID(Long id);
    Optional<Session> findSessionByUuid(String uuid);
    void removeSessionByUuid(String uuid);
}

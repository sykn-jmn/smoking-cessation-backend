package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.SmokingRecord;
import com.example.smokingcessation.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SmokingRecordRepository extends MongoRepository<SmokingRecord, String> {
    public List<SmokingRecord> findByUser_IdOrderByDateTimeAsc(String id);
    public Optional<SmokingRecord> findFirstByUser_IdOrderByDateTimeDesc(String id);
}


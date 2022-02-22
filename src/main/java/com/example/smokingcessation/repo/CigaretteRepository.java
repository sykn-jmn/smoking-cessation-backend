package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.Cigarette;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CigaretteRepository  extends MongoRepository<Cigarette, String> {
}

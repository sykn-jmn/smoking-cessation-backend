package com.example.smokingcessation.repo;

import com.example.smokingcessation.model.Cigarette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CigaretteRepository  extends JpaRepository<Cigarette, Long> {
}

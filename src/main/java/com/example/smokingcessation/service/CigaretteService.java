package com.example.smokingcessation.service;

import com.example.smokingcessation.model.Cigarette;
import com.example.smokingcessation.repo.CigaretteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CigaretteService {
    CigaretteRepository cigaretteRepository;

    @Autowired
    public CigaretteService(CigaretteRepository cigaretteRepository){
        this.cigaretteRepository = cigaretteRepository;
    }

    public List<Cigarette> getAllCigarettes(){
        return cigaretteRepository.findAll();
    }
}

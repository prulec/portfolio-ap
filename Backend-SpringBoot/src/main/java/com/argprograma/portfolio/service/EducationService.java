package com.argprograma.portfolio.service;

import com.argprograma.portfolio.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationService implements IEducationService {
    
    @Autowired
    private EducationRepository educationRepo;
    
}
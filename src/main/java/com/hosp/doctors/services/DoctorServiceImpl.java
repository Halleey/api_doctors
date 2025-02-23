package com.hosp.doctors.services;

import com.hosp.doctors.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl {

    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }
}

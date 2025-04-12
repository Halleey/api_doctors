package com.hosp.doctors.services;

import com.hosp.doctors.dtos.DoctorRequestDTO;
import com.hosp.doctors.dtos.DoctorResponseDTO;
import com.hosp.doctors.entities.Doctors;
import com.hosp.doctors.repositories.DoctorRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {


    private final BCryptPasswordEncoder passwordEncoder;
    private final DoctorRepository repository;
    public DoctorServiceImpl(BCryptPasswordEncoder passwordEncoder, DoctorRepository repository) {
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }


    @Override
    public DoctorResponseDTO saveDoctor(DoctorRequestDTO requestDTO) {
        Doctors doctors = new Doctors();
        doctors.setName(requestDTO.getName());
        doctors.setCrm(requestDTO.getCrm());
        doctors.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        doctors.setExpertise(requestDTO.getExpertise());
        Doctors objectDoctors = repository.save(doctors);
        return new DoctorResponseDTO(objectDoctors.getName(),objectDoctors.getCrm(), objectDoctors.getExpertise());
    }


    @Override
    public Optional<Doctors> getDoctorInfo(String name) {
        return repository.findByName(name);
    }

}

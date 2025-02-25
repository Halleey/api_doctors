package com.hosp.doctors.services;

import com.hosp.doctors.dtos.DoctorRequestDTO;
import com.hosp.doctors.dtos.DoctorResponseDTO;
import com.hosp.doctors.entities.Doctors;
import com.hosp.doctors.repositories.DoctorRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;
    private final KafkaTemplate<String, Serializable> kafkaTemplate;
    public DoctorServiceImpl(DoctorRepository repository, KafkaTemplate<String, Serializable> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public DoctorResponseDTO saveDoctor(DoctorRequestDTO requestDTO) {
        Doctors doctors = new Doctors();
        doctors.setName(requestDTO.getName());
        doctors.setCrm(requestDTO.getCrm());
        doctors.setPassword(requestDTO.getPassword());
        doctors.setExpertise(requestDTO.getExpertise());
        Doctors objectDoctors = repository.save(doctors);
        kafkaTemplate.send("Hospital",  1, "doctorsKey", requestDTO );
        return new DoctorResponseDTO(objectDoctors.getName(),objectDoctors.getCrm(), objectDoctors.getExpertise());
    }

    @Override
    public Optional<Doctors> getDoctorInfo(String name, String password) {
        return repository.findByNameAndPassword(name, password);
    }
}

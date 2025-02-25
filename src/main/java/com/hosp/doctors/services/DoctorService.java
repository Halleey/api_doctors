package com.hosp.doctors.services;

import com.hosp.doctors.dtos.DoctorRequestDTO;
import com.hosp.doctors.dtos.DoctorResponseDTO;
import com.hosp.doctors.entities.Doctors;

import java.util.Optional;

public interface DoctorService {

    public DoctorResponseDTO saveDoctor(DoctorRequestDTO requestDTO);

    public Optional<Doctors> getDoctorInfo(String name, String password);
}

package com.hosp.doctors.services;

import com.hosp.doctors.dtos.doctors.DoctorRequestDTO;
import com.hosp.doctors.dtos.doctors.DoctorResponseDTO;
import com.hosp.doctors.entities.Doctors;

import java.util.Optional;

public interface DoctorService {

    DoctorResponseDTO saveDoctor(DoctorRequestDTO requestDTO);

    Optional<Doctors> getDoctorInfo(String name);
}

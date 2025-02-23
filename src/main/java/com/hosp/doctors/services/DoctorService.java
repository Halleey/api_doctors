package com.hosp.doctors.services;

import com.hosp.doctors.dtos.DoctorRequestDTO;
import com.hosp.doctors.dtos.DoctorResponseDTO;

public interface DoctorService {

    public DoctorResponseDTO saveDoctor(DoctorRequestDTO requestDTO);
}

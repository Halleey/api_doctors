package com.hosp.doctors.services;


import com.hosp.doctors.dtos.NursesRequestDTO;
import com.hosp.doctors.entities.Nurses;

import java.util.Optional;

public interface NursesService {

    void saveNurse(NursesRequestDTO requestDTO);

    Optional<Nurses> getDoctorInfo(String name);
}

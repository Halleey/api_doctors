package com.hosp.doctors.controllers;

import com.hosp.doctors.dtos.DoctorRequestDTO;
import com.hosp.doctors.dtos.DoctorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface DoctorController {

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> saveDoctors(@RequestBody  DoctorRequestDTO requestDTO);
}

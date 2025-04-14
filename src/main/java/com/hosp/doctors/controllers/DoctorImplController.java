package com.hosp.doctors.controllers;

import com.hosp.doctors.dtos.AuthRequestDTO;
import com.hosp.doctors.dtos.doctors.DoctorLoginDTO;
import com.hosp.doctors.dtos.doctors.DoctorRequestDTO;
import com.hosp.doctors.dtos.doctors.DoctorResponseDTO;
import com.hosp.doctors.entities.Doctors;
import com.hosp.doctors.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorImplController implements DoctorController {

    private final DoctorService doctorService;
    private final BCryptPasswordEncoder passwordEncoder;
    public DoctorImplController(DoctorService doctorService, BCryptPasswordEncoder passwordEncoder) {
        this.doctorService = doctorService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> saveDoctors(DoctorRequestDTO requestDTO) {
        DoctorResponseDTO responseDTO = doctorService.saveDoctor(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Override
    public ResponseEntity<DoctorLoginDTO> getDoctor(AuthRequestDTO requestDTO) {
        Optional<Doctors> doctors = doctorService.getDoctorInfo(requestDTO.getName());

        return doctors.filter(doctor -> passwordEncoder.matches(requestDTO.getPassword(), doctor.getPassword()))
                .map(doctor -> ResponseEntity.ok(
                        new DoctorLoginDTO(doctor.getName(), doctor.getCrm(), doctor.getExpertise(), doctor.role())
                ))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}


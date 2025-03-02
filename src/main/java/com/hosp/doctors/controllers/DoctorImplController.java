package com.hosp.doctors.controllers;

import com.hosp.doctors.dtos.DoctorLoginDTO;
import com.hosp.doctors.dtos.DoctorRequestDTO;
import com.hosp.doctors.dtos.DoctorResponseDTO;
import com.hosp.doctors.entities.Doctors;
import com.hosp.doctors.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorImplController implements DoctorController {

    private final DoctorService doctorService;

    public DoctorImplController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> saveDoctors(DoctorRequestDTO requestDTO) {
        DoctorResponseDTO responseDTO = doctorService.saveDoctor(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Override
    public ResponseEntity<DoctorLoginDTO> getDoctor(String name, String password) {
        Optional<Doctors> doctors = doctorService.getDoctorInfo(name, password);
        return doctors.map(value -> ResponseEntity.ok(
                new DoctorLoginDTO(value.getName(), value.getCrm(), value.getExpertise(), value.role())
        )).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}


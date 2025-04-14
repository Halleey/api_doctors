package com.hosp.doctors.controllers.doctors;
import com.hosp.doctors.dtos.AuthRequestDTO;
import com.hosp.doctors.dtos.doctors.DoctorLoginDTO;
import com.hosp.doctors.dtos.doctors.DoctorRequestDTO;
import com.hosp.doctors.dtos.doctors.DoctorResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface DoctorController {

    @PostMapping
    public ResponseEntity<DoctorResponseDTO> saveDoctors(@RequestBody  DoctorRequestDTO requestDTO);

    @PostMapping("/login")
    public  ResponseEntity<DoctorLoginDTO> getDoctor(@RequestBody AuthRequestDTO requestDTO);
}

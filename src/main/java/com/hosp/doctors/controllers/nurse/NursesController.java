package com.hosp.doctors.controllers.nurse;

import com.hosp.doctors.dtos.AuthRequestDTO;
import com.hosp.doctors.dtos.NurseResponseDTO;
import com.hosp.doctors.dtos.NursesRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface NursesController {

    @PostMapping
    ResponseEntity<String> insertNurses(@RequestBody NursesRequestDTO requestDTO);

    @PostMapping("/login")
    ResponseEntity<NurseResponseDTO> getNurse(@RequestBody AuthRequestDTO requestDTO);
}

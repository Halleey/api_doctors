package com.hosp.doctors.controllers.nurse;

import com.hosp.doctors.dtos.AuthRequestDTO;
import com.hosp.doctors.dtos.NurseResponseDTO;
import com.hosp.doctors.dtos.NursesRequestDTO;
import com.hosp.doctors.entities.Nurses;
import com.hosp.doctors.services.NursesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/nurse")
public class NursesControllerImpl implements NursesController {


    private final NursesService nursesService;
    private final BCryptPasswordEncoder passwordEncoder;
    public NursesControllerImpl(NursesService nursesService, BCryptPasswordEncoder passwordEncoder) {
        this.nursesService = nursesService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<String> insertNurses(NursesRequestDTO requestDTO) {
        nursesService.saveNurse(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Enfermeira(o) criado com sucesso ✅");
    }

    @Override
    public ResponseEntity<NurseResponseDTO> getNurse(AuthRequestDTO requestDTO) {
        Optional<Nurses> nurse = nursesService.getNurse(requestDTO.getName());

        return nurse.filter(n -> passwordEncoder.matches(requestDTO.getPassword(), n.getPassword()))
                .map(n -> ResponseEntity.ok(
                        new NurseResponseDTO(n.getName(), n.getRegistrationNumber(), n.getShift(), n.getRole())
                ))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

}

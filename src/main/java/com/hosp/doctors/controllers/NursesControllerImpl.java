package com.hosp.doctors.controllers;

import com.hosp.doctors.dtos.NursesRequestDTO;
import com.hosp.doctors.services.NursesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nurse")
public class NursesControllerImpl implements NursesController {


    private final NursesService nursesService;

    public NursesControllerImpl(NursesService nursesService) {
        this.nursesService = nursesService;
    }

    @Override
    public ResponseEntity<String> insertNurses(NursesRequestDTO requestDTO) {
        nursesService.saveNurse(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Enfermeira(o) criado com sucesso ✅");
    }
}

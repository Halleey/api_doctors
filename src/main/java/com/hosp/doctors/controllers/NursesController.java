package com.hosp.doctors.controllers;

import com.hosp.doctors.dtos.NursesRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface NursesController {

    @PostMapping
    ResponseEntity<String> insertNurses(@RequestBody NursesRequestDTO requestDTO);
}

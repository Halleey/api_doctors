package com.hosp.doctors.services;

import com.hosp.doctors.dtos.NursesRequestDTO;
import com.hosp.doctors.entities.Nurses;
import com.hosp.doctors.repositories.NursesRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class NursesServiceImpl implements NursesService {

    private final NursesRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;
    public NursesServiceImpl(NursesRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveNurse(NursesRequestDTO requestDTO) {
        String encripted = passwordEncoder.encode(requestDTO.getPassword());
        Nurses nurses = new Nurses();
        nurses.setName(requestDTO.getName());
        nurses.setRegistrationNumber(requestDTO.getRegistrationNumber());
        nurses.setShift(requestDTO.getShift());
        nurses.setPassword(encripted);
        repository.save(nurses);
    }
}

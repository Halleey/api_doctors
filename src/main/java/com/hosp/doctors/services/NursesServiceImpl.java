package com.hosp.doctors.services;

import com.hosp.doctors.dtos.NursesRequestDTO;
import com.hosp.doctors.entities.Nurses;
import com.hosp.doctors.repositories.NursesRepository;
import org.springframework.stereotype.Service;

@Service
public class NursesServiceImpl implements NursesService {

    private final NursesRepository repository;

    public NursesServiceImpl(NursesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveNurse(NursesRequestDTO requestDTO) {
        Nurses nurses = new Nurses();
        nurses.setName(requestDTO.getName());
        nurses.setRegistrationNumber(requestDTO.getRegistrationNumber());
        nurses.setShift(requestDTO.getShift());
        nurses.setPassword(requestDTO.getPassword());
        repository.save(nurses);
    }
}

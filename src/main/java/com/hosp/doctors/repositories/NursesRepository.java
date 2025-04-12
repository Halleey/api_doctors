package com.hosp.doctors.repositories;


import com.hosp.doctors.entities.Nurses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NursesRepository extends JpaRepository<Nurses, UUID> {


}

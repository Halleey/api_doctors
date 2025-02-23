package com.hosp.doctors.repositories;

import com.hosp.doctors.entities.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctors, UUID> {
}

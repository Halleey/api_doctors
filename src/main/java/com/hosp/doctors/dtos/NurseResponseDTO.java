package com.hosp.doctors.dtos;

import com.hosp.doctors.entities.Role;
import com.hosp.doctors.entities.Shift;

public class NurseResponseDTO {

    private String name;
    private String registrationNumber;
    private Shift shift;
    private String role;

    public NurseResponseDTO(String name, String registrationNumber, Shift shift, Role role) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.shift = shift;
        this.role = (role != null) ? role.name() : "ROLE_DEFAULT";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

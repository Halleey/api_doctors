package com.hosp.doctors.dtos;

import com.hosp.doctors.entities.Shift;

public class NursesRequestDTO {

    private String name;
    private String registrationNumber;
    private Shift shift;


    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Shift getShift() {
        return shift;
    }
}

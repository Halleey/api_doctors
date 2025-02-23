package com.hosp.doctors.dtos;

public class DoctorResponseDTO {
    private String name;
    private String crm;
    private String expertise;

    public DoctorResponseDTO(String name, String crm, String expertise) {
        this.name = name;
        this.crm = crm;
        this.expertise = expertise;
    }

    public String getName() {
        return name;
    }

    public String getCrm() {
        return crm;
    }

    public String getExpertise() {
        return expertise;
    }
}

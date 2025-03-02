package com.hosp.doctors.dtos;

import com.hosp.doctors.entities.Role;
public class DoctorLoginDTO {
    private String name;
    private String crm;
    private String expertise;
    private String role; // Mantendo como String para facilitar o uso no JWT

    public DoctorLoginDTO(String name, String crm, String expertise, Role role) {
        this.name = name;
        this.crm = crm;
        this.expertise = expertise;
        this.role = (role != null) ? role.name() : "ROLE_DEFAULT"; // Converte Enum para String
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

    public String getRole() {
        return role; // Retorna a role como String
    }

    @Override
    public String toString() {
        return "DoctorLoginDTO{" +
                "name='" + name + '\'' +
                ", crm='" + crm + '\'' +
                ", expertise='" + expertise + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

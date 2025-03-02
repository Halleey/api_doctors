package com.hosp.doctors.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String crm;
    private String password;
    private String expertise;
    @Enumerated(EnumType.STRING)
    private com.hosp.doctors.entities.Role role = Role.ROLE_DOCTOR;

    public Role role() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

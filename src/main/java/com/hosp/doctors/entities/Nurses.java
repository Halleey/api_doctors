package com.hosp.doctors.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Nurses {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String registrationNumber;
    @Enumerated(EnumType.STRING)
    private com.hosp.doctors.entities.Role role = Role.ROLE_NURSE;
    @Enumerated(EnumType.STRING)
    private Shift shift;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
}

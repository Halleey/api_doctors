package com.hosp.doctors.dtos;
import java.io.Serializable;
public class DoctorRequestDTO implements Serializable {

    private String name;
    private String crm;
    private String password;
    private String expertise;

    public String getName() {
        return name;
    }

    public String getCrm() {
        return crm;
    }

    public String getPassword() {
        return password;
    }

    public String getExpertise() {
        return expertise;
    }
}

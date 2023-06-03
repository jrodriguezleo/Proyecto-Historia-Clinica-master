/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import Users.Patient;

/**
 *
 * @author leons
 */
public class DoctorDate {

    public DoctorDate(Patient patient, String date, String reason) {
        this.patient = patient;
        this.date = date;
        this.reason = reason;
    }
    
    
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    private String date;
    private String reason;
    
}

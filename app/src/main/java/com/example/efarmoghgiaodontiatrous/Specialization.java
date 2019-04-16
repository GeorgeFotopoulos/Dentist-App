package com.example.efarmoghgiaodontiatrous;

public class Specialization {
    private String specializationName, specializationID;

    public Specialization() {
    }

    public Specialization(String specializationName, String specializationID) {
        this.specializationName = specializationName;
        this.specializationID = specializationID;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

    public String getSpecializationID() {
        return specializationID;
    }

    public void setSpecializationID(String specializationID) {
        this.specializationID = specializationID;
    }
}
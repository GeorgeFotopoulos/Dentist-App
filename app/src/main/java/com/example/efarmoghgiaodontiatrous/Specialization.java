package com.example.efarmoghgiaodontiatrous;

public class Specialization {
    private String specializationName, specializationID;

    public Specialization() {
    }

    public Specialization(Specialization other) {
        this.specializationName = other.specializationName;
        this.specializationID = other.specializationID;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        return specializationID.equals(that.specializationID);
    }

    @Override
    public int hashCode() {
        if (specializationID == null) {
            return 0;
        }
        return specializationID.hashCode();
    }
}
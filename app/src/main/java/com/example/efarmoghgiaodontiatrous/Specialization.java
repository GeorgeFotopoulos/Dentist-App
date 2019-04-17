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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        if (!specializationName.equals(that.specializationName)) return false;
        return specializationID.equals(that.specializationID);
    }

    @Override
    public int hashCode() {
        int result = specializationName.hashCode();
        result = 31 * result + specializationID.hashCode();
        return result;
    }
}
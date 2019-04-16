package com.example.efarmoghgiaodontiatrous;

import java.util.HashSet;
import java.util.Set;

public class Dentist {
    private String firstName, lastName, telephoneNo, email, exerciseLicense, universityAttended, infirmaryLocation, password, dentistID;
    private int timeOfExperience;
    private Set<Specialization> specializations = new HashSet<>();
    private Set<Service> services = new HashSet<>();

    public Dentist() {
    }

    public Dentist(String firstName, String lastName, String telephoneNo, String email, String exerciseLicense, String universityAttended, String infirmaryLocation, int timeOfExperience, String password, String dentistID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.email = email;
        this.exerciseLicense = exerciseLicense;
        this.universityAttended = universityAttended;
        this.infirmaryLocation = infirmaryLocation;
        this.timeOfExperience = timeOfExperience;
        this.password = password;
        this.dentistID = dentistID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExerciseLicense() {
        return exerciseLicense;
    }

    public void setExerciseLicense(String exerciseLicense) {
        this.exerciseLicense = exerciseLicense;
    }

    public String getUniversityAttended() {
        return universityAttended;
    }

    public void setUniversityAttended(String universityAttended) {
        this.universityAttended = universityAttended;
    }

    public String getInfirmaryLocation() {
        return infirmaryLocation;
    }

    public void setInfirmaryLocation(String infirmaryLocation) {
        this.infirmaryLocation = infirmaryLocation;
    }

    public String getDentistID() {
        return dentistID;
    }

    public void setDentistID(String dentistID) {
        this.dentistID = dentistID;
    }

    public int getTimeOfExperience() {
        return timeOfExperience;
    }

    public void setTimeOfExperience(int timeOfExperience) {
        this.timeOfExperience = timeOfExperience;
    }

    public Set<Specialization> getSpecializations() {
        return new HashSet<>(specializations);
    }

    public Set<Service> getServices() {
        return new HashSet<>(services);
    }

    public void addService(Service service) {
        if (service != null) {
            this.services.add(service);
        }
    }

    public void removeService(Service service) {
        if (service != null) {
            this.services.remove(service);
        }
    }

    public void addSpecialization(Specialization specialization) {
        if (specialization != null) {
            this.specializations.add(specialization);
        }
    }

    public void removeSpecialization(Specialization specialization) {
        if (specialization != null) {
            this.specializations.remove(specialization);
        }
    }
}
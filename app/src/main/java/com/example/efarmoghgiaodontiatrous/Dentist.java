package com.example.efarmoghgiaodontiatrous;

import java.util.HashSet;
import java.util.Set;

public class Dentist {
    private String firstName, lastName, telephoneNo, email, exerciseLicense, universityAttended, password, dentistID;
    private int timeOfExperience;
    private Address infirmaryLocation;
    private static int ID = 0;
    private Set<Specialization> specializations = new HashSet<>();
    private Set<Service> services = new HashSet<>();
    private Set<Appointment> appointments = new HashSet<>();

    public Dentist() {
        this.dentistID = ID + "";
        ID++;
    }

    public Dentist(String firstName, String lastName, String telephoneNo, String email, String exerciseLicense, String universityAttended, Address infirmaryLocation, int timeOfExperience, String password, String dentistID) {
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

    public Address getInfirmaryLocation() {
        return infirmaryLocation;
    }

    public void setInfirmaryLocation(Address infirmaryLocation) {
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

    public Set<Appointment> getAppointments() {
        return new HashSet<>(appointments);
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

    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            this.appointments.add(appointment);
        }
    }

    public void removeAppointment(Appointment appointment) {
        if (appointment != null) {
            this.appointments.remove(appointment);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dentist dentist = (Dentist) o;

        return dentistID.equals(dentist.dentistID);
    }

    @Override
    public int hashCode() {
        return dentistID.hashCode();
    }
}
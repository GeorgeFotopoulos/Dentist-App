package com.example.efarmoghgiaodontiatrous;

import java.util.HashSet;
import java.util.Set;

public class Dentist {
    private String firstName, lastName, telephoneNo, email, exerciseLicense, universityAttended, password, dentistID;
    private int timeOfExperience;
    private Address infirmaryLocation;
    private static int ID = 0;
    private ConnectionState state;
    Visit visit;
    private Set<Specialization> specializations = new HashSet<>();
    private Set<Service> services = new HashSet<>();
    private Set<Appointment> appointments = new HashSet<>();

    public Dentist() {
        this.dentistID = ID + "";
        ID++;
        this.setState(ConnectionState.DISCONNECTED);
    }

    public Dentist(Dentist dentist) {
        this.firstName = dentist.getFirstName();
        this.lastName = dentist.getLastName();
        this.telephoneNo = dentist.getTelephoneNo();
        this.email = dentist.getEmail();
        this.exerciseLicense = dentist.getExerciseLicense();
        this.universityAttended = dentist.getUniversityAttended();
        this.infirmaryLocation = dentist.getInfirmaryLocation();
        this.timeOfExperience = dentist.getTimeOfExperience();
        this.password = dentist.getPassword();
        this.dentistID = dentist.getID();
        this.state = dentist.getState();
    }

    public Dentist(String firstName, String lastName, String telephoneNo, String email, String exerciseLicense, String universityAttended, Address infirmaryLocation, int timeOfExperience, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.email = email;
        this.exerciseLicense = exerciseLicense;
        this.universityAttended = universityAttended;
        this.infirmaryLocation = infirmaryLocation;
        this.timeOfExperience = timeOfExperience;
        this.password = password;
        this.dentistID = ID + "";
        ID++;
        this.setState(ConnectionState.DISCONNECTED);
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

    public int getTimeOfExperience() {
        return timeOfExperience;
    }

    public void setTimeOfExperience(int timeOfExperience) {
        this.timeOfExperience = timeOfExperience;
    }

    public String getID() {
        return dentistID;
    }

    public void setID(String dentistID) {
        this.dentistID = dentistID;
    }

    public ConnectionState getState() {
        return state;
    }

    public void setState(ConnectionState state) {
        this.state = state;
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

    public void acceptAppointment(Appointment appointment) {
        this.appointments.remove(appointment);
        if (appointment != null) {
            if (!appointment.getState().equals(AppointmentState.ACCEPTED))
                appointment.setState(AppointmentState.ACCEPTED);
            this.appointments.add(appointment);
        }
    }

    public void declineAppointment(Appointment appointment) {
        if (appointment != null) {
            this.appointments.remove(appointment);
        }
    }

    public void login(String email, String password) {
        if (this.getEmail().equals(email) && this.getPassword().equals(password)) {
            this.setState(ConnectionState.CONNECTED);
        }
    }

    public void recordVisit(SimpleCalendar dateOfVisit, String comments, Dentist dentist, Client client, Service service) {
        if (dentist.services.contains(service)) {
            visit = new Visit(dateOfVisit, comments, dentist, client, services);
        }
    }

    public void createClientCard(String AMKA) {
        Client client = new Client();
        client.setAMKA(AMKA);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dentist dentist = (Dentist) o;

        if (!email.equals(dentist.email)) return false;
        return password.equals(dentist.password);
    }

    @Override
    public int hashCode() {
        if (this.email == null && this.password == null) {
            return 0;
        }
        int result = email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
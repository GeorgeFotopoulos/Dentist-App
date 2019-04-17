package com.example.efarmoghgiaodontiatrous;

public class Appointment {
    private String firstName, lastName, telephoneNo, email;
    private AppointmentState state;
    private Dentist dentist;
    private SystemDate bookDate;

    public Appointment() {
    }

    public Appointment(String firstName, String lastName, String telephoneNo, String email, AppointmentState state, Dentist dentist, SystemDate bookDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.email = email;
        this.state = state;
        this.dentist = dentist;
        this.bookDate = bookDate;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
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

    public AppointmentState getState() {
        return state;
    }

    public void setState(AppointmentState state) {
        this.state = state;
    }

    public SystemDate getBookDate() {
        return bookDate;
    }

    public void setBookDate(SystemDate bookDate) {
        this.bookDate = bookDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (!dentist.equals(that.dentist)) return false;
        return bookDate.equals(that.bookDate);
    }

    @Override
    public int hashCode() {
        int result = dentist.hashCode();
        result = 31 * result + bookDate.hashCode();
        return result;
    }
}
package com.example.efarmoghgiaodontiatrous;

import java.util.Calendar;

public class Appointment {
    private String firstName, lastName, telephoneNo, email;
    private AppointmentState state;
    private Dentist dentist;
    private SimpleCalendar bookDate;

    public Appointment() {
        new Dentist();
        new SimpleCalendar(Calendar.getInstance());
        this.setState(AppointmentState.PENDING);
    }

    public Appointment(Appointment appointment){
        this.setFirstName(appointment.getFirstName());
        this.setLastName(appointment.getLastName());
        this.setTelephoneNo(appointment.getTelephoneNo());
        this.setEmail(appointment.getEmail());
        this.setDentist(appointment.getDentist());
        this.setBookDate(appointment.getBookDate());
        this.setState(AppointmentState.PENDING);
    }

    public Appointment(String firstName, String lastName, String telephoneNo, String email, Dentist dentist, SimpleCalendar bookDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNo = telephoneNo;
        this.email = email;
        this.dentist = dentist;
        this.bookDate = bookDate;
        this.setState(AppointmentState.PENDING);
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist){
        this.dentist = new Dentist(dentist);
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

    public SimpleCalendar getBookDate() {
        return bookDate;
    }

    public void setBookDate(SimpleCalendar bookDate) {
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
        if (dentist == null && bookDate == null) {
            return 0;
        }
        int result = dentist.hashCode();
        result = 31 * result + bookDate.hashCode();
        return result;
    }
}
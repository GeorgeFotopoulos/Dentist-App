package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

/**
 * The type Request appointment presenter.
 */
public class RequestAppointmentPresenter {
    /**
     * The View.
     */
    protected RequestAppointmentView view;

    /**
     * Instantiates a new Request appointment presenter.
     *
     * @param view the view
     */
    public RequestAppointmentPresenter(RequestAppointmentView view) {
        this.view = view;
    }

    /**
     * This method finds and returns a Dentist object using its ID.
     *
     * @param ID Dentist's ID
     * @return Dentist object with the ID given as a parameter
     */
    Dentist findDentistByID(String ID) {
        DentistDAOMemory dDAOMemory = new DentistDAOMemory();
        Dentist D = dDAOMemory.find(ID);
        return D;
    }

    /**
     * This method is used by the client to request an appointment from a specific Dentist, on a specific Date & Time.
     * Client has to fill in his first name, last name & contact number.
     *
     * @param dentist   Dentist who will carry out the appointment
     * @param calendar  Appointment's date field
     * @param time      Appointment's time field
     * @param telephone Client's contact number
     * @param lastName  Client's last name
     * @param firstName Client's first name
     */
    public void requestAppointment(Dentist dentist, SimpleCalendar calendar, String time, String telephone, String lastName, String firstName) {
        if (calendar == null && !(time == null || time.equals("") || telephone.equals("") || lastName.equals("") || firstName.equals(""))) {
            view.showError("Picking an appointment date on the calendar is required!");
            return;
        } else if (firstName.equals("") && !(calendar == null || time == null || time.equals("") || telephone.equals("") || lastName.equals(""))) {
            view.showError("The First Name field is required!");
            return;
        } else if (lastName.equals("") && !(calendar == null || time == null || time.equals("") || telephone.equals("") || firstName.equals(""))) {
            view.showError("The Last Name field is required!");
            return;
        } else if (telephone.equals("") && !(calendar == null || time == null || time.equals("") || lastName.equals("") || firstName.equals(""))) {
            view.showError("The Contact Number field is required!");
            return;
        } else if (time.equals("") && !(calendar == null || telephone.equals("") || lastName.equals("") || firstName.equals(""))) {
            view.showError("The Appointment Time field is required!");
            return;
        } else if (calendar == null || time.equals("") || telephone.equals("") || lastName.equals("") || firstName.equals("")) {
            view.showError("You have to pick a date and fill in all the data!");
            return;
        }
        if (time.length() != 5) {
            view.showError("Invalid input, please choose between 09:00 - 21:00, using either \"hh:00\" or \"hh:30\" format!");
            return;
        } else {
            try {
                String hour = new StringBuilder().append(time.charAt(0)).append(time.charAt(1)).toString();
                if (time.charAt(0) == '0' && time.charAt(1) != '9') {
                    view.showError("Invalid input, please choose between 09:00 - 21:00!");
                    return;
                }
                int hourValue = Integer.parseInt(hour);
                if (hourValue > 21) {
                    view.showError("Invalid input, please choose between 09:00 - 21:00!");
                    return;
                }
                int minuteValue = Integer.parseInt(new StringBuilder().append(time.charAt(3)).append(time.charAt(4)).toString());
                if (minuteValue != 00 && minuteValue != 30) {
                    view.showError("Invalid time format. Should be in format \"hh:00\" or \"hh:30\"!");
                    return;
                }
                if (time.charAt(2) != ':') {
                    view.showError("Invalid time format. Should be in format \"hh:00\" or \"hh:30\"!");
                    return;
                }
                AppointmentDAOMemory DAO = new AppointmentDAOMemory();
                int tempSize = DAO.findAll().size();
                DAO.save(new Appointment(firstName, lastName, telephone, dentist, calendar, hourValue, minuteValue));
                if (tempSize == DAO.findAll().size()) {
                    view.showError("There's already an appointment for the selected time & date for that particular dentist!");
                } else {
                    view.success("Appointment request submitted!");
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

public class RequestAppointmentPresenter {
    protected RequestAppointmentView view;

    public RequestAppointmentPresenter(RequestAppointmentView view) {
        this.view = view;
    }

    Dentist updateDentInfoText(String ID) {
        DentistDAOMemory dDAOMemory = new DentistDAOMemory();
        Dentist D = dDAOMemory.find(ID);
        return D;
    }

    public void reqAppointment(Dentist dentist, SimpleCalendar calendar, String time, String telephone, String lastName, String firstName) {
        if (dentist == null) {
            view.showError("An error occurred, try again later!");
            return;
        } else if (calendar == null) {
            view.showError("You have to select a day at the calendar!");
            return;
        } else if (time == null || time.equals("")) {
            view.showError("You have to enter a time value!");
            return;
        } else if (telephone.equals("")) {
            view.showError("You have to enter a valid Contact Number, which the doctor will use to contact you about your appointment!");
            return;
        } else if (lastName.equals("")) {
            view.showError("You have to enter a Last Name!");
            return;
        } else if (firstName.equals("")) {
            view.showError("You have to enter a First Name!");
            return;
        }
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
                view.showError("Wrong Time format. Should be of format \"hh:00\" or \"hh:30\"");
                return;
            }
            AppointmentDAOMemory DAO = new AppointmentDAOMemory();
            int tempSize=DAO.findAll().size();
            DAO.save(new Appointment(firstName, lastName, telephone, dentist, calendar, hourValue, minuteValue));
            if(tempSize==DAO.findAll().size()){
                view.showError("Dentist has already an appointment at the slected Time and Date");
            }
            else {
                view.success("Appointment request submitted!");
            }
        } catch (Exception e) {
            view.showError("Wrong Time format. Should be in format \"hh:00\" or \"hh:30\"");
            return;
        }
    }
}
package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewSchedule;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

public class ViewSchedulePresenter {
    ViewScheduleView view;

    public ViewSchedulePresenter(ViewScheduleView view) {
        this.view = view;
    }

    public String onWelcome(String ID) {
        DentistDAOMemory ddao = new DentistDAOMemory();
        return "Welcome Dr. " + ddao.find(ID).getLastName() + "! \n Here you can see the appointments you have:";
    }

    public String onSchedule(String ID) {
        DentistDAOMemory ddao = new DentistDAOMemory();
        AppointmentDAOMemory adao = new AppointmentDAOMemory();
        Dentist dentist = ddao.find(ID);
        String result = "";
        for (Appointment key : adao.find(dentist, AppointmentState.ACCEPTED)) {
            result = result + "Date: " + key.getBookDate().getDayOfMonth() + "/" + key.getBookDate().getMonth() + "/" + key.getBookDate().getYear() + " \n" + "Time: " + key.getHour() + ":" + key.getMinutes() + " \n" + "Name: " + key.getLastName() + " " + key.getFirstName() + " \n" + "Phone: " + key.getTelephoneNo() + " \n \n";
        }
        if (result != "") {
            return result;
        } else {
            return "You have no appointments :(";
        }
    }
}
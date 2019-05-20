package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

public class RequestAppointmentPresenter {
    RequestAppointmentView view;

    public RequestAppointmentPresenter(RequestAppointmentView view) {
        this.view = view;
    }

    Dentist updateDentInfoText(String ID){
        DentistDAOMemory dDAOMemory = new DentistDAOMemory();
        Dentist D = dDAOMemory.find(ID);
        return D;
    }

    public void reqAppointment(Dentist D, SimpleCalendar calendar, String Time){

    }
}

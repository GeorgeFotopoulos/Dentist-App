package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

public class DentistAppointmentManagementPresenter {

    private final DentistAppointmentManagementView view;

    DentistAppointmentManagementPresenter(DentistAppointmentManagementView view){
        this.view=view;
    }

    public String[] getAppointments(String ID) {
        AppointmentDAOMemory aDAO=new AppointmentDAOMemory();
        DentistDAOMemory dDAO=new DentistDAOMemory();
        Dentist tempDent=dDAO.find(ID);

        return aDAO.findtoString(tempDent);
    }
}

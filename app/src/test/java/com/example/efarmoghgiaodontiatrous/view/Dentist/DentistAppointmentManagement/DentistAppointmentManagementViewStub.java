package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement;

public class DentistAppointmentManagementViewStub implements DentistAppointmentManagementView {
    private String message;

    @Override
    public void jobDone(String msg) {
        this.message = msg;
    }

    public String getMessage(){
        return this.message;
    }
}
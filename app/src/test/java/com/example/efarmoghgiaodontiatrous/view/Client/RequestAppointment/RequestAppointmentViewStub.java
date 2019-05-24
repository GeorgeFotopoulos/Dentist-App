package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

public class RequestAppointmentViewStub implements RequestAppointmentView {
    protected String message;

    @Override
    public void showError(String msg) {
        this.message = msg;
    }

    @Override
    public void success(String msg) {
        this.message = msg;
    }
}
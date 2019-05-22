package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

public class RequestAppointmentViewStub implements RequestAppointmentView {
    private String message;

    @Override
    public void showError(String msg) {
        this.message = msg;
    }

    @Override
    public void success(String msg) {
        this.message = msg;
    }
}
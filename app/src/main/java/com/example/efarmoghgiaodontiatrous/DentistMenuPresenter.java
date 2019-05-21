package com.example.efarmoghgiaodontiatrous;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DentistMenuPresenter {
    private DentistMenuView view;


    public DentistMenuPresenter(DentistMenuView view) {
        this.view = view;
    }

    public void onViewProfile() {
        view.viewProfile();
    }

    public void onUpdateAccount(){
        view.updateAccount();
    }

    public void onViewClientHistory(){
        view.viewClientHistory();
    }

    public void onAppointmentManagement(){
        view.appointmentManagement();
    }

    public void onViewStatistics(){
        view.viewStatistics();
    }

    public void onViewAppointmentSchedule(){
        view.viewAppointmentSchedule();
    }

    public void onRecordProvidedService(){
        view.recordProvidedService();
    }

}

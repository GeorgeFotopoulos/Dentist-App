package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu;

/**
 * Depending on the click of the Dentist he will be redirected in some other Activities
 */
public class DentistMenuPresenter {
    private DentistMenuView view;

    public DentistMenuPresenter(DentistMenuView view) {
        this.view = view;
    }

    public void onViewProfile() {
        view.viewProfile();
    }

    public void onUpdateAccount() {
        view.updateAccount();
    }

    public void onViewClientHistory() {
        view.viewClientHistory();
    }

    public void onAppointmentManagement() {
        view.appointmentManagement();
    }

    public void onViewStatistics() {
        view.viewStatistics();
    }

    public void onViewAppointmentSchedule() {
        view.viewAppointmentSchedule();
    }

    public void onRecordProvidedService() {
        view.recordProvidedService();
    }
}
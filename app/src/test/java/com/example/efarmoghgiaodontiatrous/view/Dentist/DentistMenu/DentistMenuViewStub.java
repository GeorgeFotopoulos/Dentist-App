package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu;

public class DentistMenuViewStub implements DentistMenuView {
    private int
            manageViewProfileClicks,
            manageUpdateAccountClicks,
            manageViewClientHistoryClicks,
            manageAppointmentManagementClicks,
            manageViewStatisticsClicks,
            manageViewAppointmentScheduleClicks,
            manageRecordProvidedServicesClicks;

    private DentistMenuPresenter presenter;

    public DentistMenuPresenter getPresenter() {
        return this.presenter;
    }

    public void setPresenter(DentistMenuPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void viewProfile() {
        manageViewProfileClicks++;
    }

    @Override
    public void updateAccount() {
        manageUpdateAccountClicks++;
    }

    @Override
    public void viewClientHistory() {
        manageViewClientHistoryClicks++;
    }

    @Override
    public void appointmentManagement() {
        manageAppointmentManagementClicks++;
    }

    @Override
    public void viewStatistics() {
        manageViewStatisticsClicks++;
    }

    @Override
    public void viewAppointmentSchedule() {
        manageViewAppointmentScheduleClicks++;
    }

    @Override
    public void recordProvidedService() {
        manageRecordProvidedServicesClicks++;
    }

    public int getManageViewProfileClicks() {
        return manageViewProfileClicks;
    }

    public int getManageUpdateAccountClicks() {
        return manageUpdateAccountClicks;
    }

    public int getManageViewClientHistoryClicks() {
        return manageViewClientHistoryClicks;
    }

    public int getManageAppointmentManagementClicks() {
        return manageAppointmentManagementClicks;
    }

    public int getManageViewStatisticsClicks() {
        return manageViewStatisticsClicks;
    }

    public int getManageViewAppointmentScheduleClicks() {
        return manageViewAppointmentScheduleClicks;
    }

    public int getManageRecordProvidedServicesClicks() {
        return manageRecordProvidedServicesClicks;
    }
}
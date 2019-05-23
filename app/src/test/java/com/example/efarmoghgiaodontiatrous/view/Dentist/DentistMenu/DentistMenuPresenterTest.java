package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistMenu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DentistMenuPresenterTest {
    private DentistMenuPresenter presenter;
    private DentistMenuViewStub view;

    @Before
    public void setUp() {
        view = new DentistMenuViewStub();
        presenter = new DentistMenuPresenter(view);
        view.setPresenter(presenter);
    }

    @Test
    public void testViewProfile() {
        for (int i = 0; i < 10; i++) {
            presenter.onViewProfile();
        }
        Assert.assertEquals(10, view.getManageViewProfileClicks());
    }

    @Test
    public void testUpdateAccount() {
        for (int i = 0; i < 10; i++) {
            presenter.onUpdateAccount();
        }
        Assert.assertEquals(10, view.getManageUpdateAccountClicks());
    }

    @Test
    public void testViewClientHistory() {
        for (int i = 0; i < 10; i++) {
            presenter.onViewClientHistory();
        }
        Assert.assertEquals(10, view.getManageViewClientHistoryClicks());
    }

    @Test
    public void testAppointmentManagement() {
        for (int i = 0; i < 10; i++) {
            presenter.onAppointmentManagement();
        }
        Assert.assertEquals(10, view.getManageAppointmentManagementClicks());
    }

    @Test
    public void testViewStatistics() {
        for (int i = 0; i < 10; i++) {
            presenter.onViewStatistics();
        }
        Assert.assertEquals(10, view.getManageViewStatisticsClicks());
    }

    @Test
    public void testViewAppointmentSchedule() {
        for (int i = 0; i < 10; i++) {
            presenter.onViewAppointmentSchedule();
        }
        Assert.assertEquals(10, view.getManageViewAppointmentScheduleClicks());
    }

    @Test
    public void testRecordProvidedServices() {
        for (int i = 0; i < 10; i++) {
            presenter.onRecordProvidedService();
        }
        Assert.assertEquals(10, view.getManageRecordProvidedServicesClicks());
    }
}
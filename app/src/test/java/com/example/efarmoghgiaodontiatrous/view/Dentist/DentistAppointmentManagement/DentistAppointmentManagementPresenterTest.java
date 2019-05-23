package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DentistAppointmentManagementPresenterTest {
    DentistAppointmentManagementPresenter presenter;
    DentistAppointmentManagementViewStub view;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        view = new DentistAppointmentManagementViewStub();
        presenter = new DentistAppointmentManagementPresenter(view);
    }

    @Test
    public void testGetAppointments() {
        String[] appointmentList = presenter.getAppointments("6", AppointmentState.PENDING);
        Assert.assertNotEquals(0, appointmentList.length);
    }

    @Test
    public void testAcceptAppointments() {
    }

    @Test
    public void testDeclineAppointments() {
    }
}
package com.example.efarmoghgiaodontiatrous.view.Client.RequestAppointment;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RequestAppointmentPresenterTest {
    RequestAppointmentPresenter presenter;
    RequestAppointmentView view;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        view = new RequestAppointmentViewStub();
        presenter = new RequestAppointmentPresenter(view);
    }

    @Test
    public void testRequestAppointment() {
        Dentist d = presenter.updateDentInfoText("1555");
        Assert.assertNull(d);
        /*
        Appointment appointment = new Appointment("", "", "", null, null, 0, 0);
        String time = appointment.getHour() + ":" + appointment.getMinutes();
        presenter.reqAppointment(appointment.getDentist(), appointment.getBookDate(), time, appointment.getTelephoneNo(), appointment.getLastName(), appointment.getFirstName());
       */
    }
}
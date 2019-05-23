package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

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
    public void testMethods(){

    }
}
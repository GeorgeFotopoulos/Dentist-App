package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.SpecializationDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DentistAppointmentManagementPresenterTest {
    DentistAppointmentManagementPresenter presenter;
    DentistAppointmentManagementViewStub view;
    private AppointmentDAO appointmentDao;
    private ClientDAO clientDao;
    private DentistDAO dentistDao;
    private ServiceDAO serviceDao;
    private SpecializationDAO specializationDao;
    private VisitDAO visitDao;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        appointmentDao = new AppointmentDAOMemory();
        clientDao = new ClientDAOMemory();
        dentistDao = new DentistDAOMemory();
        serviceDao = new ServiceDAOMemory();
        specializationDao = new SpecializationDAOMemory();
        visitDao = new VisitDAOMemory();

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
        List<String> selectedAppointments = new ArrayList<>();
        selectedAppointments.add("22/10/2016 16:00\nPatrikis Georgios +30 698 222 2222");
        int size = appointmentDao.find(dentistDao.find("6"), AppointmentState.ACCEPTED).size();
        presenter.AcceptAppointments("6", selectedAppointments);
        int newSize = appointmentDao.find(dentistDao.find("6"), AppointmentState.ACCEPTED).size();
        Assert.assertEquals(size, newSize);
        //Assert.assertEquals(1, newSize);
    }

    @Test
    public void testDeclineAppointments() {
    }
}
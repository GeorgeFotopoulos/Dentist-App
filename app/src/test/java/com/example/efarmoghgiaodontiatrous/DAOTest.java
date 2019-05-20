package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.domain.Visit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DAOTest {
    private AppointmentDAO appointmentDao;
    private ClientDAO clientDao;
    private DentistDAO dentistDao;
    private ServiceDAO serviceDao;
    private SpecializationDAO specializationDao;
    private VisitDAO visitDao;

    private static final int INITIAL_DENTIST_COUNT = 2;
    private static final int INITIAL_CLIENT_COUNT = 2;
    private static final int INITIAL_SERVICE_COUNT = 3;
    private static final int INITIAL_SPECIALIZATION_COUNT = 3;
    private static final int INITIAL_APPOINTMENT_COUNT = 2;
    private static final int INITIAL_VISIT_COUNT = 2;

    @Before
    public void setUp() {
        Initializer dataHelper = new MemoryInitializer();
        dataHelper.prepareData();

        appointmentDao = new AppointmentDAOMemory();
        clientDao = new ClientDAOMemory();
        dentistDao = new DentistDAOMemory();
        serviceDao = new ServiceDAOMemory();
        specializationDao = new SpecializationDAOMemory();
        visitDao = new VisitDAOMemory();
    }

    @Test
    public void findExistingDentist() {
        Assert.assertNotNull(dentistDao.find("1"));
    }

    @Test
    public void findNonExistingDentist() {
        Assert.assertNull(dentistDao.find("2349"));
    }

    @Test
    public void findExistingClient() {
        Assert.assertNotNull(clientDao.find("17099800037"));
    }

    @Test
    public void findNonExistingClient() {
        Assert.assertNull(clientDao.find("18059500037"));
    }

    @Test
    public void findExistingService() {
        Assert.assertNotNull(serviceDao.find("1"));
    }

    @Test
    public void findNonExistingService() {
        Assert.assertNull(serviceDao.find("15000"));
    }

    @Test
    public void findExistingSpecialization() {
        Assert.assertNotNull(specializationDao.find("1"));
    }

    @Test
    public void findNonExistingSpecialization() {
        Assert.assertNull(specializationDao.find("15000"));
    }

    @Test
    public void findExistingAppointment() {
        Assert.assertNotNull(appointmentDao.find(dentistDao.find("1")));
    }

    @Test
    public void findNonExistingAppointment() {
        Assert.assertNull(appointmentDao.find(null));
    }

    @Test
    public void findExistingVisit() {
        Assert.assertNotNull(visitDao.find("17099800037"));
    }

    @Test
    public void findNonExistingVisit() {
        Assert.assertNull(visitDao.find("18059500037"));
    }
}
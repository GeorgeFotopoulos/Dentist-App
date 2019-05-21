package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.SpecializationDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAOTest {
    private AppointmentDAO appointmentDao;
    private ClientDAO clientDao;
    private DentistDAO dentistDao;
    private ServiceDAO serviceDao;
    private SpecializationDAO specializationDao;
    private VisitDAO visitDao;

    private static final int INITIAL_APPOINTMENT_COUNT = 2;
    private static final int INITIAL_CLIENT_COUNT = 2;
    private static final int INITIAL_DENTIST_COUNT = 3;
    private static final int INITIAL_SERVICE_COUNT = 3;
    private static final int INITIAL_SPECIALIZATION_COUNT = 3;
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
    public void testDentists() {
        Dentist dentist = new Dentist("Athanasios", "Fotopoulos", "+30 699 888 7766", "ath.fotopoulos7@gmail.com", "Athens:171223", "None", new Address("Artis", "23", "Athens", "Greece", 17124), 10, "asdfg123");
        dentistDao.save(dentist);
        Assert.assertNotEquals(INITIAL_DENTIST_COUNT, dentistDao.findAll().size());
        Dentist d = dentistDao.findByEmail("ath.fotopoulos7@gmail.com");
        dentistDao.delete(d);
    }

    @Test
    public void testClients() {
        List<Client> allClients = clientDao.findAll();
        Client client = new Client("Gioris", "Ntymenos", "+30 698 468 9046", "geo.nty@gmail.com", "17099600037");
        clientDao.save(client);
        Assert.assertNotEquals(INITIAL_CLIENT_COUNT, allClients.size());
        clientDao.delete(client);
    }

    @Test
    public void testAppointments() {
        List<Appointment> allAppointments = appointmentDao.findAll();
        Appointment appointment = new Appointment("George", "Patrikis", "+30 698 888 7766", dentistDao.find("1"), new SimpleCalendar(2019, 28, 5), 15, 0);
        appointmentDao.save(appointment);
        Assert.assertEquals(INITIAL_APPOINTMENT_COUNT, allAppointments.size());
        appointmentDao.delete(appointment);
    }

    @Test
    public void testServices() {
        List<Service> allServices = serviceDao.findAll();
        Service service = new Service("Root canal", serviceDao.nextId());
        serviceDao.save(service);
        Assert.assertNotEquals(INITIAL_SERVICE_COUNT, allServices.size());
        serviceDao.delete(service);
    }

    @Test
    public void testSpecializations() {
        List<Specialization> allSpecializations = specializationDao.findAll();
        Specialization specialization = new Specialization("Periodontic", specializationDao.nextId());
        specializationDao.save(specialization);
        Assert.assertNotEquals(INITIAL_SPECIALIZATION_COUNT, allSpecializations.size());
        specializationDao.delete(specialization);
    }

    @Test
    public void testVisits() {
        Set<Service> servicesProvided = new HashSet<>();
        servicesProvided.add(serviceDao.find("1"));
        List<Visit> allVisits = visitDao.findAll();
        Visit visit = new Visit(new SimpleCalendar(2018, 5, 18), "Operation unsuccessful!", dentistDao.find("2"), clientDao.find("17090000037"), servicesProvided);
        visitDao.save(visit);
        Assert.assertNotEquals(INITIAL_VISIT_COUNT, allVisits.size());
        visitDao.delete(visit);
    }
}
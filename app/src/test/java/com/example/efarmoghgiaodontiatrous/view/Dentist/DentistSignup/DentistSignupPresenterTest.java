package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.SpecializationDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement.DentistAppointmentManagementPresenter;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistAppointmentManagement.DentistAppointmentManagementViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DentistSignupPresenterTest {
    DentistSignupPresenter presenter;
    DentistSignupView view;
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

        view = new DentistSignupViewStub();
        presenter = new DentistSignupPresenter(view);
    }

    @Test
    public void getSpecializationListTest() {
        Assert.assertTrue(presenter.getSpecializationList().length != 0);
    }

    @Test
    public void getServiceTest() {
        Assert.assertTrue(presenter.getService().length != 0);
    }

    @Test
    public void saveDentistTest() {
        int size = dentistDao.findAll().size();
        Dentist D = new Dentist("George", "Fotopoulos", "+30 698 079 3051", "giorgos.fotopouasdlos7@gmail.com", "171223", "Athens University of Economics and Business", new Address("Artis", "23", "Nea Smyrni", "Greece", 17124), 10, "asdfg12a3");
        presenter.saveDentist(D);
        int newsize = dentistDao.findAll().size();
        Assert.assertNotEquals(size, newsize);
        Dentist existing = dentistDao.find("1");
        presenter.saveDentist(existing);
        int newsize2 = dentistDao.findAll().size();
        Assert.assertEquals(newsize2, newsize);
    }

    @Test
    public void addSpecializationsTest() {
        Dentist existing = dentistDao.find("1");
        List<String> ListToadd=new ArrayList<>();
        ListToadd.add("Pododontic");
        int old=existing.getSpecializations().size();
        presenter.addSpecializations(ListToadd,existing);
        int newL=existing.getSpecializations().size();
        Assert.assertNotEquals(old, newL);
        presenter.addSpecializations(ListToadd,existing);
        old=existing.getSpecializations().size();
        Assert.assertEquals(old, newL);
    }

    @Test
    public void getDentistSizeTest() {
        Assert.assertTrue(presenter.getDentistSize().equals(dentistDao.findAll().size()+""));
    }

    @Test
    public void addServicesTest() {
        Dentist existing = dentistDao.find("6");
        List<String> ListToadd=new ArrayList<>();
        ListToadd.add("Dental cleaning");
        int old=existing.getServices().size();
        presenter.addServices(ListToadd,existing);
        int newL=existing.getServices().size();
        Assert.assertNotEquals(old, newL);
        ListToadd.add("Fake Service that shouldn't be added");
        presenter.addServices(ListToadd,existing);
        old=existing.getServices().size();
        Assert.assertEquals(old, newL);
    }


}
package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistUpdateAccount;

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
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup.DentistSignupPresenter;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup.DentistSignupView;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistSignup.DentistSignupViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DentistUpdateAccountPresenterTest {
    DentistUpdateAccountPresenter presenter;
    DentistUpdateAccountView view;
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

        view = new DentistUpdateAccountViewStub();
        presenter = new DentistUpdateAccountPresenter(view);
    }

    @Test
    public void onDentistMenuTest() {
        presenter.onDentistMenu();
    }

    @Test
    public void onUpdateTest() {
        Dentist d=dentistDao.find("6");
        Assert.assertFalse(dentistDao.find("6").getFirstName().equals("PAOKARAS"));
        String OldName= d.getFirstName();
        d.setFirstName("PAOKARAS");
        presenter.onUpdate(d);
        Assert.assertTrue(dentistDao.find("6").getFirstName().equals("PAOKARAS"));
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
    public void OnLoggedInDentistTest() {
        Assert.assertEquals(presenter.onLoggedInDentist("6").getEmail(), dentistDao.find("6").getEmail());
    }


    @Test
    public void addSpecializationsTest() {
        Dentist existing = dentistDao.find("1");
        List<String> ListToadd = new ArrayList<>();
        ListToadd.add("Pododontic");
        int old = existing.getSpecializations().size();
        presenter.addSpecializations(ListToadd, existing);
        int newL = existing.getSpecializations().size();
        Assert.assertNotEquals(old, newL);
        presenter.addSpecializations(ListToadd, existing);
        old = existing.getSpecializations().size();
        Assert.assertEquals(old, newL);
    }

    @Test
    public void addServicesTest() {
        Dentist existing = dentistDao.find("6");
        List<String> ListToadd = new ArrayList<>();
        ListToadd.add("Dental cleaning");
        int old = existing.getServices().size();
        presenter.addServices(ListToadd, existing);
        int newL = existing.getServices().size();
        Assert.assertNotEquals(old, newL);
        ListToadd.add("Fake Service that shouldn't be added");
        presenter.addServices(ListToadd, existing);
        old = existing.getServices().size();
        Assert.assertEquals(old, newL);
    }

}
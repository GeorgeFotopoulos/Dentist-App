package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile;

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
import com.example.efarmoghgiaodontiatrous.view.Dentist.ViewStatistics.ViewStatisticsPresenter;
import com.example.efarmoghgiaodontiatrous.view.Dentist.ViewStatistics.ViewStatisticsView;
import com.example.efarmoghgiaodontiatrous.view.Dentist.ViewStatistics.ViewStatisticsViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DentistViewProfilePresenterTest {
    DentistViewProfilePresenter presenter;
    DentistViewProfileView view;
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

        view = new DentistViewProfileViewStub();
        presenter = new DentistViewProfilePresenter(view);
    }

    @Test
    public void onShowProfileTest() {
        Dentist d = dentistDao.find("6");
        Assert.assertEquals(presenter.onShowProfile("6"), "ID: " + d.getID() + "\n\nName: " + d.getLastName() + " " + d.getFirstName() + "\n\nE-mail: " + d.getEmail() + "\n\nPhone Number: " +
                d.getTelephoneNo() + "\n\nLicense Number: " + d.getExerciseLicense() + "\n\nUniversity: " + d.getUniversityAttended() +
                "\n\nLocation: " + d.getInfirmaryLocation().print() + "\n\nYears of Experience: " + d.getTimeOfExperience() +
                "\n\nServices: " + d.printServices() + "\n\nSpecializations: " + d.printSpecializations());

    }

    @Test
    public void onUpdateAccountTest() {
        presenter.onUpdateAccount();
    }

}
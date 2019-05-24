package com.example.efarmoghgiaodontiatrous.view.Dentist.ViewSchedule;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.SpecializationDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.memorydao.AppointmentDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile.DentistViewProfilePresenter;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile.DentistViewProfileView;
import com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile.DentistViewProfileViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ViewSchedulePresenterTest {
    ViewSchedulePresenter presenter;
    ViewScheduleView view;
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

        view = new ViewScheduleViewStub();
        presenter = new ViewSchedulePresenter(view);
    }

    @Test
    public void onWelcomeTest(){
        Assert.assertEquals(presenter.onWelcome("6"),"Welcome Dr. " + dentistDao.find("6").getLastName() + "! \n Here you can see the appointments you have:");
    }

    @Test
    public void onScheduleTest(){


        Assert.assertEquals(presenter.onSchedule("6"),"You have no appointments :(");
        Appointment app=new Appointment("Leuterakis", "Patrikis", "+30 698 111 1111", dentistDao.find("6"), new SimpleCalendar(2020, 5, 22), 15, 30);
        appointmentDao.clear();
        app.setState(AppointmentState.ACCEPTED);
        appointmentDao.save(app);
        Assert.assertEquals(presenter.onSchedule("6"),"Date: 22/5/2020 \nTime: 15:30 \nName: Patrikis Leuterakis \nPhone: +30 698 111 1111 \n \n");

    }
}
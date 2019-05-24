package com.example.efarmoghgiaodontiatrous.view.Dentist.RecordService;

import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.memorydao.ClientDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RecordServicePresenterTest {
    RecordServicePresenter presenter;
    RecordServiceViewStub view;
    private ClientDAO clientDao;
    private DentistDAO dentistDao;
    private ServiceDAO serviceDao;
    private VisitDAO visitDao;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        dentistDao = new DentistDAOMemory();
        serviceDao = new ServiceDAOMemory();
        visitDao = new VisitDAOMemory();
        clientDao = new ClientDAOMemory();

        view = new RecordServiceViewStub();
        presenter = new RecordServicePresenter(view);
    }

    @Test
    public void testOnSearchClient() {
        Assert.assertNull(presenter.onSearchClient("17099800036"));
        Assert.assertNotNull(presenter.onSearchClient("17099800037"));
    }

    @Test
    public void testOnCreate() {
        int initialVisitDaoSize, newVisitDaoSize, initialClientDaoSize, newClientDaoSize;
        List<String> services = new ArrayList<>();
        for (Service service : serviceDao.findAll()) {
            services.add(service.getServiceName());
        }
        initialVisitDaoSize = visitDao.findAll().size();
        initialClientDaoSize = clientDao.findAll().size();
        presenter.onCreate(new SimpleCalendar(2019, 5, 25), "George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", "18059500037", services, dentistDao.find("6").getID(), "Test Object");
        newVisitDaoSize = visitDao.findAll().size();
        newClientDaoSize = clientDao.findAll().size();
        Assert.assertNotEquals(initialVisitDaoSize, newVisitDaoSize);
        Assert.assertNotEquals(initialClientDaoSize, newClientDaoSize);
        initialVisitDaoSize = newVisitDaoSize;
        presenter.onCreate(new SimpleCalendar(2019, 5, 26), "Giorgos", "Fwtopoulos", "6980793052", "georgefotopoulos@outlook.com", "17099800037", services, dentistDao.find("6").getID(), "Test Object");
        newVisitDaoSize = visitDao.findAll().size();
        Assert.assertNotEquals(initialVisitDaoSize, newVisitDaoSize);
    }

    @Test
    public void testGetService() {
        String[] service = presenter.getService();
        Assert.assertFalse(service.length == 0);
    }
}
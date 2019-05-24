package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistUpdateAccount;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;
import com.example.efarmoghgiaodontiatrous.util.Address;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DentistUpdateAccountPresenterTest {
    DentistUpdateAccountPresenter presenter;
    DentistUpdateAccountViewStub view;
    Dentist d;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        d = new Dentist("Giorgos", "Fotakis", "+30 698 907 3105", "fotakis@gmail.com", "191223", "Athens University of Economics and Business", new Address("Artis", "22", "Faliro", "Greece", 23124), 9, "asdfg123");

        view = new DentistUpdateAccountViewStub();
        presenter = new DentistUpdateAccountPresenter(view);
    }

    @Test
    public void onDentistMenuTest() {
        presenter.onDentistMenu();
    }

    @Test
    public void onUpdateTest() {
        Assert.assertNotEquals(d.getFirstName(), "PAOKARAS");
        d.setFirstName("PAOKARAS");
        presenter.onUpdate(d);
        Assert.assertEquals(d.getFirstName(), "PAOKARAS");
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
        Assert.assertEquals(presenter.onLoggedInDentist("6").getEmail(), d.getEmail());
    }

    @Test
    public void addSpecializationsTest() {
        int oldSize, newSize;
        List<String> specializationsToBeAdded = new ArrayList<>();
        specializationsToBeAdded.add("Pododontic");
        oldSize = d.getSpecializations().size();
        presenter.addSpecializations(specializationsToBeAdded, d);
        newSize = d.getSpecializations().size();
        Assert.assertNotEquals(oldSize, newSize);
        presenter.addSpecializations(specializationsToBeAdded, d);
        oldSize = d.getSpecializations().size();
        Assert.assertEquals(oldSize, newSize);
    }

    @Test
    public void addServicesTest() {
        int oldSize, newSize;
        List<String> servicesToBeAdded = new ArrayList<>();
        servicesToBeAdded.add("Dental cleaning");
        oldSize = d.getServices().size();
        presenter.addServices(servicesToBeAdded, d);
        newSize = d.getServices().size();
        Assert.assertNotEquals(oldSize, newSize);
        servicesToBeAdded.add("Fake Service that shouldn't be added");
        presenter.addServices(servicesToBeAdded, d);
        oldSize = d.getServices().size();
        Assert.assertEquals(oldSize, newSize);
    }
}
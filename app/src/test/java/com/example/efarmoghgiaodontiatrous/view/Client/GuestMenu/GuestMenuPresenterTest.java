package com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GuestMenuPresenterTest {
    GuestMenuPresenter presenter;
    GuestMenuViewStub view;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        view = new GuestMenuViewStub();
        presenter = new GuestMenuPresenter(view);
    }

    @Test
    public void testMethods() {
        List<Specialization> specializations = presenter.getSpecializations();
        Assert.assertEquals(4, specializations.size());
        List<Service> services = presenter.getServices();
        Assert.assertEquals(3, services.size());
    }

    @Test
    public void testSearchByName() {
        presenter.searchbyname("", "");
        Assert.assertNull(view.getFirstName());
        presenter.searchbyname("Fotopoulos", "George");
        Assert.assertEquals("Fotopoulos", view.getLastName());
    }

    @Test
    public void testSearchByFilters(){
        presenter.searchbyfilters("", "", "");
        Assert.assertNull(view.getRegion());
        presenter.searchbyfilters("Nea Smyrni", "Orthodontic", "Filling");
        Assert.assertEquals("Nea Smyrni", view.getRegion());
    }
}
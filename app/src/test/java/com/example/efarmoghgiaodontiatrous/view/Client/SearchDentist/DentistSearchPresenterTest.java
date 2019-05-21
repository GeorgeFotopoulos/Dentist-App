package com.example.efarmoghgiaodontiatrous.view.Client.SearchDentist;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class DentistSearchPresenterTest {
    DentistSearchPresenter presenter;
    DentistSearchViewStub view;

    @Before
    public void setup() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        view = new DentistSearchViewStub();
        presenter = new DentistSearchPresenter(view);
    }

    @Test
    public void testRequest() {
        Set<Dentist> dentists = presenter.searchDentists("Fotopoulos", "George");
        Assert.assertNotEquals(2, dentists.size());

        Dentist selected = dentists.iterator().next();
        presenter.onDentistSelected(selected);
        Assert.assertNotEquals(selected.getAppointments(), view.getRequestAppointment());

        Set<Dentist> dentistsF = presenter.searchDentistsWithFilters("Athens", "Orthodontic", "Filling");
        Assert.assertNotEquals(2, dentistsF.size());
    }
}
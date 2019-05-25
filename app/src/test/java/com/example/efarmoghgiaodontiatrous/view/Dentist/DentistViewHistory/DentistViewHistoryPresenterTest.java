package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewHistory;

import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DentistViewHistoryPresenterTest {
    DentistViewHistoryPresenter presenter;
    DentistViewHistoryViewStub view;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        view = new DentistViewHistoryViewStub();
        presenter = new DentistViewHistoryPresenter(view);
    }

    /**
     * shows an error message if empty else the provided services
     */
    @Test
    public void testOnHistoryBack() {
        String message;
        message = presenter.onHistoryBack("18059500037");
        Assert.assertEquals("There is no recorded visit history for this client!", message);
        message = presenter.onHistoryBack("17099800037");
        Assert.assertNotEquals("There is no recorded visit history for this client!", message);
    }
}
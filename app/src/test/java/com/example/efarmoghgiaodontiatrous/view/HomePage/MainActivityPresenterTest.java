package com.example.efarmoghgiaodontiatrous.view.HomePage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainActivityPresenterTest {
    private MainActivityPresenter presenter;
    private MainActivityViewStub view;

    @Before
    public void setUp() {
        view = new MainActivityViewStub();
        presenter = new MainActivityPresenter(view);
        view.setPresenter(presenter);
    }

    @Test
    public void testGuestMenu() {
        for(int i=0; i< 10; i++){
            presenter.onGuestMenu();
        }
        Assert.assertEquals(10, view.getGuestMenuClicks());
    }

    @Test
    public void testDentistMenu() {
        for(int i=0; i< 10; i++){
            presenter.onDentistMenu();
        }
        Assert.assertEquals(10, view.getDentistMenuClicks());
    }
}
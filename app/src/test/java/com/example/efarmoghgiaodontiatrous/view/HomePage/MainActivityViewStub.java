package com.example.efarmoghgiaodontiatrous.view.HomePage;

public class MainActivityViewStub implements MainActivityView {
    private int guestMenuClicks, dentistMenuClicks, testMenuClicks;
    private MainActivityPresenter presenter;

    public void setPresenter(MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    public MainActivityPresenter getPresenter() {
        return presenter;
    }

    public MainActivityViewStub() {
    }

    @Override
    public void guestMenu() {
        guestMenuClicks++;
    }

    @Override
    public void dentistMenu() {
        dentistMenuClicks++;
    }

    @Override
    public void testMenu() {
        testMenuClicks++;
    }

    public int getGuestMenuClicks() {
        return guestMenuClicks;
    }

    public int getDentistMenuClicks() {
        return dentistMenuClicks;
    }

    public int getTestMenuClicks() {
        return testMenuClicks;
    }
}
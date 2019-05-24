package com.example.efarmoghgiaodontiatrous.view.HomePage;

public class MainActivityPresenter {
    private MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void onGuestMenu() {
        view.guestMenu();
    }

    public void onDentistMenu() {
        view.dentistMenu();
    }
}
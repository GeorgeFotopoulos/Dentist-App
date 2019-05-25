package com.example.efarmoghgiaodontiatrous.view.HomePage;

public class MainActivityPresenter {
    private MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    /**
     * Sets the view on Guest Menu.
     */
    public void onGuestMenu() {
        view.guestMenu();
    }

    /**
     * Sets the view on Dentist Menu.
     */
    public void onDentistMenu() {
        view.dentistMenu();
    }
}
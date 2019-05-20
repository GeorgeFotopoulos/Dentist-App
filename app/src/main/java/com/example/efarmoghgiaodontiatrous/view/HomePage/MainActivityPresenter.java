package com.example.efarmoghgiaodontiatrous.view.HomePage;

public class MainActivityPresenter {
    private MainActivityView view;

    /**
     * Αρχικοποιεί τον Presenter.
     *
     * @param view Ένα instance του view
     */
    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void onGuestMenu() {
        view.guestMenu();
    }

    public void onDentistMenu() {
        view.dentistMenu();
    }

    public void onTestMenu() {
        view.testMenu();
    }
}

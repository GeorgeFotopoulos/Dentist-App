package com.example.efarmoghgiaodontiatrous;

public class MainActivityPresenter {
    private MainActivityView view;

    /**
     * Αρχικοποιεί τον Presenter.
     * @param view Ένα instance του view
     */
    public MainActivityPresenter(MainActivityView view)
    {
        this.view = view;
    }

    public void onGuestMenu() {
        view.guestMenu();
    }

    public void onDentistMenu() {
        view.dentistMenu();
    }
}

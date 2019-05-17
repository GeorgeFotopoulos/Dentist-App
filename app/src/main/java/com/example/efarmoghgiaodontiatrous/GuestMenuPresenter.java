package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

public class GuestMenuPresenter {
    private GuestMenuView view;

    /**
     * Αρχικοποιεί τον Presenter.
     * @param view Ένα instance του view
     */
    public GuestMenuPresenter(GuestMenuView view) {
        this.view = view;
    }


    public void searchbyname(String title, String author){
        if (title.isEmpty() && author.isEmpty()){
            view.showError("Παρακαλώ συμπληρώστε ένα από τα πεδία");
            return;
        }

        view.showSearchView(title, author);

    }

}

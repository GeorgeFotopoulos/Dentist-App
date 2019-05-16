package com.example.efarmoghgiaodontiatrous;

public class GuestMenuPresenter {
    private GuestMenuView view;

    /**
     * Αρχικοποιεί τον Presenter.
     * @param view Ένα instance του view
     */
    public GuestMenuPresenter(GuestMenuView view)
    {
        this.view = view;
    }

    public void onSearchDentistByName(String surname,String firstname){
        if(surname.equals("kardivoukis"))
            System.out.println("paok");
        view.searchDentistByName(surname,firstname);
    };

}

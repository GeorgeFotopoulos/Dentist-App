package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;

import java.util.List;

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
            view.showError("The field \"Lastname\" is not optional");
            return;
        }

        view.showSearchView(title, author);

    }

    public List<Specialization> getSpecializations() {
        SpecializationDAOMemory dao=new SpecializationDAOMemory();
        dao.save(new Specialization("PAOK","12"));
        dao.save(new Specialization("PadasK","1as2"));
        dao.save(new Specialization("PAasdadadasdadaOK","1asd2"));
        return dao.findAll();
    }
}

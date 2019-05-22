package com.example.efarmoghgiaodontiatrous.view.Client.GuestMenu;

import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.SpecializationDAOMemory;

import java.util.List;

public class GuestMenuPresenter {
    private GuestMenuView view;

    /**
     * Initializes the Presenter.
     *
     * @param view A view instance
     */
    public GuestMenuPresenter(GuestMenuView view) {
        this.view = view;
    }

    public void searchbyname(String lastName, String firstName) {
        if (lastName.isEmpty() && firstName.isEmpty()) {
            view.showError("The field \"Last Name\" is not optional!");
            return;
        }
        view.showSearchView(lastName, firstName);
    }

    public List<Specialization> getSpecializations() {
        SpecializationDAOMemory dao = new SpecializationDAOMemory();
        return dao.findAll();
    }

    public List<Service> getServices() {
        ServiceDAOMemory dao = new ServiceDAOMemory();
        return dao.findAll();
    }

    public void searchbyfilters(String region, String specialization, String service) {
        if (region.equals("") && specialization.equals("") && service.equals("")) {
            view.showError("You have to fill in at least one value!");
            return;
        }
        view.showSearchViewFilters(region, specialization, service);
    }
}
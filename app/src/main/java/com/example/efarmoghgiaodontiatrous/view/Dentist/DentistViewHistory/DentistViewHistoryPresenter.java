package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewHistory;

import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;

import java.util.List;

public class DentistViewHistoryPresenter {

    protected DentistViewHistoryView view;

    public DentistViewHistoryPresenter(DentistViewHistoryView view) {
        this.view = view;
    }

    public String onHistoryBack(String AMKA) {
        VisitDAOMemory v = new VisitDAOMemory();
        List<Visit> listToString;
        listToString = v.find(AMKA);
        String services, history;
        if (listToString.isEmpty()) {
            return "Client has No History!";
        } else {
            history = "Client's Name: " + listToString.get(0).getClient().getFirstName() + " " + listToString.get(0).getClient().getLastName() + "\n ";
            for (Visit key : listToString) {
                services = "";
                for (Service s : key.getServices()) {
                    services = services + s.getServiceName() + " ";
                }
                history = history + " Date: " + key.getDateOfVisit().getDayOfMonth() + "/" + key.getDateOfVisit().getMonth() + "/" + key.getDateOfVisit().getYear() + " \n Dentist: " + key.getDentist().getLastName() + " " + key.getDentist().getFirstName() + " \n Services: " + services + " \n";
                history = history + " \n";
            }
        }
        return history;
    }
}
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
            return "There is no recorded visit history for this client!";
        } else {
            history = "Client's Name: " + listToString.get(0).getClient().getLastName() + " " + listToString.get(0).getClient().getFirstName() + "\n\n";
            for (Visit key : listToString) {
                services = "";
                for (Service s : key.getServices()) {
                    services = services + s.getServiceName() + ", ";
                }
                services = services.substring(0, services.length() - 2);
                history += "Date: " + key.getDateOfVisit().getDayOfMonth() + "/" + key.getDateOfVisit().getMonth() + "/" + key.getDateOfVisit().getYear() +
                        "\nDentist: " + key.getDentist().getLastName() + " " + key.getDentist().getFirstName() +
                        "\nServices: " + services;
                if (!key.getComments().equals("")) {
                    history += "\nComments: " + key.getComments();
                }
                history += "\n\n";
            }
        }
        return history;
    }
}
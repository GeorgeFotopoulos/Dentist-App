package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;

public class DentistViewProfilePresenter {

    private DentistViewProfileView view;

    public DentistViewProfilePresenter(DentistViewProfileView view) {
        this.view = view;
    }

    public void onUpdateAccount() {
        view.updateAccount();
    }

    public String onShowProfile(String ID) {
        DentistDAOMemory dentist = new DentistDAOMemory();
        Dentist d = dentist.find(ID);
        return "ID: " + ID + "\n\nName: " + d.getLastName() + " " + d.getFirstName() + "\n\nE-mail: " + d.getEmail() + "\n\nPhone Number: " +
                d.getTelephoneNo() + "\n\nLicense Number: " + d.getExerciseLicense() + "\n\nUniversity: " + d.getUniversityAttended() +
                "\n\nLocation: " + d.getInfirmaryLocation().print() + "\n\nYears of Experience: " + d.getTimeOfExperience() +
                "\n\nServices: " + d.printServices() + "\n\nSpecializations: " + d.printSpecializations();
    }
}
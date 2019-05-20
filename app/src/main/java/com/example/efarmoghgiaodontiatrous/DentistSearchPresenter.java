package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.Address;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DentistSearchPresenter {
    private DentistSearchView view;

    public DentistSearchPresenter(DentistSearchView view) {
        this.view = view;
    }

    public Set<Dentist> searchDentists(String lastName, String firstName){
        Set<Dentist> result = new HashSet<>();
        List<Dentist> resultA;
        DentistDAOMemory dDAOMemory = new DentistDAOMemory();
        resultA=dDAOMemory.findByName(lastName,firstName);
        result.addAll(resultA);



        return result;

    }

    public void onDentistSelected(Dentist item) {
        view.requestAppointment(item);
    }

    public Set<Dentist> searchDentistsWithFilters(String region, String specialization) {

        Set<Dentist> result = new HashSet<>();
        List<Dentist> resultA;
        DentistDAOMemory dDAOMemory = new DentistDAOMemory();

        resultA=dDAOMemory.findwithFilters(region,specialization);
        result.addAll(resultA);
        return result;
    }
}

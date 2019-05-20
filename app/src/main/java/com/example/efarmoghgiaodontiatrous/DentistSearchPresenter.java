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

        Dentist dentist3 = new Dentist("Giorgos", "Patrikis", "6958687888", "geopatrikis12@gmail.com", "ABC123456", "AUEB", new Address("Lesvou", "8-10", "Athens", "Greece", 15127), 9, "abc123456");
        result.add(dentist3);
        Dentist dentist2 = new Dentist("Dimitris", "Parikis", "6958687888", "geopikis@gmail.com", "ABC1256", "AUEB", new Address("Lesvou", "8-10", "Athens", "Greece", 15127), 9, "abc1456");
        result.add(dentist2);
        Dentist dentist1 = new Dentist("Dimitris", "Parikis", "6958687888", "geopikasdgmail.com", "ABC125asd6", "AUEB", new Address("Lesvou", "8-10", "Athens", "Greece", 15127), 9, "abc1adasda456");
        result.add(dentist1);
        return result;

    }

    public void onDentistSelected(Dentist item) {
    }
}

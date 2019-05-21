package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DentistDAOMemory implements DentistDAO {
    protected static List<Dentist> entities = new ArrayList<>();

    @Override
    public Dentist find(String dentistId) {
        for (Dentist dentist : entities) {
            if (dentist.getID().equals(dentistId)) {
                return dentist;
            }
        }
        return null;
    }

    public Dentist findByEmail(String email) {
        for (Dentist dentist : entities) {
            if (dentist.getEmail().equals(email)) {
                return dentist;
            }
        }
        return null;
    }

    @Override
    public void save(Dentist entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public void delete(Dentist entity) {
        entities.remove(entity);
    }

    @Override
    public List<Dentist> findByName(String lastName, String firstName) {
        List<Dentist> output = new ArrayList<>();
        if (lastName == null && lastName.equals("")) {
            return null;
        } else if (firstName == null || firstName.equals("")) {
            for (Dentist dentist : entities) {
                if (dentist.getLastName().equals(lastName)) {
                    output.add(dentist);
                }
            }
        } else {
            for (Dentist dentist : entities) {
                if (dentist.getLastName().equals(lastName)) {
                    if (dentist.getFirstName().equals(firstName)) {
                        output.add(dentist);
                    }
                }
            }
        }
        return new ArrayList<>(output);
    }

    @Override
    public List<Dentist> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public List<Dentist> findWithFilters(String region, String specialization, String service) {
        List<Dentist> output = new ArrayList<>();
        if ((region == null || region.equals("")) && (specialization == null || specialization.equals("") && (service == null || service.equals("")))) {
            return null;
        }
        List<Dentist> outputA = new ArrayList<>();
        List<Dentist> outputB = new ArrayList<>();
        List<Dentist> outputC = new ArrayList<>();
        List<Dentist> outputD = new ArrayList<>();
        for (Dentist dentist : entities) {
            for (Specialization sp : dentist.getSpecializations()) {
                if (sp.getSpecializationName().equals(specialization)) {
                    outputA.add(dentist);
                }
            }
        }
        for (Dentist dentist : entities) {
            for (Service sp : dentist.getServices()) {
                if (sp.getServiceName().equals(service)) {
                    outputB.add(dentist);
                }
            }
        }
        for (Dentist dentist : entities) {
            if (dentist.getInfirmaryLocation().getCity().equals(region)) {
                outputC.add(dentist);
            }
        }
        if (region.equals("")) {
            if (specialization.equals("")) {
                return new ArrayList<>(outputB);
            } else if (service.equals("")) {
                return new ArrayList<>(outputA);
            } else {
                for (int i = 0; i < outputB.size(); i++) {
                    if (outputA.contains(outputB.get(i))) {
                        output.add(outputB.get(i));
                    }
                }
                return new ArrayList<>(output);
            }
        }
        if (specialization.equals("")) {
            if (region.equals("")) {
                return new ArrayList<>(outputB);
            } else if (service.equals("")) {
                return new ArrayList<>(outputC);
            } else {
                for (int i = 0; i < outputB.size(); i++) {
                    if (outputC.contains(outputB.get(i))) {
                        output.add(outputB.get(i));
                    }
                }
                return new ArrayList<>(output);
            }
        }
        for (int i = 0; i < outputB.size(); i++) {
            if (outputC.contains(outputB.get(i))) {
                outputD.add(outputB.get(i));
            }
        }
        for(int i=0;i<outputA.size();i++){
            if(outputD.contains(outputA.get(i))){
                output.add(outputA.get(i));
            }
        }

        return new ArrayList<>(output);
    }
}
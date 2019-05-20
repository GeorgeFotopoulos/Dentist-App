package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.ArrayList;
import java.util.List;

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
        if (lastName == null || lastName.equals("")) {
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
        return new ArrayList<>(entities);
    }

    @Override
    public List<Dentist> findAll() {
        return new ArrayList<>(entities);
    }
}
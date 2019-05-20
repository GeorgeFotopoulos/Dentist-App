package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
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
    public List<Dentist> findwithFilters(String region, String specialization) {
        List<Dentist> output = new ArrayList<>();
        if ((region == null || region.equals("")) && (specialization == null || specialization.equals(""))) {
            return null;
        } else if (region == null || region.equals("")) {
            for (Dentist dentist : entities) {
                Set<Specialization> temp = dentist.getSpecializations();
                for (Specialization sp : temp) {
                    if (sp.getSpecializationName().equals("specialization")) {
                        output.add(dentist);
                        break;
                    }
                }
            }
        } else if (specialization == null || specialization.equals("")) {
            for (Dentist dentist : entities) {
                if (dentist.getInfirmaryLocation().getCity().equals(region)) {
                    output.add(dentist);
                }
            }
        } else {
            for (Dentist dentist : entities) {
                if (dentist.getInfirmaryLocation().getCity().equals(region)) {
                    Set<Specialization> temp = dentist.getSpecializations();
                    for (Specialization sp : temp) {
                        if (sp.getSpecializationName().equals("specialization")) {
                            output.add(dentist);
                            break;
                        }
                    }
                }
            }
        }

        return new ArrayList<>(output);
    }
}
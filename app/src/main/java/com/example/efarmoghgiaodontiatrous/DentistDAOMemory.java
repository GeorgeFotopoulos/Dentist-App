package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.ArrayList;
import java.util.List;

class DentistDAOMemory implements DentistDAO {
    protected static List<Dentist> entities = new ArrayList<Dentist>();

    @Override
    public Dentist find(String DentistID) {
        for(Dentist dentist : entities) {
            if (dentist.getID() == DentistID ) {
                return dentist;
            }
        }

        return null;
    }

    @Override
    public void save(Dentist entity) {
        if (! entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public void delete(Dentist entity) {
        entities.remove(entity);
    }

    @Override
    public List<Dentist> findByName(String lastName,String firstName) {
        List<Dentist> output= new ArrayList<Dentist>();
        if(lastName==null||lastName.equals("")) {
            return null;
        }
        else if(firstName==null||firstName.equals("")){
            for(Dentist dentist : entities) {
                if (dentist.getLastName().equals(lastName)) {
                    output.add(dentist);
                }
            }
        }
        else{
            for(Dentist dentist : entities) {
                if (dentist.getLastName().equals(lastName)) {
                    if(dentist.getFirstName().equals(firstName))
                      output.add(dentist);
                }
            }
        }
        return new ArrayList<Dentist>(entities);
    }

    @Override
    public List<Dentist> findAll() {
        return new ArrayList<Dentist>(entities);
    }
}

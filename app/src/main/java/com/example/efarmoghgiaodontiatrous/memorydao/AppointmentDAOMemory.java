package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOMemory implements AppointmentDAO {

    protected static List<Appointment> entities = new ArrayList<>();

    @Override
    public void delete(Appointment entity) {
        entities.remove(entity);
    }

    @Override
    public List<Appointment> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void save(Appointment entity) {
        if (!entities.contains(entity)) {
            entities.add(entity);
        }
    }

    @Override
    public List<Appointment> find(Dentist dentist) {
        List<Appointment> Dentistentities = new ArrayList<>();
        for (Appointment appointment : entities) {
            if (appointment.getDentist() == dentist) {
                Dentistentities.add(appointment);
            }
        }
        return new ArrayList<>(Dentistentities);
    }

    public String[] findtoString(Dentist tempDent) {
        List<Appointment> Dentistentities=find(tempDent);
        String out[]=new String[Dentistentities.size()];
        for(int i=0;i<Dentistentities.size();i++)
            out[i]=Dentistentities.get(i).getBookDate().getDayOfMonth()+"/"+Dentistentities.get(i).getBookDate().getMonth()+"/"+Dentistentities.get(i).getBookDate().getYear()+" "+Dentistentities.get(i).getHour()+":"+Dentistentities.get(i).getMinutes()+"\n"+Dentistentities.get(i).getLastName()+" "+Dentistentities.get(i).getFirstName()+ "\n"+Dentistentities.get(i).getTelephoneNo();
        return out;
    }
}
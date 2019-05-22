package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

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
        else {
            entities.remove(entity);
            entity.setState(AppointmentState.ACCEPTED);
            entities.add(entity);
        }
    }

    @Override
    public List<Appointment> find(Dentist dentist,AppointmentState state) {
        List<Long> TimePositions=new ArrayList<>();
        List<Appointment> Dentistentities = new ArrayList<>();
        for (Appointment appointment : entities) {
            if (appointment.getDentist() == dentist&& appointment.getState()==state) {
                TimePositions.add(Long.parseLong(appointment.getBookDate().getYear()+""+appointment.getBookDate().getStringMonth()+""+appointment.getBookDate().getStringDay()+""+appointment.getHour()+appointment.getMinutes()));
                Dentistentities.add(appointment);
            }
        }
        if(TimePositions.size()>0) {
            Long tempInt;
            Appointment temp;
            for (int i = 0; i < TimePositions.size(); i++) {
                for (int j = 1; j < TimePositions.size()-i; j++) {
                    if (TimePositions.get(j-1) >TimePositions.get(j)) {
                        tempInt=TimePositions.get(j);
                        TimePositions.set(j,TimePositions.get(j-1));
                        TimePositions.set(j-1,tempInt);
                        temp=Dentistentities.get(j);
                        Dentistentities.set(j,Dentistentities.get(j-1));
                        Dentistentities.set(j-1,temp);
                    }
                }
            }
        }
        return new ArrayList<>(Dentistentities);
    }

    public String[] findtoString(Dentist tempDent, AppointmentState state) {
        List<Appointment> Dentistentities=find(tempDent,state);
        String out[]=new String[Dentistentities.size()];
        for(int i=0;i<Dentistentities.size();i++)
            out[i]=Dentistentities.get(i).getBookDate().getDayOfMonth()+"/"+Dentistentities.get(i).getBookDate().getMonth()+"/"+Dentistentities.get(i).getBookDate().getYear()+" "+Dentistentities.get(i).getHour()+":"+Dentistentities.get(i).getMinutes()+"\n"+Dentistentities.get(i).getLastName()+" "+Dentistentities.get(i).getFirstName()+ "\n"+Dentistentities.get(i).getTelephoneNo();
        return out;
    }
}
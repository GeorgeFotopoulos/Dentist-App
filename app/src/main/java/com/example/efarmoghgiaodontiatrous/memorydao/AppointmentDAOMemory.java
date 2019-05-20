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
    public Appointment find(Dentist dentist) {
        for (Appointment appointment : entities) {
            if (appointment.getDentist() == dentist) {
                return appointment;
            }
        }
        return null;
    }
}
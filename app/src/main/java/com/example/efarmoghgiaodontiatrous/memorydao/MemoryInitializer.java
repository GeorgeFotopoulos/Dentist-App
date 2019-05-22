package com.example.efarmoghgiaodontiatrous.memorydao;

import com.example.efarmoghgiaodontiatrous.dao.AppointmentDAO;
import com.example.efarmoghgiaodontiatrous.dao.ClientDAO;
import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.ServiceDAO;
import com.example.efarmoghgiaodontiatrous.dao.SpecializationDAO;
import com.example.efarmoghgiaodontiatrous.dao.VisitDAO;
import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;

public class MemoryInitializer extends Initializer {
    /**
     * Deletes all stored data.
     */
    @Override
    protected void eraseData() {
        for (Appointment appointment : getAppointmentDAO().findAll()) {
            getAppointmentDAO().delete(appointment);
        }

        for (Client client : getClientDAO().findAll()) {
            getClientDAO().delete(client);
        }

        for (Dentist dentist : getDentistDAO().findAll()) {
            getDentistDAO().delete(dentist);
        }

        for (Service service : getServiceDAO().findAll()) {
            getServiceDAO().delete(service);
        }

        for (Specialization specialization : getSpecializationDAO().findAll()) {
            getSpecializationDAO().delete(specialization);
        }

        for (Visit visit : getVisitDAO().findAll()) {
            getVisitDAO().delete(visit);
        }
    }

    /**
     * Returns the Appointments' DAO.
     *
     * @return Appointments' DAO.
     */
    @Override
    public AppointmentDAO getAppointmentDAO() {
        return new AppointmentDAOMemory();
    }

    /**
     * Returns the Clients' DAO.
     *
     * @return Clients' DAO.
     */
    @Override
    public ClientDAO getClientDAO() {
        return new ClientDAOMemory();
    }

    /**
     * Returns the Dentists' DAO.
     *
     * @return Dentists' DAO.
     */
    @Override
    public DentistDAO getDentistDAO() {
        return new DentistDAOMemory();
    }

    /**
     * Returns the Services' DAO.
     *
     * @return Services' DAO.
     */
    @Override
    public ServiceDAO getServiceDAO() {
        return new ServiceDAOMemory();
    }

    /**
     * Returns the Specializations' DAO.
     *
     * @return Specializations' DAO.
     */
    @Override
    public SpecializationDAO getSpecializationDAO() {
        return new SpecializationDAOMemory();
    }

    /**
     * Returns the Visits' DAO.
     *
     * @return Visits' DAO.
     */
    @Override
    public VisitDAO getVisitDAO() {
        return new VisitDAOMemory();
    }
}
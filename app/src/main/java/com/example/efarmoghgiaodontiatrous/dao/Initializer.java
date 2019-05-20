package com.example.efarmoghgiaodontiatrous.dao;

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

import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.HashSet;
import java.util.Set;

public abstract class Initializer {
    /**
     * Deletes all stored data.
     */
    protected abstract void eraseData();

    /**
     * Changes the state of the appointment given as a parameter.
     *
     * @param appointment The appointment
     * @return The appointment
     */
    public Appointment makeAvailable(Appointment appointment) {
        if (appointment.getState().equals(AppointmentState.PENDING)) {
            appointment.setState(AppointmentState.ACCEPTED);
        }
        return appointment;
    }

    /**
     * Initializes all test data.
     */
    public void prepareData() {
        eraseData();

        SpecializationDAO specializationDAO = getSpecializationDAO();
        specializationDAO.save(new Specialization("Endodontic", specializationDAO.nextId()));
        specializationDAO.save(new Specialization("Pedodontic", specializationDAO.nextId()));
        specializationDAO.save(new Specialization("Orthodontic", specializationDAO.nextId()));


        DentistDAO dentistDAO = getDentistDAO();
        dentistDAO.save(new Dentist("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", "Athens:171223", "Athens University of Economics and Business", new Address("Artis", "23", "Athens", "Greece", 17124), 10, "asd123"));
        dentistDAO.save(new Dentist("Helias", "Fotopoulos", "6972549705", "ilfwto@gmail.com", "Athens:171224", "National and Kapodistrian University of Athens", new Address("Artis", "24", "Athens", "Greece", 17124), 10, "asd123"));
        dentistDAO.save(new Dentist("Spyros", "Fotopoulos", "6972544705", "spfwto@gmail.com", "Athens:171224", "National and Kapodistrian University of Athens", new Address("Artis", "24", "Athens", "Greece", 17124), 10, "asdfdg123"));
        Dentist d = dentistDAO.find(1 + "");

        d.addSpecialization(specializationDAO.find(1 + ""));
        d.addSpecialization(specializationDAO.find(2 + ""));
        d = dentistDAO.find(2 + "");
        d.addSpecialization(specializationDAO.find(1 + ""));
        d.addSpecialization(specializationDAO.find(3 + ""));

        ClientDAO clientDAO = getClientDAO();
        clientDAO.save(new Client("Panagiotis", "Ntymenos", "+30 698 096 8644", "panagiotis.nty@gmail.com", "17099800037"));
        clientDAO.save(new Client("Liakos", "Ntymenos", "+30 698 864 4096", "liakos.nty@gmail.com", "17090000037"));

        ServiceDAO serviceDAO = getServiceDAO();
        serviceDAO.save(new Service("Filling", serviceDAO.nextId()));
        serviceDAO.save(new Service("Teeth whitening", serviceDAO.nextId()));
        serviceDAO.save(new Service("Dental cleaning", serviceDAO.nextId()));


        AppointmentDAO appointmentDAO = getAppointmentDAO();
        appointmentDAO.save(new Appointment("George", "Patrikis", "+30 698 000 0000", dentistDAO.find("1"), new SimpleCalendar(2019, 28, 5), 15, 0));
        appointmentDAO.save(new Appointment("Leuterakis", "Patrikis", "+30 698 111 1111", dentistDAO.find("2"), new SimpleCalendar(2019, 28, 5), 15, 30));

        VisitDAO visitDAO = getVisitDAO();
        Set<Service> services1 = new HashSet<>();
        services1.add(serviceDAO.find("1"));
        visitDAO.save(new Visit(new SimpleCalendar(2018, 5, 18), "Operation successful!", dentistDAO.find("1"), clientDAO.find("17099800037"), services1));
        Set<Service> services2 = new HashSet<>();
        services1.add(serviceDAO.find("2"));
        visitDAO.save(new Visit(new SimpleCalendar(2018, 5, 18), "Operation unsuccessful!", dentistDAO.find("2"), clientDAO.find("17090000037"), services2));
    }

    /**
     * Returns the Appointments' DAO.
     *
     * @return Appointments' DAO.
     */
    public abstract AppointmentDAO getAppointmentDAO();

    /**
     * Returns the Clients' DAO.
     *
     * @return Clients' DAO.
     */
    public abstract ClientDAO getClientDAO();

    /**
     * Returns the Dentists' DAO.
     *
     * @return Dentists' DAO.
     */
    public abstract DentistDAO getDentistDAO();

    /**
     * Returns the Services' DAO.
     *
     * @return Services' DAO.
     */
    public abstract ServiceDAO getServiceDAO();

    /**
     * Returns the Specializations' DAO.
     *
     * @return Specializations' DAO.
     */
    public abstract SpecializationDAO getSpecializationDAO();

    /**
     * Returns the Visits' DAO.
     *
     * @return Visits' DAO.
     */
    public abstract VisitDAO getVisitDAO();
}
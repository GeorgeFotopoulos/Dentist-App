package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Client;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

import java.util.HashSet;
import java.util.Set;

public abstract class Initializer {
    /**
     * Deletes all stored data.
     */
    protected abstract void eraseData();

    /**
     * Initializes all test data.
     */
    public void prepareData() {
        eraseData();

        SpecializationDAO specializationDAO = getSpecializationDAO();
        specializationDAO.save(new Specialization("Endodontic", specializationDAO.nextId()));
        specializationDAO.save(new Specialization("Pedodontic", specializationDAO.nextId()));
        specializationDAO.save(new Specialization("Orthodontic", specializationDAO.nextId()));
        specializationDAO.save(new Specialization("Pododontic", specializationDAO.nextId()));

        ServiceDAO serviceDAO = getServiceDAO();
        serviceDAO.save(new Service("Filling", serviceDAO.nextId()));
        serviceDAO.save(new Service("Teeth whitening", serviceDAO.nextId()));
        serviceDAO.save(new Service("Dental cleaning", serviceDAO.nextId()));

        DentistDAO dentistDAO = getDentistDAO();
        dentistDAO.save(new Dentist("George", "Fotopoulos", "+30 698 079 3051", "giorgos.fotopoulos7@gmail.com", "171223", "Athens University of Economics and Business", new Address("Artis", "23", "Nea Smyrni", "Greece", 17124), 10, "asdfg123"));
        dentistDAO.save(new Dentist("Helias", "Fotopoulos", "+30 697 254 9705", "ilfwto@gmail.com", "171224", "National and Kapodistrian University of Athens", new Address("Artis", "24", "Peristeri", "Greece", 17124), 10, "asdfg123"));
        dentistDAO.save(new Dentist("Spyros", "Fotopoulos", "+30 697 254 4705", "spirosfot.23@gmail.com", "171225", "University of Piraeus", new Address("Artis", "23", "Aghios Dimitrios", "Greece", 17341), 12, "asdfg123"));
        dentistDAO.save(new Dentist("Georgios", "Fwtopoulos", "+30 698 709 5031", "giorgos.fot@gmail.com", "181223", "Athens University of Economics and Business", new Address("Artis", "22", "Peristeri", "Greece", 23124), 7, "asdfg123"));
        dentistDAO.save(new Dentist("Elias", "Fwtopoulos", "+30 697 224 8866", "il.fotopoulos@gmail.com", "181224", "National and Kapodistrian University of Athens", new Address("Artis", "25", "Chalandri", "Greece", 21124), 5, "asdfg123"));
        dentistDAO.save(new Dentist("Spiros", "Fwtopoulos", "+30 697 524 5074", "sp.23@gmail.com", "171226", "University of Piraeus", new Address("Artis", "23", "Marousi", "Greece", 25341), 13, "asdfg123"));
        dentistDAO.save(new Dentist("Giorgos", "Fotakis", "+30 698 907 3105", "fotakis@gmail.com", "191223", "Athens University of Economics and Business", new Address("Artis", "22", "Faliro", "Greece", 23124), 9, "asdfg123"));
        dentistDAO.save(new Dentist("Ilias", "Fotakis", "+30 697 225 8866", "ilias@gmail.com", "191224", "National and Kapodistrian University of Athens", new Address("Artis", "25", "Faliro", "Greece", 21124), 8, "asdfg123"));
        dentistDAO.save(new Dentist("Spyran", "Fotakis", "+30 697 525 5074", "spiros@gmail.com", "191226", "University of Piraeus", new Address("Artis", "23", "Nea Smyrni", "Greece", 25341), 3, "asdfg123"));

        Dentist d = dentistDAO.find("0");
        d.addSpecialization(specializationDAO.find("2"));
        d.addSpecialization(specializationDAO.find("3"));
        d.addService(serviceDAO.find("1"));
        d.addService(serviceDAO.find("2"));

        d = dentistDAO.find("1");
        d.addSpecialization(specializationDAO.find("1"));
        d.addSpecialization(specializationDAO.find("2"));
        d.addService(serviceDAO.find("2"));
        d.addService(serviceDAO.find("3"));

        d = dentistDAO.find("2");
        d.addSpecialization(specializationDAO.find("1"));
        d.addSpecialization(specializationDAO.find("3"));
        d.addService(serviceDAO.find("1"));
        d.addService(serviceDAO.find("3"));

        d = dentistDAO.find("3");
        d.addSpecialization(specializationDAO.find("2"));
        d.addSpecialization(specializationDAO.find("3"));
        d.addService(serviceDAO.find("1"));
        d.addService(serviceDAO.find("2"));

        d = dentistDAO.find("4");
        d.addSpecialization(specializationDAO.find("1"));
        d.addSpecialization(specializationDAO.find("2"));
        d.addService(serviceDAO.find("2"));
        d.addService(serviceDAO.find("3"));

        d = dentistDAO.find("5");
        d.addSpecialization(specializationDAO.find("1"));
        d.addSpecialization(specializationDAO.find("3"));
        d.addService(serviceDAO.find("1"));
        d.addService(serviceDAO.find("3"));

        d = dentistDAO.find("6");
        d.addSpecialization(specializationDAO.find("2"));
        d.addSpecialization(specializationDAO.find("3"));
        d.addService(serviceDAO.find("1"));
        d.addService(serviceDAO.find("2"));

        d = dentistDAO.find("7");
        d.addSpecialization(specializationDAO.find("1"));
        d.addSpecialization(specializationDAO.find("2"));
        d.addService(serviceDAO.find("2"));
        d.addService(serviceDAO.find("3"));

        d = dentistDAO.find("8");
        d.addSpecialization(specializationDAO.find("1"));
        d.addSpecialization(specializationDAO.find("3"));
        d.addService(serviceDAO.find("1"));
        d.addService(serviceDAO.find("3"));

        ClientDAO clientDAO = getClientDAO();
        clientDAO.save(new Client("Panagiotis", "Ntymenos", "+30 698 096 8644", "panagiotis.nty@gmail.com", "17099800037"));
        clientDAO.save(new Client("Liakos", "Ntymenos", "+30 698 864 4096", "liakos.nty@gmail.com", "17090000037"));
        clientDAO.save(new Client("Giorgos", "Ntymenos", "+30 698 468 9640", "giorgos.nty@gmail.com", "17099600037"));

        AppointmentDAO appointmentDAO = getAppointmentDAO();
        appointmentDAO.save(new Appointment("George", "Patrikis", "+30 698 000 0000", dentistDAO.find("0"), new SimpleCalendar(2019, 28, 5), 15, 0));
        appointmentDAO.save(new Appointment("Leuterakis", "Patrikis", "+30 698 111 1111", dentistDAO.find("1"), new SimpleCalendar(2019, 28, 5), 15, 30));
        appointmentDAO.save(new Appointment("Georgios", "Patrikis", "+30 698 222 2222", dentistDAO.find("2"), new SimpleCalendar(2019, 28, 5), 16, 0));

        VisitDAO visitDAO = getVisitDAO();
        Set<Service> services1 = new HashSet<>();
        services1.add(serviceDAO.find("1"));
        services1.add(serviceDAO.find("2"));
        visitDAO.save(new Visit(new SimpleCalendar(2018, 5, 18), "Operation successful!", dentistDAO.find("1"), clientDAO.find("17099800037"), services1));
        Set<Service> services2 = new HashSet<>();
        services2.add(serviceDAO.find("2"));
        services2.add(serviceDAO.find("3"));
        visitDAO.save(new Visit(new SimpleCalendar(2018, 5, 11), "Operation unsuccessful!", dentistDAO.find("2"), clientDAO.find("17099800037"), services2));
        Set<Service> services3 = new HashSet<>();
        services3.add(serviceDAO.find("1"));
        services3.add(serviceDAO.find("3"));
        visitDAO.save(new Visit(new SimpleCalendar(2018, 5, 4), "Operation successful!", dentistDAO.find("3"), clientDAO.find("17099800037"), services3));
        Set<Service> services4 = new HashSet<>();
        services4.add(serviceDAO.find("1"));
        services4.add(serviceDAO.find("2"));
        visitDAO.save(new Visit(new SimpleCalendar(2018, 6, 18), "Operation successful!", dentistDAO.find("4"), clientDAO.find("17099800037"), services4));
        Set<Service> services5 = new HashSet<>();
        services5.add(serviceDAO.find("2"));
        services5.add(serviceDAO.find("3"));
        visitDAO.save(new Visit(new SimpleCalendar(2018, 6, 11), "Operation unsuccessful!", dentistDAO.find("5"), clientDAO.find("17090000037"), services5));
        Set<Service> services6 = new HashSet<>();
        services6.add(serviceDAO.find("1"));
        services6.add(serviceDAO.find("3"));
        visitDAO.save(new Visit(new SimpleCalendar(2018, 6, 4), "Operation successful!", dentistDAO.find("6"), clientDAO.find("17099600037"), services6));
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
package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Appointment;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.util.AppointmentState;

import java.util.List;

public interface AppointmentDAO {
    /**
     * Διαγράφει ένα ραντεβού.
     *
     * @param entity Το ραντεβού
     */
    void delete(Appointment entity);

    /**
     * Επιστρέφει όλα τα ραντεβού.
     *
     * @return Τα ραντεβού
     */
    List<Appointment> findAll();

    /**
     * Αποθηκεύει ένα ραντεβού.
     *
     * @param entity Το ραντεβού
     */
    void save(Appointment entity);

    /**
     * Βρίσκει τα ραντεβού ενός οδοντιάτρου με βάση τον κωδικό του.
     *
     * @param dentist Ο κωδικός του οδοντιάτρου
     * @return Τα ραντεβού που βρέθηκαν ή null
     */
    List<Appointment> find(Dentist dentist,AppointmentState state);

    public String[] findtoString(Dentist tempDent, AppointmentState state);
}
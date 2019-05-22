package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Specialization;

import java.util.List;

public interface SpecializationDAO {
    /**
     * Διαγράφει μια ειδικότητα.
     *
     * @param entity Η ειδικότητα
     */
    void delete(Specialization entity);

    /**
     * Επιστρέφει όλες τις ειδικότητες.
     *
     * @return Οι ειδικότητες
     */
    List<Specialization> findAll();

    /**
     * Αποθηκεύει μια ειδικότητα.
     *
     * @param entity Η ειδικότητα
     */
    void save(Specialization entity);

    /**
     * Βρίσκει μια ειδικότητα με βάση τον κωδικό της.
     *
     * @param specializationId Ο κωδικός της ειδικότητας
     * @return Η ειδικότητα που βρέθηκε ή null
     */
    Specialization find(String specializationId);
}
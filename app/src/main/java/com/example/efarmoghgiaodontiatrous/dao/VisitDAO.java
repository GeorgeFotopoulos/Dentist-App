package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Visit;

import java.util.List;

public interface VisitDAO {
    /**
     * Διαγράφει μια επίσκεψη.
     *
     * @param entity Η επίσκεψη
     */
    void delete(Visit entity);


    void clear();
    /**
     * Επιστρέφει όλες τις επισκέψεις.
     *
     * @return Οι επισκέψεις
     */
    List<Visit> findAll();

    /**
     * Αποθηκεύει μια επίσκεψη.
     *
     * @param entity Η επίσκεψη
     */
    void save(Visit entity);

    /**
     * Βρίσκει μια επίσκεψη με βάση τον κωδικό ΑΜΚΑ του πελάτη.
     *
     * @param AMKA Ο κωδικός AMKA του πελάτη της επίσκεψης
     * @return Η επίσκεψη που βρέθηκε ή null
     */
    List<Visit> find(String AMKA);
}
package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Client;

import java.util.List;

public interface ClientDAO {
    /**
     * Διαγράφει έναν πελάτη.
     *
     * @param entity Ο πελάτης
     */
    void delete(Client entity);

    /**
     * Επιστρέφει όλους τους πελάτες.
     *
     * @return Οι πελάτες
     */
    List<Client> findAll();

    /**
     * Αποθηκεύει έναν πελάτη.
     *
     * @param entity Ο πελάτης
     */
    void save(Client entity);

    /**
     * Βρίσκει έναν πελάτη με βάση τον κωδικό AMKA του.
     *
     * @param clientAMKA Ο κωδικός AMKA του πελάτη
     * @return Ο πελάτης που βρέθηκε ή null
     */
    Client find(String clientAMKA);
}
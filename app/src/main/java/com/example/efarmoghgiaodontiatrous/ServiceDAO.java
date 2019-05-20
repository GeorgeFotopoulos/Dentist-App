package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Service;

import java.util.List;

public interface ServiceDAO {
    /**
     * Διαγράφει μια υπηρεσία.
     *
     * @param entity Η υπηρεσία
     */
    void delete(Service entity);

    /**
     * Επιστρέφει όλες τις υπηρεσίες.
     *
     * @return Οι υπηρεσίες
     */
    List<Service> findAll();

    /**
     * Αποθηκεύει μια υπηρεσία.
     *
     * @param entity Η υπηρεσία
     */
    void save(Service entity);

    /**
     * Βρίσκει μια υπηρεσία με βάση τον κωδικό της.
     *
     * @param serviceId Ο κωδικός της υπηρεσίας
     * @return Η υπηρεσία που βρέθηκε ή null
     */
    Service find(String serviceId);

    /**
     * Επιστρέφει τον επόμενο κωδικό που μπορεί να αποδοθεί σε μια υπηρεσία.
     * @return Ο κωδικός της υπηρεσίας
     */
    String nextId();
}
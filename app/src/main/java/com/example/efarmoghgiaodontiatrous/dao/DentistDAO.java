package com.example.efarmoghgiaodontiatrous.dao;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.List;

public interface DentistDAO {
    /**
     * @param lastName  Το επίθετο του οδοντιάτρου
     * @param firstName Το όνομα του οδοντιάτρου
     * @return Ο οδοντίατρος που βρέθηκε με βάση την αναζήτηση με όνομα
     */
    List<Dentist> findByName(String lastName, String firstName);


    /**
     * Βρίσκει έναν οδοντίατρο με βάση τον κωδικό του.
     *
     * @param dentistID Ο κωδικός του οδοντιάτρου
     * @return Ο οδοντίατρος που βρέθηκε ή null
     */
    Dentist find(String dentistID);


    Dentist findByEmail(String email);

    /**
     * Αποθηκεύει ένα αντικείμενο στην εξωτερική πηγή δεδομένων.
     * Το αντικείμενο μπορεί να είναι κάποιο νέο αντικείμενο που δεν υπάρχει
     * στην πηγή δεδομένων ή κάποιο το οποίο ήδη υπάρχει και ενημερώνεται η κατάστασή του.
     *
     * @param entity Το αντικείμενο του οποίου η κατάσταση αποθηκεύεται στην εξωτερική πηγή δεδομένων.
     */
    void save(Dentist entity);

    /**
     * Διαγράφει το αντικείμενο από την εξωτερική πηγή δεδομένων.
     *
     * @param entity Το αντικείμενο προς διαγραφή.
     */
    void delete(Dentist entity);

    /**
     * Επιστρέφει όλα τα αντικείμενα  από την εξωτερική πηγή δεδομένων.
     *
     * @return Ο κατάλογος των αντικειμένων
     */
    List<Dentist> findAll();

    List<Dentist> findwithFilters(String region, String specialization);
}
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
     * @param dentistId Ο κωδικός του οδοντιάτρου
     * @return Ο οδοντίατρος που βρέθηκε ή null
     */
    Dentist find(String dentistId);

    void clear();

    /**
     * Returns the dentist that owns the email given as a parameter.
     *
     * @param email The dentist's email.
     * @return The dentist object that owns the email given as a parameter
     */
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

    /**
     * Returns all the dentist objects that meet the criteria below.
     *
     * @param region         The region of the infirmary
     * @param specialization The dentist's specialization(s)
     * @param service        The dentist's provided service(s)
     * @return Returns the dentist(s) who meet the criteria given as parameters
     */
    List<Dentist> findWithFilters(String region, String specialization, String service);
}
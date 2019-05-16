package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;

import java.util.List;

public interface DentistDAO {


    /**
     * Η αναζήτηση ενός δανειζομένου με βάση τον αριθμό δανειζομένου.
     *
     * @param DentistID To id οδοντιάτρου.
     * @return Τον οδοντίατρο ή {@code null} εάν αυτός δεν βρεθεί.
     */

    List<Dentist> findByName(String lastName,String firstName);


    Dentist find(String DentistID);


    /**
     * Αποθηκεύει ένα αντικείμενο στην εξωτερική πηγή
     * δεδομένων. Το αντικείμενο μπορεί να είναι κάποιο
     * νέο αντικείμενο που δεν υπάρχει στην πηγή δεδομένων
     * ή κάποιο το οποίο ήδη υπάρχει και ενημερώνεται η
     * κατάστασή του.
     *
     * @param entity Το αντικείμενο του οποίου η κατάσταση
     *               αποθηκεύεται στην εξωτερική πηγή δεδομένων.
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
}

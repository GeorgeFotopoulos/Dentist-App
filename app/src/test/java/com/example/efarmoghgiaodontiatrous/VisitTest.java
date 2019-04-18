package com.example.efarmoghgiaodontiatrous;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class VisitTest {
    Visit visit;
    SimpleCalendar date;
    Dentist dentist;
    Client client;
    Set<Service> services = new HashSet<>();

    @Before
    public void setUp() {
        date = new SimpleCalendar(10,10,2010);
        visit = new Visit();
        dentist = new Dentist();
        client = new Client();
        services.add(new Service("Filling","1"));
        visit.setDateOfVisit(date);
        visit.setComments("Comments...");
        visit.setDentist(dentist);
        visit.setClient(client);
        visit.setServices(services);
    }

    @Test
    public void testEqualsObject() {

    }

    @Test
    public void testGettersSetters() {
        Dentist otherDentist = new Dentist();
        otherDentist.setEmail("test@gmail.com");
        otherDentist.setPassword("testPassword");
        Client otherClient = new Client();
        otherClient.setAMKA("18059500037");
        Set<Service> otherServices = new HashSet<>();
        otherServices.add(new Service("Dental cleaning", "3"));
        assertNotEquals(new SimpleCalendar(1,1,2001), visit.getDateOfVisit());
        assertNotEquals("Test comments...", visit.getComments());
        assertNotEquals(otherDentist, visit.getDentist());
        assertNotEquals(otherClient, visit.getClient());
        assertNotEquals(otherServices, visit.getServices());
    }
}
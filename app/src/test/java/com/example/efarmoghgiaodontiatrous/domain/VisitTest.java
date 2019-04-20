package com.example.efarmoghgiaodontiatrous.domain;

import com.example.efarmoghgiaodontiatrous.util.Address;
import com.example.efarmoghgiaodontiatrous.util.SimpleCalendar;

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
        date = new SimpleCalendar(10, 10, 2010);
        dentist = new Dentist("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", "ABC123", "Athens University of Economics and Business", new Address("Artis", "23", "Athens", "Greece", 17124), 13, "asd123");
        client = new Client("Panagiotis", "Ntymenos", "6948554284", "panagiwths.nty@gmail.com", "17099800037");
        services.add(new Service("Filling", "1"));
        visit = new Visit();
        visit.setDateOfVisit(date);
        visit.setComments("Comments...");
        visit.setDentist(dentist);
        visit.setClient(client);
        visit.setServices(services);
    }

    @Test
    public void testEqualsObject() {
        SimpleCalendar otherDate = new SimpleCalendar(1, 1, 2001);
        String otherComments = "Other Comments...";
        Dentist otherDentist = new Dentist();
        otherDentist.setEmail("test@gmail.com");
        otherDentist.setPassword("testPassword");
        Client otherClient = new Client();
        otherClient.setAMKA("18059500037");
        Set<Service> otherServices = new HashSet<>();
        otherServices.add(new Service("Dental cleaning", "3"));

        Visit otherVisit = new Visit(otherDate, otherComments, otherDentist, otherClient, otherServices);
        Visit equalVisit = new Visit(visit);
        Visit nullVisit = new Visit(null, null, null, null, null);

        assertFalse(otherVisit.equals(visit));
        assertNotEquals(otherVisit.hashCode(), visit.hashCode());

        assertFalse(nullVisit.equals(null));
        assertEquals(0, nullVisit.hashCode());

        assertTrue(equalVisit.equals(visit));
        assertEquals(equalVisit.hashCode(), visit.hashCode());
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
        assertNotEquals(new SimpleCalendar(1, 1, 2001), visit.getDateOfVisit());
        assertNotEquals("Test comments...", visit.getComments());
        assertNotEquals(otherDentist, visit.getDentist());
        assertNotEquals(otherClient, visit.getClient());
        assertNotEquals(otherServices, visit.getServices());
    }
}
package com.example.efarmoghgiaodontiatrous;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class DentistTest {
    Dentist dentist;

    @Before
    public void setUp() {
        dentist = new Dentist("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", "ABC123", "Athens University of Economics and Business", new Address("Artis", "23", "Athens", "Greece", 17124), 13, "asd123");
        dentist.addService(new Service("Filling", "1"));
    }

    @Test
    public void testEqualsObject() {
        Dentist dentist2 = new Dentist(dentist);
        Dentist dentist3 = new Dentist("Giorgos", "Patrikis", "6958687888", "geopatrikis12@gmail.com", "ABC123456", "AUEB", new Address("Lesvou", "8-10", "Athens", "Greece", 15127), 9, "abc123456");
        Dentist dentist4 = new Dentist(null, null, null, null, null, null, null, 0, null);
        assertFalse(dentist.equals(null));

        assertTrue(dentist2.equals(dentist));
        assertEquals(dentist2.hashCode(), dentist.hashCode());

        assertFalse(dentist3.equals(dentist));
        assertNotEquals(dentist3.hashCode(), dentist.hashCode());

        assertEquals(0, dentist4.hashCode());
    }

    @Test
    public void testSpecializations() {
        Dentist dentist = new Dentist();
        Specialization specialization = new Specialization("Orthodontic", "4");
        dentist.addSpecialization(specialization);
        dentist.getSpecializations();
        dentist.removeSpecialization(specialization);
    }

    @Test
    public void testServices() {
        Dentist dentist = new Dentist();
        Service service = new Service("Filling", "1");
        dentist.addService(service);
        dentist.getServices();
        dentist.removeService(service);
    }

    @Test
    public void testAcceptAppointment() {
        SimpleCalendar calendar = new SimpleCalendar(10, 10, 2010);
        Appointment appointment = new Appointment("George", "Patrikis", "6986888788", "geopatrikis12@gmail.com", dentist, calendar);
        dentist.acceptAppointment(appointment);
        dentist.acceptAppointment(appointment);
    }

    @Test
    public void testDeclineAppointment() {
        SimpleCalendar calendar = new SimpleCalendar(10, 10, 2010);
        Appointment appointment = new Appointment("George", "Patrikis", "6986888788", "geopatrikis12@gmail.com", dentist, calendar);
        dentist.acceptAppointment(appointment);
        dentist.declineAppointment(appointment);
    }

    @Test
    public void testLogin() {
        String email = "giorgos.fotopoulos7@gmail.com";
        String password = "asd123";
        dentist.login(email, password);
    }

    @Test
    public void testGetAppointments() {
        SimpleCalendar calendar = new SimpleCalendar(10, 10, 2010);
        Appointment appointment = new Appointment("George", "Patrikis", "6986888788", "geopatrikis12@gmail.com", dentist, calendar);
        dentist.acceptAppointment(appointment);
        dentist.getAppointments();
    }

    @Test
    public void testRecordVisit() {
        SimpleCalendar dateOfVisit = new SimpleCalendar(10, 10, 2010);
        String comments = "Comments...";
        Client client = new Client("Panagiotis", "Ntymenos", "6948554284", "panagiwths.nty@gmail.com", "17099800037");
        Service service = new Service("Filling", "1");
        dentist.recordVisit(dateOfVisit, comments, dentist, client, service);
    }

    @Test
    public void testCreateClientCard() {
        String AMKA = "18059500037";
        dentist.createClientCard(AMKA);
    }

    @Test
    public void testGettersSetters() {
        Dentist other = new Dentist();
        other.setFirstName("Panagiotis");
        other.setLastName("Ntymenos");
        other.setTelephoneNo("6948554284");
        other.setEmail("panagiwths.nty@gmail.com");
        other.setExerciseLicense("QWERTY");
        other.setUniversityAttended("AUEB");
        other.setInfirmaryLocation(new Address("Lesvou", "8-10", "Athina", "Ellada", 11256));
        other.setTimeOfExperience(8);
        other.setPassword("qwerty123456");
        other.setID("-1");
        assertNotEquals("Giorgos", other.getFirstName());
        assertNotEquals("Patrikis", other.getLastName());
        assertNotEquals("6958687888", other.getTelephoneNo());
        assertNotEquals("geopatrikis12@gmail.com", other.getEmail());
        assertNotEquals("ABC123", other.getExerciseLicense());
        assertNotEquals("Athens University of Economics and Business", other.getUniversityAttended());
        assertNotEquals(new Address("Lesvou", "8-10", "Athens", "Greece", 15127), other.getInfirmaryLocation());
        assertNotEquals(9, other.getTimeOfExperience());
        assertNotEquals("abc123", other.getPassword());
        assertEquals("-1", other.getID());
    }
}
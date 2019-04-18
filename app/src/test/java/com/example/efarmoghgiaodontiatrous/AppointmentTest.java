package com.example.efarmoghgiaodontiatrous;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AppointmentTest {
    Appointment appointment;
    Dentist dentist;
    SimpleCalendar calendar;

    @Before
    public void setUp() {
        calendar = new SimpleCalendar(10, 10, 2010);
        dentist = new Dentist();
        dentist.setEmail("newEmail@gmail.com");
        dentist.setPassword("newPassword");
        appointment = new Appointment("George", "Patrikis", "6986888788", "geopatrikis12@gmail.com", dentist, calendar);
    }

    @Test
    public void equals() {
        Appointment other = new Appointment("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", dentist, calendar);
        assertTrue(other.equals(appointment));
        assertEquals(other.hashCode(), appointment.hashCode());
    }

    @Test
    public void differentAppointments() {
        Dentist dentist2 = new Dentist();
        Appointment other = new Appointment("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", dentist2, new SimpleCalendar(1, 1, 2010));
        dentist2.setEmail("abc123@gmail.com");
        dentist2.setPassword("abc123");
        assertFalse(other.equals(appointment));
        assertNotEquals(other.hashCode(), appointment.hashCode());
    }

    @Test
    public void testGettersSetters() {
        Appointment other = new Appointment();
        Dentist d = new Dentist();
        d.setEmail("test@gmail.com");
        d.setPassword("testpwd");
        SimpleCalendar calendar = new SimpleCalendar(10, 10, 2010);
        other.setFirstName("George");
        other.setLastName("Fotopoulos");
        other.setTelephoneNo("6980793051");
        other.setEmail("giorgos.fotopoulos7@gmail.com");
        other.setState(AppointmentState.PENDING);
        other.setDentist(dentist);
        other.setBookDate(calendar);
        assertNotEquals("Panagiotis", other.getFirstName());
        assertNotEquals("Ntymenos", other.getLastName());
        assertNotEquals("6948554284", other.getTelephoneNo());
        assertNotEquals("panagiwths.nty@gmail.com", other.getEmail());
        assertNotEquals(AppointmentState.ACCEPTED, other.getState());
        assertNotEquals(d, other.getDentist());
        assertNotEquals(new SimpleCalendar(1, 1, 2001), other.getBookDate());
    }
}
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
        appointment = new Appointment("George", "Patrikis", "6986888788", "geopatg4@gmail.com", AppointmentState.DECLINED, dentist, calendar);
    }

    @Test
    public void equals() {
        Appointment other = new Appointment("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", AppointmentState.ACCEPTED, dentist, calendar);
        assertTrue(other.equals(appointment));
        assertEquals(other.hashCode(), appointment.hashCode());
    }

    @Test
    public void differentAppointments() {
        Appointment other = new Appointment("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", AppointmentState.ACCEPTED, new Dentist(), new SimpleCalendar(1, 1, 2010));
        assertFalse(other.equals(appointment));
        assertNotEquals(other.hashCode(), appointment.hashCode());
    }

    @Test
    public void testGettersSetters() {
        Appointment other = new Appointment();
        Dentist dentist = new Dentist();
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
        assertNotEquals(new Dentist(), other.getDentist());
        assertNotEquals(new SimpleCalendar(1, 1, 2001), other.getBookDate());
    }
}
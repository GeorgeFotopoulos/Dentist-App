package com.example.efarmoghgiaodontiatrous;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AppointmentTest {
    Appointment appointment;
    Dentist dentist;
    Calendar calendar;
    SystemDate stub;

    @Before
    public void setUp() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 16);
        stub.setStub(new SimpleCalendar(calendar));
        dentist = new Dentist();
        appointment = new Appointment("George", "Patrikis", "6986888788", "geopatg4@gmail.com", AppointmentState.DECLINED, dentist, stub);
    }

    @Test
    public void equals() {
        Appointment other = new Appointment("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", AppointmentState.ACCEPTED, dentist, stub);
        assertTrue(other.equals(appointment));
        assertEquals(other.hashCode(), appointment.hashCode());
    }

    @Test
    public void differentAppointments() {
        Appointment other = new Appointment("George", "Fotopoulos", "6980793051", "giorgos.fotopoulos7@gmail.com", AppointmentState.ACCEPTED, new Dentist(), new SystemDate());
        assertFalse(other.equals(appointment));
        assertNotEquals(other.hashCode(), appointment.hashCode());
    }

    @Test
    public void testGettersSetters() {
        Appointment other = new Appointment();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 16);
        SystemDate stub2 = new SystemDate();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 16);
        stub2.setStub(new SimpleCalendar(calendar));
        other.setFirstName("George");
        other.setLastName("Fotopoulos");
        other.setTelephoneNo("6980793051");
        other.setEmail("giorgos.fotopoulos7@gmail.com");
        other.setState(AppointmentState.PENDING);
        other.setDentist(new Dentist());
        other.setBookDate(stub);
        assertNotEquals("Panagiotis", other.getFirstName());
        assertNotEquals("Ntymenos", other.getLastName());
        assertNotEquals("6948554284", other.getTelephoneNo());
        assertNotEquals("panagiwths.nty@gmail.com", other.getEmail());
        assertNotEquals(AppointmentState.ACCEPTED, other.getState());
        assertNotEquals(new Dentist(), other.getDentist());
        assertNotEquals(SystemDate.now(), other.getBookDate());
    }
}
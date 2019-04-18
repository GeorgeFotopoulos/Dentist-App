package com.example.efarmoghgiaodontiatrous;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SpecializationTest {
    Specialization specialization;

    @Before
    public void setUp() {
        specialization = new Specialization("Endodontic", "1");
    }

    @Test
    public void testEqualsObject() {
        Specialization specialization2 = new Specialization("Endodontic", "1");
        Specialization specialization3 = new Specialization("Pedodontic", "2");
        Specialization specialization4 = new Specialization(specialization);

        assertFalse(specialization.equals(null));

        assertTrue(specialization2.equals(specialization));
        assertEquals(specialization2.hashCode(), specialization.hashCode());

        assertFalse(specialization3.equals(specialization));
        assertNotEquals(specialization3.hashCode(), specialization.hashCode());

        assertTrue(specialization4.equals(specialization));
        assertEquals(specialization4.hashCode(), specialization.hashCode());
    }

    @Test
    public void testGettersSetters() {
        Specialization other = new Specialization();
        other.setSpecializationName("Orthodontist");
        other.setSpecializationID("3");
        assertNotEquals("Prosthodontist", other.getSpecializationName());
        assertNotEquals("4", other.getSpecializationID());
    }
}
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
    }

    @Test
    public void testEqualsObject() {
        Dentist dentist2 = new Dentist(dentist);
        Dentist dentist3 = new Dentist("Giorgos", "Patrikis", "6958687888", "geopatrikis12@gmail.com", "ABC123456", "AUEB", new Address("Lesvou", "8-10", "Athens", "Greece", 15127), 9, "abc123456");
        Dentist dentist4 = new Dentist(null,null,null,null,null,null,null,0,null);
        assertFalse(dentist.equals(null));

        assertTrue(dentist2.equals(dentist));
        assertEquals(dentist2.hashCode(), dentist.hashCode());

        assertFalse(dentist3.equals(dentist));
        assertNotEquals(dentist3.hashCode(),dentist.hashCode());

        assertEquals(0,dentist4.hashCode());
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
        assertNotEquals("Giorgos", other.getFirstName());
        assertNotEquals("Patrikis", other.getLastName());
        assertNotEquals("6958687888", other.getTelephoneNo());
        assertNotEquals("geopatrikis12@gmail.com", other.getEmail());
        assertNotEquals("ABC123", other.getExerciseLicense());
        assertNotEquals("Athens University of Economics and Business", other.getUniversityAttended());
        assertNotEquals(new Address("Lesvou", "8-10", "Athens", "Greece", 15127), other.getInfirmaryLocation());
        assertNotEquals(9, other.getTimeOfExperience());
        assertNotEquals("abc123", other.getPassword());
    }
}
package com.example.efarmoghgiaodontiatrous;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AddressTest {
    Address address1;

    @Before
    public void setUp() {
        address1 = new Address("Artis", "23", "Athens", "Greece", 17124);
    }

    @Test
    public void testEqualsObject() {
        Address address2 = new Address(address1);
        Address address3 = new Address("Lesvou", "8-10", "Athina", "Ellada", 11256);
        Address address4 = new Address(null, null, null, null, 0);

        assertFalse(address1.equals(null));

        assertTrue(address2.equals(address1));
        assertEquals(address2.hashCode(), address1.hashCode());

        assertFalse(address3.equals(address1));
        assertNotEquals(address3.hashCode(), address1.hashCode());

        assertEquals(0,address4.hashCode());
    }

    @Test
    public void testGettersSetters() {
        Address other = new Address();
        other.setStreet("Folegandrou");
        other.setNumber("10-12");
        other.setCity("Athens");
        other.setCountry("Greece");
        other.setZipCode(15127);
        assertNotEquals("Artis", other.getStreet());
        assertNotEquals("23", other.getNumber());
        assertNotEquals("Athina", other.getCity());
        assertNotEquals("Ellada", other.getCountry());
        assertNotEquals(17124, other.getZipCode());
    }
}
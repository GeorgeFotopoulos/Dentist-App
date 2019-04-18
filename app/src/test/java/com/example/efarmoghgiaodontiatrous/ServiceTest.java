package com.example.efarmoghgiaodontiatrous;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class ServiceTest {
    Service service;

    @Before
    public void setUp() {
        service = new Service("Filling", "1");
    }

    @Test
    public void testEqualsObject() {
        Service service2 = new Service("Filling", "1");
        Service service3 = new Service("Teeth whitening", "2");
        Service service4 = new Service(service);

        assertFalse(service.equals(null));

        assertTrue(service2.equals(service));
        assertEquals(service2.hashCode(), service.hashCode());

        assertFalse(service3.equals(service));
        assertNotEquals(service3.hashCode(), service.hashCode());

        assertTrue(service4.equals(service));
        assertEquals(service4.hashCode(), service.hashCode());
    }

    @Test
    public void testGettersSetters() {
        Service other = new Service();
        other.setServiceName("Dental cleaning");
        other.setServiceID("3");
        assertNotEquals("Filling", other.getServiceName());
        assertNotEquals("1", other.getServiceID());
    }
}
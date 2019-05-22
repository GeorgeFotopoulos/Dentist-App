package com.example.efarmoghgiaodontiatrous.domain;

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
        service = new Service("Filling");
    }

    @Test
    public void testEqualsObject() {
        Service service2 = new Service("Filling");
        Service service3 = new Service("Teeth whitening");
        Service service4 = new Service(service);

        assertFalse(service.equals(null));

        assertNotEquals(service2.hashCode(), service.hashCode());

        assertFalse(service3.equals(service));
        assertNotEquals(service3.hashCode(), service.hashCode());

        assertFalse(service4.equals(service));
        assertNotEquals(service4.hashCode(), service.hashCode());
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
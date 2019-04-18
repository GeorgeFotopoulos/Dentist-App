package com.example.efarmoghgiaodontiatrous;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

public class SimpleCalendarTest {

    @Test
    public void creation() {
        SimpleCalendar march_1_2007 = new SimpleCalendar(2007, 3, 1);
        assert1stMarch2007(march_1_2007);
    }

    @Test
    public void creationFormCalendar() {
        Calendar date = Calendar.getInstance();
        date.set(2007, Calendar.MARCH, 1);
        SimpleCalendar march_1_2007 = new SimpleCalendar(date);
        assert1stMarch2007(march_1_2007);
    }

    @Test
    public void preserveDateInvirant() {
        SimpleCalendar date = new SimpleCalendar(2007, 2, 29);
        assert1stMarch2007(date);
    }

    @Test
    public void addDays() {
        SimpleCalendar date = new SimpleCalendar(2007, 2, 28);
        SimpleCalendar march_1_2007 = date.addDays(1);
        assert1stMarch2007(march_1_2007);
        assertFalse(date.equals(march_1_2007));
    }

    @Test
    public void beforeAndAfter() {
        SimpleCalendar date = new SimpleCalendar(2007, 3, 1);
        SimpleCalendar date2 = new SimpleCalendar(2007, 2, 28);
        SimpleCalendar other = new SimpleCalendar(-1, -1, -1);

        assertTrue(date.before(new SimpleCalendar(2007, 3, 2)));
        assertTrue(date.compareTo(new SimpleCalendar(2007, 3, 2)) < 0);

        assertTrue(date.after(new SimpleCalendar(2007, 2, 28)));
        assertTrue(date.compareTo(new SimpleCalendar(2007, 2, 28)) > 0);

        assertFalse(date.after(new SimpleCalendar(2007, 3, 1)));
        assertFalse(date.before(new SimpleCalendar(2007, 3, 1)));
        assertEquals(0, date.compareTo(new SimpleCalendar(2007, 3, 1)));

        assertEquals(0, other.hashCode());
        assertNotEquals(date2.hashCode(), date.hashCode());
    }

    @Test
    public void getJavaCalendar() {
        SimpleCalendar date = new SimpleCalendar(2007, 3, 1);
        Calendar javaDate = date.getJavaCalendar();

        assertEquals(2007, javaDate.get(Calendar.YEAR));
        assertEquals(Calendar.MARCH, javaDate.get(Calendar.MONTH));
        assertEquals(1, javaDate.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, javaDate.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, javaDate.get(Calendar.MINUTE));
        assertEquals(0, javaDate.get(Calendar.SECOND));
        assertEquals(0, javaDate.get(Calendar.MILLISECOND));
    }

    @Test
    public void duration() {
        SimpleCalendar february_28_2007 = new SimpleCalendar(2007, 2, 28);
        SimpleCalendar march_1_2007 = new SimpleCalendar(2007, 3, 1);

        assertEquals(0, february_28_2007.durationInDays(new SimpleCalendar(2007, 2, 28)));
        assertEquals(1, february_28_2007.durationInDays(march_1_2007));
        assertEquals(-1, march_1_2007.durationInDays(february_28_2007));
    }

    private void assert1stMarch2007(SimpleCalendar date) {
        assertEquals(2007, date.getYear());
        assertEquals(3, date.getMonth());
        assertEquals(1, date.getDayOfMonth());
        assertNotEquals(1, date.getDayOfWeek());
    }
}
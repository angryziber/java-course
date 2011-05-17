package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OneHundredTenHurdleseEventTest {

    OneHundredTenHurdleseEvent oneHundredTenHurdleseEvent = new OneHundredTenHurdleseEvent(19.05);

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(428,oneHundredTenHurdleseEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(19.05, oneHundredTenHurdleseEvent.getPerformance(),0);

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("OneHundredTenHurdlese", oneHundredTenHurdleseEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("sec", oneHundredTenHurdleseEvent.getEventUnits());

    }
}

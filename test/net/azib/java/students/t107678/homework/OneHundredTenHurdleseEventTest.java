package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class OneHundredTenHurdleseEventTest {

    OneHundredTenHurdleseEvent oneHundredTenHurdleseEvent = new OneHundredTenHurdleseEvent(19.05);

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(428,oneHundredTenHurdleseEvent.getPoints());

    }

    @Test
    public void getIncorrectPoints() throws Exception {

        assertNotSame(418, oneHundredTenHurdleseEvent.getPoints());

    }

    @Test
    public void getCorrectPerformance() throws Exception {

        assertEquals(19.05, oneHundredTenHurdleseEvent.getPerformance(),0);

    }

    @Test
    public void getIncorrectPerformance() throws Exception {

        assertNotSame(19.06, oneHundredTenHurdleseEvent.getPerformance());

    }

    @Test
    public void getCorrectEventName() throws Exception {

        assertEquals("OneHundredTenHurdlese", oneHundredTenHurdleseEvent.getEventName());

    }

    @Test
    public void getIncorrectEventName() throws Exception {

        assertNotSame("TwoHundredTenHurdlese", oneHundredTenHurdleseEvent.getEventName());

    }

    @Test
    public void getCorrectEventUnits() throws Exception {

        assertEquals("sec", oneHundredTenHurdleseEvent.getEventUnits());

    }

    @Test
    public void getIncorrectEventUnits() throws Exception {

        assertNotSame("seconds", oneHundredTenHurdleseEvent.getEventUnits());

    }
}

package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class JavelinThrowEventTest {
    JavelinThrowEvent javelinThrowEvent = new JavelinThrowEvent(60.6);

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(747,javelinThrowEvent.getPoints());

    }

    @Test
    public void getIncorrectPoints() throws Exception {

        assertNotSame(737, javelinThrowEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(60.6,javelinThrowEvent.getPerformance(),0);
        assertNotSame(60, javelinThrowEvent.getPerformance());

    }

    @Test
    public void getCorrectEventName() throws Exception {

        assertEquals("JavelinThrow",javelinThrowEvent.getEventName());

    }

    @Test
    public void getIncorrectEventName() throws Exception {

        assertNotSame("JavelinThrowEvent",javelinThrowEvent.getEventName());

    }

    @Test
    public void getCorrectEventUnits() throws Exception {

        assertEquals("m", javelinThrowEvent.getEventUnits());

    }

    @Test
    public void getIncorrectEventUnits() throws Exception {

        assertNotSame("meters", javelinThrowEvent.getEventUnits());

    }
}

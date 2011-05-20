package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class ShotPutEventTest {

    ShotPutEvent shotPutEvent = new ShotPutEvent(9.22);

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(439,shotPutEvent.getPoints());

    }

    @Test
    public void getIncorrectPoints() throws Exception {

        assertNotSame(439.5, shotPutEvent.getPoints());

    }

    @Test
    public void getCorrectPerformance() throws Exception {

        assertEquals(9.22, shotPutEvent.getPerformance(),0);

    }

    @Test
    public void getIncorrectPerformance() throws Exception {

        assertNotSame(9.23, shotPutEvent.getPerformance());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("ShotPut",shotPutEvent.getEventName());
        assertNotSame("ShotPutEvent", shotPutEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("m",shotPutEvent.getEventUnits());
        assertNotSame("sec", shotPutEvent.getEventUnits());

    }
}

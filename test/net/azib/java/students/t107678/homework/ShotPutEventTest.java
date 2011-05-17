package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShotPutEventTest {

    ShotPutEvent shotPutEvent = new ShotPutEvent(9.22);

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(439,shotPutEvent.getPoints());

    }

    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(9.22, shotPutEvent.getPerformance(),0);

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("ShotPut",shotPutEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("m",shotPutEvent.getEventUnits());

    }
}

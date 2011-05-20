package net.azib.java.students.t107678.homework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class DiscusThrowEventTest {


     DiscusThrowEvent discusThrowEvent = new DiscusThrowEvent(12.0);



    @Test
    public void getCorrectPerformance() throws Exception {

        assertEquals(12.0, discusThrowEvent.getPerformance(), 0);

    }

    @Test
    public void getIncorrectPerformance() throws Exception {

        assertNotSame(13.0, discusThrowEvent.getPerformance());

    }

    @Test
    public void getPoints() throws Exception {

        assertEquals(127,discusThrowEvent.getPoints());
        assertNotSame(128,discusThrowEvent.getPoints());

    }

    @Test
    public void getEventName() throws Exception {

        assertEquals("DiscusThrow",discusThrowEvent.getEventName());
        assertNotSame("DiscusThrow1", discusThrowEvent.getEventName());


    }

    @Test
    public void testGetEventUnits() throws Exception {
        assertEquals("m",discusThrowEvent.getEventUnits());
        assertNotSame("meters",discusThrowEvent.getEventUnits());

    }
}

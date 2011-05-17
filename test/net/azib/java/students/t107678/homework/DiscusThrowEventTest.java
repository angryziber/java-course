package net.azib.java.students.t107678.homework;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class DiscusThrowEventTest {


     DiscusThrowEvent discusThrowEvent = new DiscusThrowEvent(12.0);



    @Test
    public void testGetPerformance() throws Exception {

        assertEquals(12.0, discusThrowEvent.getPerformance(), 0);

    }

    @Test
    public void testGetPoints() throws Exception {

        assertEquals(127,discusThrowEvent.getPoints());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals(discusThrowEvent.getEventName(),"DiscusThrow");

    }

    @Test
    public void testGetEventUnits() throws Exception {
        assertEquals(discusThrowEvent.getEventUnits(),"m");

    }
}

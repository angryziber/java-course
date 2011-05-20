package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class LongJumpEventTest {

    LongJumpEvent longJumpEvent = new LongJumpEvent(264.0);

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(28,longJumpEvent.getPoints());
    }

    @Test
    public void getIncorrectPoints() throws Exception {

        assertNotSame(218, longJumpEvent.getPoints());
    }

    @Test
    public void getCorrectPerformance() throws Exception {

        assertEquals(28.0, longJumpEvent.getPoints(),0);

    }

    @Test
    public void getInCorrectPerformance() throws Exception {

        assertNotSame(228.0, longJumpEvent.getPoints());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("LongJump", longJumpEvent.getEventName());
        assertNotSame("LongJumping", longJumpEvent.getEventName());

    }

    @Test
    public void getCorrectEventUnits() throws Exception {

        assertEquals("m",longJumpEvent.getEventUnits());

    }

    @Test
    public void getIncorrectEventUnits() throws Exception {

        assertNotSame("meters",longJumpEvent.getEventUnits());

    }
}

package net.azib.java.students.t107678.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;


public class PoleVaultEventTest {

    PoleVaultEvent poleVaultEvent = new PoleVaultEvent(222.8);

    @Test
    public void getCorrectPoints() throws Exception {

        assertEquals(184,poleVaultEvent.getPoints());

    }

    @Test
    public void getIncorrectPoints() throws Exception {

        assertNotSame(183, poleVaultEvent.getPoints());

    }

    @Test
    public void getCorrectPerformance() throws Exception {

        assertEquals(222.8,poleVaultEvent.getPerformance(),0);

    }

    @Test
    public void getIncorrectPerformance() throws Exception {

        assertNotSame(221.8,poleVaultEvent.getPerformance());

    }

    @Test
    public void testGetEventName() throws Exception {

        assertEquals("PoleVault", poleVaultEvent.getEventName());
        assertNotSame("PoleVaultOne", poleVaultEvent.getEventName());

    }

    @Test
    public void testGetEventUnits() throws Exception {

        assertEquals("m",poleVaultEvent.getEventUnits());
        assertNotSame("meters", poleVaultEvent.getEventUnits());

    }
}

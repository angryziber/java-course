package net.azib.java.students.t030629.homework.base;

import org.junit.Test;
import static junit.framework.Assert.*;

import java.math.BigDecimal;

import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 12.05.2008
 * <br>Time: 20:27:30
 */
public class DecathlonEventTest {

    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void testNext() {
        assertEquals(DecathlonEvent.LONG_JUMP, DecathlonEvent.SPRINT_100M.next());
        assertEquals(DecathlonEvent.JAVELIN_THROW, DecathlonEvent.POLE_VAULT.next());
        assertEquals(DecathlonEvent.SPRINT_100M, DecathlonEvent.RACE_1500M.next());
    }

    @Test
    public void testFirstEvent() {
        assertEquals(DecathlonEvent.SPRINT_100M, DecathlonEvent.getFirstEvent());
    }

    @Test
    public void testCalculateScore() {
        /* Test World Records */
        assertEquals(1154, DecathlonEvent.SPRINT_100M.calculateScore(new BigDecimal("9.77")));
        assertEquals(1312, DecathlonEvent.LONG_JUMP.calculateScore(new BigDecimal("895")));
        assertEquals(1295, DecathlonEvent.SHOT_PUT.calculateScore(new BigDecimal("23.12")));
        assertEquals(1244, DecathlonEvent.HIGH_JUMP.calculateScore(new BigDecimal("245")));
        assertEquals(1156, DecathlonEvent.SPRINT_400M.calculateScore(new BigDecimal("43.18")));
        assertEquals(1120, DecathlonEvent.HURDLES_110M.calculateScore(new BigDecimal("12.91")));
        assertEquals(1383, DecathlonEvent.DISCUS_THROW.calculateScore(new BigDecimal("74.08")));
        assertEquals(1281, DecathlonEvent.POLE_VAULT.calculateScore(new BigDecimal("615")));
        assertEquals(1331, DecathlonEvent.JAVELIN_THROW.calculateScore(new BigDecimal("98.48")));
        assertEquals(1218, DecathlonEvent.RACE_1500M.calculateScore(new BigDecimal("206.00")));

        /* Another Race 1500 m */
        assertEquals(680, DecathlonEvent.RACE_1500M.calculateScore(new BigDecimal("280.01")));
    }
}

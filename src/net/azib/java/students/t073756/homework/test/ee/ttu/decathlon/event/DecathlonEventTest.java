package ee.ttu.decathlon.event;

import org.junit.Test;

import static ee.ttu.decathlon.DecathlonEvent.*;
import static junit.framework.Assert.assertEquals;

/**
 * assert expectations are taken from
 * <a href="www.usatf.org/statistics/calculators/combinedEventsScoring">USA Track and Field web-site</a>
 */
public class DecathlonEventTest {

    @Test
    public void testRunEventPointCalculation() throws Exception {
        assertEquals(649, M_100.calculateScore("12.01"));
        assertEquals(1186, M_1500.calculateScore("3:30.01"));
        assertEquals(267, M_400.calculateScore("1:04.72"));
        assertEquals(417, HURDLES_110.calculateScore("19.18"));
    }

    @Test
    public void testJumpEventPointCalculation() throws Exception {
        assertEquals(382, LONG_JUMP.calculateScore("5"));
        assertEquals(627, HIGH_JUMP.calculateScore("1.8"));
    }

    @Test
    public void testThrowEventPointCalculation() throws Exception {
        assertEquals(486, SHOT_PUT.calculateScore("10"));
        assertEquals(870, DISCUS_THROW.calculateScore("50"));
        assertEquals(910, POLE_VAULT.calculateScore("5"));
        assertEquals(889, JAVELIN_THROW.calculateScore("70"));
    }
}

package net.azib.java.students.t030629.homework.io;

import org.junit.Test;

import java.math.BigDecimal;

import net.azib.java.students.t030629.homework.base.DecathlonEvent;
import net.azib.java.students.t030629.homework.DecathlonCalculator;
import static junit.framework.Assert.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 12:49:23
 */
public class DefaultNormalizerTest {

    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void testNormalize() {
        ResultNormalizer normalizer = new DefaultNormalizer();
        assertEquals(BigDecimal.ONE, normalizer.normalize(DecathlonEvent.SPRINT_100M, BigDecimal.ONE));
        assertEquals(BigDecimal.ONE, normalizer.normalize(DecathlonEvent.JAVELIN_THROW, BigDecimal.ONE));
        assertEquals(new BigDecimal(100), normalizer.normalize(DecathlonEvent.HIGH_JUMP, BigDecimal.ONE));
        assertEquals(new BigDecimal(100), normalizer.normalize(DecathlonEvent.LONG_JUMP, BigDecimal.ONE));
        assertEquals(new BigDecimal(100), normalizer.normalize(DecathlonEvent.POLE_VAULT, BigDecimal.ONE));
    }

    @Test
    public void testUnitNormalization() {
        ResultNormalizer normalizer = new DefaultNormalizer();
        assertEquals("sec", normalizer.getNormalizedUnit(DecathlonEvent.SPRINT_100M));
        assertEquals("m", normalizer.getNormalizedUnit(DecathlonEvent.LONG_JUMP));
        assertEquals("m", normalizer.getNormalizedUnit(DecathlonEvent.SHOT_PUT));
        assertEquals("m", normalizer.getNormalizedUnit(DecathlonEvent.HIGH_JUMP));
        assertEquals("min:sec", normalizer.getNormalizedUnit(DecathlonEvent.SPRINT_400M));
        assertEquals("sec", normalizer.getNormalizedUnit(DecathlonEvent.HURDLES_110M));
        assertEquals("m", normalizer.getNormalizedUnit(DecathlonEvent.DISCUS_THROW));
        assertEquals("m", normalizer.getNormalizedUnit(DecathlonEvent.POLE_VAULT));
        assertEquals("m", normalizer.getNormalizedUnit(DecathlonEvent.JAVELIN_THROW));
        assertEquals("min:sec", normalizer.getNormalizedUnit(DecathlonEvent.RACE_1500M));
    }

}

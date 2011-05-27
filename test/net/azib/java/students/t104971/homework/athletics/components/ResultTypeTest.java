package net.azib.java.students.t104971.homework.athletics.components;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static net.azib.java.students.t104971.homework.athletics.components.ResultType.*;

/**
 * @author Jaroslav Judin
 */
public class ResultTypeTest {

    private int championPoints = 1000;
    private static final String seconds = "seconds";
    private static final String meters = "meters";

    @Test
    public void testCountScoreRace100M() {
        int score = RACE_100_METERS.countScore(10.395);
        assertEquals(championPoints, score);
        assertEquals(seconds, RACE_100_METERS.getUnit());
    }

    @Test
    public void testCountScoreLongJump() {
        int score = LONG_JUMP.countScore(7.76);
        assertEquals(championPoints, score);
        assertEquals(meters, LONG_JUMP.getUnit());
    }

    @Test
    public void testCountScoreShotPut() {
        int score = SHOT_PUT.countScore(18.4);
        assertEquals(championPoints, score);
        assertEquals(meters, SHOT_PUT.getUnit());
    }

    @Test
    public void testCountScoreHighJump() {
        int score = HIGH_JUMP.countScore(2.208);
        assertEquals(championPoints, score);
        assertEquals(meters, HIGH_JUMP.getUnit());
    }

    @Test
    public void testCountScoreRace400M() {
        int score = RACE_400_METERS.countScore(46.17);
        assertEquals(championPoints, score);
        assertEquals(seconds, RACE_400_METERS.getUnit());
    }

    @Test
    public void testCountScoreRace110MHurdles() {
        int score = RACE_110_METERS_HURDLES.countScore(13.8);
        assertEquals(championPoints, score);
        assertEquals(seconds, RACE_110_METERS_HURDLES.getUnit());
    }

    @Test
    public void testCountScoreDiscusThrow() {
        int score = DISCUS_THROW.countScore(56.17);
        assertEquals(championPoints, score);
        assertEquals(meters, DISCUS_THROW.getUnit());
    }

    @Test
    public void testCountScorePoleVault() {
        int score = POLE_VAULT.countScore(5.287);
        assertEquals(championPoints, score);
        assertEquals(meters, POLE_VAULT.getUnit());
    }

    @Test
    public void testCountScoreJavelinThrow() {
        int score = JAVELIN_THROW.countScore(77.19);
        assertEquals(championPoints, score);
        assertEquals(meters, JAVELIN_THROW.getUnit());
    }

    @Test
    public void testCountScoreRace1500M() {
        int score = RACE_1500_METERS.countScore(233.79);
        assertEquals(championPoints, score);
        assertEquals(seconds, RACE_1500_METERS.getUnit());
    }
}

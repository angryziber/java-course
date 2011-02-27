package net.azib.java.students.t104971.homework.athletics.dto;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class ResultTypeTest {

    private int championPoints = 1000;

    @Test
    public void testCountScoreRace100M() {
        int score = ResultType.RACE_100_METERS.countScore(10.395);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScoreLongJump() {
        int score = ResultType.LONG_JUMP.countScore(7.76);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScoreShotPut() {
        int score = ResultType.SHOT_PUT.countScore(18.4);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScoreHighJump() {
        int score = ResultType.HIGH_JUMP.countScore(2.208);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScoreRace400M() {
        int score = ResultType.RACE_400_METERS.countScore(46.17);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScoreRace110MHurdles() {
        int score = ResultType.RACE_110_METERS_HURDLES.countScore(13.8);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScoreDiscusThrow() {
        int score = ResultType.DISCUS_THROW.countScore(56.17);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScorePoleVault() {
        int score = ResultType.POLE_VAULT.countScore(5.287);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScoreJavelinThrow() {
        int score = ResultType.JAVELIN_THROW.countScore(77.19);
        assertEquals(championPoints, score);
    }

    @Test
    public void testCountScoreRace1500M() {
        int score = ResultType.RACE_1500_METERS.countScore(233.79);
        assertEquals(championPoints, score);
    }



}

package net.azib.java.students.t100224.homework.calculator;

public class DecathlonCalculator {
	/**
	 * Calculates scores for 100 m Sprint discipline
	 *
	 * @param seconds - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateSprint100Score(float seconds) {
		return (int) (25.4347 * Math.pow(18 - seconds, 1.81));
	}

	/**
	 * Calculates scores for Long jump discipline
	 *
	 * @param metres - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateLongJumpScore(float metres) {
		return (int) (0.14354 * Math.pow((metres / 100) - 220, 1.4));
	}

	/**
	 * Calculates scores for Shot put discipline
	 *
	 * @param metres - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateShotPutScore(float metres) {
		return (int) (51.39 * Math.pow(metres - 1.5, 1.05));
	}

	/**
	 * Calculates scores for High jump discipline
	 *
	 * @param metres - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateHighJumpScore(float metres) {
		return (int) (0.8465 * Math.pow((metres / 100) - 75, 1.42));
	}

	/**
	 * Calculates scores for 400 m Sprint discipline
	 *
	 * @param seconds - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateSprint400Score(float seconds) {
		return (int) (1.53775 * Math.pow(82 - seconds, 1.81));
	}

	/**
	 * Calculates scores for Hurdles 110 m discipline
	 *
	 * @param seconds - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateHurdles110Score(float seconds) {
		return (int) (5.74352 * Math.pow(28.5 - seconds, 1.92));
	}

	/**
	 * Calculates scores for Discus throw discipline
	 *
	 * @param metres - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateDiscusThrowScore(float metres) {
		return (int) (12.91 * Math.pow(metres - 4, 1.1));
	}

	/**
	 * Calculates scores for Pole vault discipline
	 *
	 * @param metres - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculatePoleVaultScore(float metres) {
		return (int) (0.2797 * Math.pow((metres / 100) - 100, 1.35));
	}

	/**
	 * Calculates scores for Javelin throw discipline
	 *
	 * @param metres - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateJavelinThrowScore(float metres) {
		return (int) (10.14 * Math.pow(metres - 7, 1.08));
	}

	/**
	 * Calculates scores for 1500 m Race discipline
	 *
	 * @param seconds - performance by the athlete
	 * @return scores for current discipline
	 */
	public int calculateRace1500Score(float seconds) {
		return (int) (0.03768 * Math.pow(480 - seconds, 1.85));
	}
}

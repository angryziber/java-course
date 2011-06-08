package net.azib.java.students.t100224.homework.calculator;

public class DecathlonCalculator {

	public int calculateSprint100Score(float seconds) {
		return (int) (25.4347 * Math.pow(18 - seconds, 1.81));
	}

	public int calculateLongJumpScore(float metres) {
		return (int) (0.14354 * Math.pow((metres / 100) - 220, 1.4));
	}

	public int calculateShotPutScore(float metres) {
		return (int) (51.39 * Math.pow(metres - 1.5, 1.05));
	}

	public int calculateHighJumpScore(float metres) {
		return (int) (0.8465 * Math.pow((metres / 100) - 75, 1.42));
	}

	public int calculateSprint400Score(float seconds) {
		return (int) (1.53775 * Math.pow(82 - seconds, 1.81));
	}

	public int calculateHurdles110Score(float seconds) {
		return (int) (5.74352 * Math.pow(28.5 - seconds, 1.92));
	}

	public int calculateDiscusThrowScore(float metres) {
		return (int) (12.91 * Math.pow(metres - 4, 1.1));
	}

	public int calculatePoleVaultScore(float metres) {
		return (int) (0.2797 * Math.pow((metres / 100) - 100, 1.35));
	}

	public int calculateJavelinThrowScore(float metres) {
		return (int) (10.14 * Math.pow(metres - 7, 1.08));
	}

	public int calculateRace1500Score(float seconds) {
		return (int) (0.03768 * Math.pow(480 - seconds, 1.85));
	}
}

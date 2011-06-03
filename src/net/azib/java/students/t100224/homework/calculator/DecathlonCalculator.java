package net.azib.java.students.t100224.homework.calculator;

public class DecathlonCalculator {

	public int calculateSprint100Score(double seconds) {
		return (int) (25.4347 * Math.pow(18 - seconds, 1.81));
	}

	public int calculateLongJumpScore(double centimetres) {
		return (int) (0.14354 * Math.pow(centimetres - 220, 1.4));
	}

	public int calculateShotPutScore(double metres) {
		return (int) (51.39 * Math.pow(metres - 1.5, 1.05));
	}

	public int calculateHighJumpScore(double centimetres) {
		return (int) (0.8465 * Math.pow(centimetres - 75, 1.42));
	}

	public int calculateSprint400Score(double seconds) {
		return (int) (1.53775 * Math.pow(82 - seconds, 1.81));
	}

	public int calculateHurdles110Score(double seconds) {
		return (int) (5.74352 * Math.pow(28.5 - seconds, 1.92));
	}

	public int calculateDiscusThrowScore(double metres) {
		return (int) (12.91 * Math.pow(metres - 4, 1.1));
	}

	public int calculatePoleVaultScore(double centimetres) {
		return (int) (0.2797 * Math.pow(centimetres - 100, 1.35));
	}

	public int calculateJavelinThrowScore(double metres) {
		return (int) (10.14 * Math.pow(metres - 7, 1.08));
	}

	public int calculateRace1500Score(double seconds) {
		return (int) (0.03768 * Math.pow(480 - seconds, 1.85));
	}
}

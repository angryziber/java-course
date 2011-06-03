package net.azib.java.students.t100224.homework.model;


import net.azib.java.students.t100224.homework.calculator.DecathlonCalculator;

public class Result implements Comparable<Result> {

	private float sprint100;

	private float longJump;

	private float shotPut;

	private float highJump;

	private float sprint400;

	private float hurdles110;

	private float discusThrow;

	private float poleVault;

	private float javelinThrow;

	private float race1500;

	private int totalScore;

	private Athlete athlete;

	DecathlonCalculator calculator = new DecathlonCalculator();

	public void countTotalScore(){
		totalScore = 0;
		totalScore = calculator.calculateSprint100Score(sprint100);
		totalScore = + calculator.calculateLongJumpScore(longJump);
		totalScore = + calculator.calculateShotPutScore(shotPut);
		totalScore = + calculator.calculateHighJumpScore(highJump);
		totalScore = + calculator.calculateSprint400Score(sprint400);
		totalScore = + calculator.calculateHurdles110Score(hurdles110);
		totalScore = + calculator.calculateDiscusThrowScore(discusThrow);
		totalScore = + calculator.calculatePoleVaultScore(poleVault);
		totalScore = + calculator.calculateJavelinThrowScore(javelinThrow);
		totalScore = + calculator.calculateRace1500Score(race1500);
	}

	public void setSprint100(float sprint100) {
		this.sprint100 = sprint100;
	}

	public float getSprint100() {
		return sprint100;
	}

	public void setLongJump(float longJump) {
		this.longJump = longJump;
	}

	public float getLongJump() {
		return longJump;
	}

	public void setShotPut(float shotPut) {
		this.shotPut = shotPut;
	}

	public float getShotPut() {
		return shotPut;
	}

	public void setHighJump(float highJump) {
		this.highJump = highJump;
	}

	public float getHighJump() {
		return highJump;
	}

	public void setSprint400(float sprint400) {
		this.sprint400 = sprint400;
	}

	public float getSprint400() {
		return sprint400;
	}

	public void setHurdles110(float hurdles110) {
		this.hurdles110 = hurdles110;
	}

	public float getHurdles110() {
		return hurdles110;
	}

	public void setDiscusThrow(float discusThrow) {
		this.discusThrow = discusThrow;
	}

	public float getDiscusThrow() {
		return discusThrow;
	}

	public void setPoleVault(float poleVault) {
		this.poleVault = poleVault;
	}

	public float getPoleVault() {
		return poleVault;
	}

	public void setJavelinThrow(float javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	public float getJavelinThrow() {
		return javelinThrow;
	}

	public void setRace1500(float race1500) {
		this.race1500 = race1500;
	}

	public float getRace1500() {
		return race1500;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	@Override
	public int compareTo(Result result) {
		return new Integer(getTotalScore()).compareTo(result.getTotalScore());
	}

}

package net.azib.java.students.t100224.homework.model;


import java.util.Map;

public class Result implements Comparable<Result> {

	private Athlete athlete;

	private Map<String, Float> performances;

	private int totalScore;

	public Map<String, Float> getPerformances() {
		return performances;
	}

	public void setPerformances(Map<String, Float> performances) {
		this.performances = performances;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	@Override
	public int compareTo(Result result) {
		return -new Integer(getTotalScore()).compareTo(result.getTotalScore());
	}


}

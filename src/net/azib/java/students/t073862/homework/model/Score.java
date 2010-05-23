package net.azib.java.students.t073862.homework.model;

import java.util.Arrays;


/**
 * Scores model, used for serializing to XML / CSV
 *
 * @author Pets
 */
public class Score implements Comparable<Score> {
	/**
	 * Constructor for Scores 
	 * @param name
	 * @param dob
	 * @param iso
	 * @param scores
	 */
	public Score(String name, String dob, String iso, int scores, Float[] scoreData) {
		this.name = name;
		this.dob = dob;
		this.iso = iso;
		this.scores = scores;
		this.scoreData = scoreData;
	}
	
	String name;
	String dob;
	String iso;
	int scores;
		
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @return the iso
	 */
	public String getIso() {
		return iso;
	}
	/**
	 * @return the scores
	 */
	public int getScores() {
		return scores;
	}
	/**
	 * Stores player scores for events
	 */
	private Float[] scoreData = null;
	
	
	public String toString() {
		return this.name + "("+this.dob.toString()+") from " + this.iso + " scored: " + this.getScores() + " " + this.getScoreData();
	}
	@Override
	public int compareTo(Score s1) {
		if(s1.getScores() > this.getScores())
			return 1;
		if(s1.getScores() < this.getScores())
			return -1;
		return 0;
		}
	/**
	 * @return the scoreData
	 */
	public String getScoreData() {
		return Arrays.toString(this.scoreData);
	}
}

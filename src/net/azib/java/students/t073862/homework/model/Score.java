package net.azib.java.students.t073862.homework.model;

/**
 * Scores
 *
 * @author Pets
 */
public class Score {
	/**
	 * Constructor for Scores 
	 * @param name
	 * @param dob
	 * @param iso
	 * @param scores
	 */
	public Score(String name, String dob, String iso, int scores) {
		this.name = name;
		this.dob = dob;
		this.iso = iso;
		this.scores = scores;
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
	
	public String toString() {
		return this.name + "("+this.dob.toString()+") from " + this.iso + " scored: " + this.getScores();
	}
}

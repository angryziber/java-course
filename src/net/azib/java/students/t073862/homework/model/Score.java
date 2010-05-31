package net.azib.java.students.t073862.homework.model;

import java.math.BigDecimal;
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
	public Score(String name, String dob, String iso, Double[] scoreData) {
		this.name = name;
		this.dob = dob;
		this.iso = iso;
		this.scores = this.calculateScores(scoreData);
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
	private Double[] scoreData = null;
	
	
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
	/**
	 * Points = INT(A*(B-P)^C) for track events
	 * @return
	 */
	private int calcTrack(Double A, Double B, Double C, Double P) {
		BigDecimal a = new BigDecimal(A); 
		BigDecimal b = new BigDecimal(B); 
		BigDecimal p = new BigDecimal(P); 
		BigDecimal substraction = b.subtract(p);
		BigDecimal power = new BigDecimal(Math.pow(substraction.doubleValue(),C));
		return a.multiply(power).intValue();
	}
	/**
	 * @return  INT(A*(P-B)^C) for field events
	 */
	private int calcField(Double A, Double B, Double C, Double P) {
		BigDecimal a = new BigDecimal(A); 
		BigDecimal b = new BigDecimal(B); 
		BigDecimal p = new BigDecimal(P); 
		BigDecimal substraction = p.subtract(b);
		BigDecimal power = new BigDecimal(Math.pow(substraction.doubleValue(),C));
		return a.multiply(power).intValue();
	}	
	private Double[] A = { 25.4347D, 0.14354D, 51.39D, 0.8465D, 1.53775D, 5.74352D, 12.91D, 0.2797D, 10.14D, 0.03768D };
	private Double[] B = { 18D, 220D, 1.5D, 75D, 82D, 28.5D, 4D, 100D, 7D, 480D  };
	private Double[] C = { 1.81D, 1.4D, 1.05D, 1.42D, 1.81D, 1.92D, 1.1D, 1.35D, 1.08D, 1.85D };
	private boolean[] trackEvent = { 
		true, //race_100m
		false, //long_jump
		false, //shot_put
		false, //high_jump 
		true, //race_400m
		true, //hurdles_110m
		false, //discus_throw
		false, //pole_vault
		false, //javelin_throw
		true //race_1500m
	};
	/**
	 * Calculates the score for the given athlete
	 * @return
	 */
	public int calculateScores(Double[] scores) {
		int points = 0;
		
		for(int i = 0; i < trackEvent.length; i++) {
			if(trackEvent[i]) {
				
				int newPoints = calcTrack(A[i], B[i], C[i], scores[i]);
				//System.out.println("TrackEvent: " + races[i] + " scored: "+ newPoints + " ("+A[i] +"|"+B[i]+"|"+C[i] +")");
				points += newPoints;
			}
			else {
				int newPoints = -1;
				
				if(i == 1 || i == 3 || i == 7) {
					newPoints = calcField(A[i], B[i], C[i], (scores[i]*100));
				}
				else {
					newPoints = calcField(A[i], B[i], C[i], scores[i]);
				}
				//System.out.println("FieldEvent: " + races[i] + " scored: "+ newPoints + " ("+A[i] +"|"+B[i]+"|"+C[i]+"|"+scores[i] +")");
				points += newPoints;
			}
		}
		return points;
	}
}

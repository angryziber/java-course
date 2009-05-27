package net.azib.java.students.t030620.homework.beans;

import net.azib.java.students.t030620.homework.enums.Competition;

import java.sql.Timestamp;
import java.util.Map;

/**
 * DecathleteScoreWrapper
 *
 * @author Lord HellBunny
 */
public class DecathleteScoreKeeper implements Comparable<DecathleteScoreKeeper> {
	private int score = 0;
	private String place;
	private DecathleteScore decatheleteScore;
	
	
	
	
	public DecathleteScoreKeeper(DecathleteScore decatheleteScore) {
		super();
		this.decatheleteScore = decatheleteScore;
	}


	@Override
	public int compareTo(DecathleteScoreKeeper athleteScore) {		
		if(athleteScore.getScore() < this.score) return -1;
		return 1;
	}
	
	
	public void calclulateScore() {
		score = 0;
		for(Competition value : Competition.values()) {
			Double p = decatheleteScore.getScores().get(value);
			switch (value.getType())  {
				case FIELD: score += (int)(value.getA() * Math.pow((p - value.getB()), value.getC())); break;
				case TRACK: score += (int)(value.getA() * Math.pow((value.getB() - p), value.getC())); break;
			}

		}
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}

	
	
	public String getName() {
		return this.decatheleteScore.getName();
	}


	public void setName(String name) {
		this.decatheleteScore.setName(name);
	}


	public Timestamp getDate() {
		return this.decatheleteScore.getDate();
	}


	public void setDate(Timestamp date) {
		this.decatheleteScore.setDate(date);
	}


	public String getCountryCode() {
		return this.decatheleteScore.getCountryCode();
	}


	public void setCountryCode(String countryCode) {
		this.decatheleteScore.setCountryCode(countryCode);
	}


	public Map<Competition, Double> getScores() {
		return this.decatheleteScore.getScores();
	}


	public void setScores(Map<Competition, Double> scores) {
		this.decatheleteScore.setScores(scores);
	}
}

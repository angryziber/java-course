package net.azib.java.students.t010691.homework;

import java.util.Date;
import java.util.Map;

/**
 * Competitor
 *
 * Contains information about a single athlete:
 * - personal data
 * - competition results
 *
 * @author Ilja Lutov
 */
class Competitor implements Comparable<Competitor>{
	
	/**
	 * Constructor
	 * 
	 * Loads athlete data
	 * 
	 * @param data string array containig athlete's personal info and results
	 */
	public Competitor(String name, Date birthDate, CountryCode countryCode, Map<CompetitionEvent, Float> runningResults, Map<CompetitionEvent, Float> fieldResults) {
		this.name = name;
		this.birthDate = birthDate;
		this.countryCode = countryCode;
		this.runningResults = runningResults;
		this.fieldResults = fieldResults;
		this.score = calculateScore();
	}

	/**
	 * Calculates total score for a given athlete
	 * 
	 * @return total score
	 */
	public Float calculateScore() {
		Float score = new Float(0);

		// Calculate points for running events
		for (Map.Entry<CompetitionEvent, Float> result : runningResults.entrySet()) {
			score += result.getKey().A() * Math.pow(result.getKey().B() - result.getValue(), result.getKey().C()) + result.getKey().handTime();
		}

		// Calculate points for field events
		for (Map.Entry<CompetitionEvent, Float> result : fieldResults.entrySet()) {
			score += result.getKey().A() * Math.pow(result.getValue() - result.getKey().B(), result.getKey().C()) + result.getKey().handTime();
		}
		
		return score;
	}
	
	/**
	 * Transforms competitor data to an array of strings
	 * 
	 * @return string array representing a given athlete
	 */
	public String[] toStringArray() {
		String[] data = new String[14];
		
		data[0] = score.toString();
		data[1] = name;
		data[2] = birthDate.toString();
		data[3] = countryCode.toString();
		data[4] = runningResults.get(CompetitionEvent.ONE_HUNDRED_METERS_SPRINT).toString();
		data[5] = fieldResults.get(CompetitionEvent.LONG_JUMP).toString();
		data[6] = fieldResults.get(CompetitionEvent.SHOT_PUT).toString();
		data[7] = fieldResults.get(CompetitionEvent.HIGH_JUMP).toString();
		data[8] = runningResults.get(CompetitionEvent.FOUR_HUNDRED_METERS_SPRINT).toString();
		data[9] = runningResults.get(CompetitionEvent.ONE_HUNDRED_AND_TEN_METERS_HURDLES).toString();
		data[10] = fieldResults.get(CompetitionEvent.DISCUS_THROW).toString();
		data[11] = fieldResults.get(CompetitionEvent.POLE_VAULT).toString();
		data[12] = fieldResults.get(CompetitionEvent.JAVELIN_THROW).toString();
		data[13] = runningResults.get(CompetitionEvent.ONE_THOUSAND_AND_FIVE_HUNDRED_METERS_RACE).toString();

		return data;
	}
	
	/**
	 * Get competitor's final score based on achieved results
	 * 
	 * @return total score for a given athlete
	 */
	public Float getScore() {
		return score;
	}

	/**
	 * Overridden method that compares competitor objects
	 * according to their total score.
	 * Is used for collections sort algorithm.
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Competitor competitor) {
		return competitor.getScore().compareTo(score);
	}
	
	/**
	 * Overridden method that tests if two competitors are equal or not.
	 * Is used for competitor frequency calculation in a list.
	 * Two competitors are considered equal if they have the same score.
	 * Equal competitors have the same index in a list.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object competitor) {
		return score.equals(((Competitor) competitor).getScore());
	}
	
	// Personal information
	private String name;
	private Date birthDate;
	private CountryCode countryCode;
	
	// Competition results
	private Map<CompetitionEvent, Float> runningResults;
	private Map<CompetitionEvent, Float> fieldResults;
	
	// Total score
	private Float score;
}

package net.azib.java.students.t072073.homework;

import java.lang.reflect.Field;

import org.jdom.Attribute;
import org.jdom.Element;


/**
 * Athlete
 *
 * @author janika
 */
public class Athlete implements Comparable<Athlete> {
	public static final double SHORT_SPRINT_A = 25.4347;
	public static final double SHORT_SPRINT_B = 18;
	public static final double SHORT_SPRINT_C = 1.81;
	
	public static final double LONG_JUMP_A = 0.14354;
	public static final double LONG_JUMP_B = 220;
	public static final double LONG_JUMP_C = 1.4;
	
	public static final double SHOT_PUT_A = 51.39;
	public static final double SHOT_PUT_B = 1.5;
	public static final double SHOT_PUT_C = 1.05;
	
	public static final double HIGH_JUMP_A = 0.8465;
	public static final double HIGH_JUMP_B = 75;
	public static final double HIGH_JUMP_C = 1.42;
	
	public static final double LONG_SPRINT_A = 1.53775;
	public static final double LONG_SPRINT_B = 82;
	public static final double LONG_SPRINT_C = 1.81;
	
	public static final double HURDLES_A = 5.74352;
	public static final double HURDLES_B = 28.5;
	public static final double HURDLES_C = 1.92;
	
	public static final double DISCUS_THROW_A = 12.91;
	public static final double DISCUS_THROW_B = 4;
	public static final double DISCUS_THROW_C = 1.1;
	
	public static final double POLE_VAULT_A = 0.2797;
	public static final double POLE_VAULT_B = 100;
	public static final double POLE_VAULT_C = 1.35;
	
	public static final double JAVELIN_THROW_A = 10.14;
	public static final double JAVELIN_THROW_B = 7;
	public static final double JAVELIN_THROW_C = 1.08;
	
	public static final double RACE_A = 0.03768;
	public static final double RACE_B = 480;
	public static final double RACE_C = 1.85;
	
	private String name;
	private String dateOfBirth;
	private String countryISOCode;
	private double shortSprint;
	private double longJump;
	private double shotPut;
	private double highJump;
	private double longSprint;
	private double hurdles; 
	private double discusThrow; 
	private double poleVault;
	private double javelinThrow;
	private double race;
	private String place;
	
	
	
	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the shortSprint
	 */
	public double getShortSprint() {
		return shortSprint;
	}
	
	/**
	 * @return the shortSprintScore as integer
	 */
	public int shortSprintScore(){
		return calculateTrackScore(SHORT_SPRINT_A, 
				SHORT_SPRINT_B, 
				SHORT_SPRINT_C,
				getShortSprint());
	}
	
	/**
	 * @return the longJump
	 */
	public double getLongJump() {
		return longJump;
	}
	
	/**
	 * @return the longJumpScore
	 */
	public int longJumpScore(){
		return calculateFieldScore(LONG_JUMP_A, 
				LONG_JUMP_B, 
				LONG_JUMP_C,
				getLongJump());
	}

	/**
	 * @return the shotPut
	 */
	public double getShotPut() {
		return shotPut;
	}
	
	/**
	 * @return the shotPutScore
	 */
	public int shotPutScore(){
		return calculateFieldScore(SHOT_PUT_A, 
				SHOT_PUT_B, 
				SHOT_PUT_C,
				getShotPut());
	}

	/**
	 * @return the highJump
	 */
	public double getHighJump() {
		return highJump;
	}
	
	/**
	 * @return the highJumpScore
	 */
	public int highJumpScore(){
		return calculateFieldScore(HIGH_JUMP_A, 
				HIGH_JUMP_B, 
				HIGH_JUMP_C,
				getHighJump());
	}

	/**
	 * @return the longSprint
	 */
	public double getLongSprint() {
		return longSprint;
	}
	
	/**
	 * @return the longSprintScore
	 */
	public int longSprintScore(){
		return calculateTrackScore(LONG_SPRINT_A, 
				LONG_SPRINT_B, 
				LONG_SPRINT_C,
				getLongSprint());
	}

	/**
	 * @return the hurdles
	 */
	public double getHurdles() {
		return hurdles;
	}
	
	/**
	 * @return the hurdlesScore
	 */
	public int hurdlesScore(){
		return calculateTrackScore(HURDLES_A, 
				HURDLES_B, 
				HURDLES_C,
				getHurdles());
	}

	/**
	 * @return the discusThrow
	 */
	public double getDiscusThrow() {
		return discusThrow;
	}
	
	/**
	 * @return the discusThrowScore
	 */
	public int discusThrowScore(){
		return calculateFieldScore(DISCUS_THROW_A, 
				DISCUS_THROW_B, 
				DISCUS_THROW_C,
				getDiscusThrow());
	}

	/**
	 * @return the poleVault
	 */
	public double getPoleVault() {
		return poleVault;
	}

	/**
	 * @return the poleVaultScore
	 */
	public int poleVaultScore(){
		return calculateFieldScore(POLE_VAULT_A, 
				POLE_VAULT_B, 
				POLE_VAULT_C,
				getPoleVault());
	}
	
	/**
	 * @return the javelinThrow
	 */
	public double getJavelinThrow() {
		return javelinThrow;
	}
	
	/**
	 * @return the javelinThrowScore
	 */
	public int javelinThrowScore(){
		return calculateFieldScore(JAVELIN_THROW_A, 
				JAVELIN_THROW_B, 
				JAVELIN_THROW_C,
				getJavelinThrow());
	}

	/**
	 * @return the race
	 */
	public double getRace() {
		return race;
	}
	
	/**
	 * @return the raceScore
	 */
	public int raceScore(){
		return calculateTrackScore(RACE_A, 
				RACE_B, 
				RACE_C,
				getRace());
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the countryISOCode
	 */
	public String getCountryISOCode() {
		return countryISOCode;
	}
	
	/**
	 * @param parsedAthlete
	 * @description Athlete constructor for parsedAthlete (validated user input data)
	 */
	public Athlete(AthleteParser parsedAthlete) {
		this.name = parsedAthlete.getName();
		this.dateOfBirth = parsedAthlete.getDateOfBirth();
		this.countryISOCode = parsedAthlete.getCountryISOCode();
		this.shortSprint = parsedAthlete.getShortSprint();
		this.longJump = parsedAthlete.getLongJump();
		this.shotPut = parsedAthlete.getShotPut();
		this.highJump = parsedAthlete.getHighJump();
		this.longSprint = parsedAthlete.getLongSprint();
		this.hurdles = parsedAthlete.getHurdles();
		this.discusThrow = parsedAthlete.getDiscusThrow();
		this.poleVault = parsedAthlete.getPoleVault();
		this.javelinThrow = parsedAthlete.getJavelinThrow();
		this.race = parsedAthlete.getRace();	
	}
	

	/**
	 * 
	 * @param constantA of the track event
	 * @param constantB of the track event
	 * @param constantC of the track event
	 * @param performance of the track event
	 * @return score of the track event measured in seconds.
	 */
	public int calculateTrackScore(double constantA, double constantB, double constantC, double performance){
		return Double.valueOf(constantA*Math.pow((constantB - performance), constantC)).intValue();
	}
	
	/**
	 * 
	 * @param constantA of the field event
	 * @param constantB of the field event
	 * @param constantC of the field event
	 * @param performance of the field event
	 * @return score of the field event measured in meters/centimeters.
	 */
	public int calculateFieldScore(double constantA, double constantB, double constantC, double performance){
		return Double.valueOf(constantA*Math.pow((performance - constantB), constantC)).intValue();
	}
	
	/**
	 * 
	 * @return total score of the decathlon for the athlete
	 */
	public int totalScore(){
		return (shortSprintScore() + longJumpScore() + shotPutScore() + highJumpScore() + longSprintScore() +
		hurdlesScore()  + discusThrowScore() + poleVaultScore() + javelinThrowScore() + raceScore());
	}
	
	@Override
	public boolean equals(Object athlete) {
		if (athlete instanceof Athlete){
			Athlete otherAthlete = (Athlete)athlete;
			int name_equal = this.name.compareTo(otherAthlete.name);
			int birthday_equal = this.dateOfBirth.compareTo(otherAthlete.dateOfBirth);
			int country_equal = this.countryISOCode.compareTo(otherAthlete.countryISOCode);
			return (name_equal == 0 && country_equal == 0 && birthday_equal == 0);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new Double(name + dateOfBirth + countryISOCode).intValue() ;
	}

	@Override
	/**
	 *  @return -1, 0, or 1 showing whether the current is smaller, equal, or greater than another
	 */
	public int compareTo(Athlete other) {
		int result = -1;
		if(this.totalScore() < other.totalScore()){
			result = 1;
		}
		else if (this.totalScore() > other.totalScore()){
			result = -1;
		}
		else if (this.equals(other)){
			result = 0;
		}
		return result;
	}
	
	/**
	 * @description creates a string of the athlete
	 */
	public String toString(){
		return (place + ';' + totalScore() + ";" + name + ";" + dateOfBirth +";" + countryISOCode + ';'+ shortSprint + 
				';' + longJump + ';' + shotPut + ';' + highJump + ';' + longSprint + 
				';' + hurdles + ';' + discusThrow + ';' + poleVault + 
				';' + javelinThrow + ';' + race);
	}
	
	/**
	 * 
	 * @return xml Element of the athlete
	 */
	public Element toXml(){

		Element athlete = new Element("athlete");
		athlete.addContent(new Element("place").addContent(place));
		athlete.addContent(new Element("score").addContent(Integer.toString(totalScore())));
		athlete.addContent(new Element("name").addContent(name));
		athlete.addContent(new Element("date_of_birth").addContent(dateOfBirth));
		athlete.addContent(new Element("country").addContent(countryISOCode));
		athlete.addContent(new Element("sprint_100m").addContent(Double.toString(shortSprint)));
		athlete.addContent(new Element("long_jump").addContent(Double.toString(longJump)));
		athlete.addContent(new Element("shot_put").addContent(Double.toString(shotPut)));
		athlete.addContent(new Element("high_jump").addContent(Double.toString(highJump)));
		athlete.addContent(new Element("sprint_400m").addContent(Double.toString(longSprint)));
		athlete.addContent(new Element("hurdles_110m").addContent(Double.toString(hurdles)));
		athlete.addContent(new Element("discus_throw").addContent(Double.toString(discusThrow)));
		athlete.addContent(new Element("pole_vault").addContent(Double.toString(poleVault)));
		athlete.addContent(new Element("javelin_throw").addContent(Double.toString(javelinThrow)));
		athlete.addContent(new Element("race_1500m").addContent(Double.toString(race)));

		return athlete;
	}
}

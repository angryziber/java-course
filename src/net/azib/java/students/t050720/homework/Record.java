package net.azib.java.students.t050720.homework;

/**
 * <b>Record</b>
 * 
 * Contains a record of the results of an athlete's decathlon competition.
 * All numeric data is stored as floating-point numbers, either in meters or in seconds, depending on the event.
 * 
 * The total score is calculated on the first query. If the data is changed, the next query necessitates a recalculation of the score.
 * @author Marek
 */
public class Record implements Comparable<Record>{
	private int score=0;
	private String athlete;
	private String birthDate;
	private String country;
	private float race_100m;
	private float long_jump;
	private float shot_put;
	private float high_jump;
	private float race_400m;
	private float hurdles_110m;
	private float discus_throw;
	private float pole_vault;
	private float javelin_throw;
	private float race_1500m;
	private boolean scoreCalculated=false;
	/**
	 * Returns the total decathlon score.
	 * Calculation is done on the first-time-query. Afterwards, the score is recalculated if this method is requested after an event data change. 
	 * @return The total score for the decathlon competition.
	 */
	public int getScore() {
		if(!scoreCalculated) calculateScore();
		return score;
	}
	/**
	 * @return Athlete name
	 */
	public String getAthlete() {
		return athlete;
	}
	/**
	 * Sets athlete name.
	 * @param athlete is the new name
	 */
	public void setAthlete(String athlete) {
		this.athlete = athlete;
	}
	/**
	 * @return birth date of athlete
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * Sets athlete birth date.
	 * @param birthDate is the new birthDate
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return Country that the athlete represents
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * Sets athlete country.
	 * @param country is the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return 100m race result, in seconds
	 */
	public float getRace_100m() {
		return race_100m;
	}
	/**
	 * Sets the 100m race result, in seconds
	 * @param race_100m - new result
	 */
	public void setRace_100m(float race_100m) {
		scoreCalculated=false;
		if(race_100m<0) this.race_100m=0;
		else this.race_100m = race_100m;
	}
	/**
	 * @return long jump result, in meters
	 */
	public float getLong_jump() {
		return long_jump;
	}
	/**
	 * Sets new long jump result, in meters
	 * @param longJump - new result
	 */
	public void setLong_jump(float longJump) {
		scoreCalculated=false;
		if(longJump<0) long_jump=0;
		else long_jump = longJump;
	}
	/**
	 * @return shot put result, in meters
	 */
	public float getShot_put() {
		return shot_put;
	}
	/**
	 * Sets new shot put result, in meters
	 * @param shotPut - new result
	 */
	public void setShot_put(float shotPut) {
		scoreCalculated=false;
		if(shotPut<0) shot_put=0;
		else shot_put = shotPut;
	}
	/**
	 * @return high jump result, in meters
	 */
	public float getHigh_jump() {
		return high_jump;
	}
	/**
	 * Sets new high jump result, in meters
	 * @param highJump - new result
	 */
	public void setHigh_jump(float highJump) {
		scoreCalculated=false;
		if(highJump<0) high_jump=0;
		else high_jump = highJump;
	}
	/**
	 * @return the 400m race result, in seconds
	 */
	public float getRace_400m() {
		return race_400m;
	}
	/**
	 * Set new result for the 400m race, in seconds
	 * @param race_400m - new result
	 */
	public void setRace_400m(float race_400m) {
		scoreCalculated=false;
		if(race_400m<0) this.race_400m=0;
		else this.race_400m = race_400m;
	}
	/**
	 * @return the 110m hurdles race result, in seconds
	 */
	public float getHurdles_110m() {
		return hurdles_110m;
	}
	/**
	 * Sets new result for the 110m hurdles race, in seconds
	 * @param hurdles_110m - new result
	 */
	public void setHurdles_110m(float hurdles_110m) {
		scoreCalculated=false;
		if (hurdles_110m<0) this.hurdles_110m=0;
		else this.hurdles_110m = hurdles_110m;
	}
	/**
	 * @return discus throw result, in meters
	 */
	public float getDiscus_throw() {
		return discus_throw;
	}
	/**
	 * Set new discus throw result, meters
	 * @param discusThrow - new result
	 */
	public void setDiscus_throw(float discusThrow) {
		scoreCalculated=false;
		if(discusThrow<0) discus_throw=0;
		else discus_throw = discusThrow;
	}
	/**
	 * @return pole vault result, meters
	 */
	public float getPole_vault() {
		return pole_vault;
	}
	/**
	 * Set new pole vault result, meters
	 * @param poleVault - new result
	 */
	public void setPole_vault(float poleVault) {
		scoreCalculated=false;
		if(poleVault<0) pole_vault=0;
		else pole_vault = poleVault;
	}
	/**
	 * @return javelin throw result, meters
	 */
	public float getJavelin_throw() {
		return javelin_throw;
	}
	/**
	 * Set new javelin throw result, meters
	 * @param javelinThrow - new result
	 */
	public void setJavelin_throw(float javelinThrow) {
		scoreCalculated=false;
		if (javelinThrow<0) javelin_throw=0;
		else javelin_throw = javelinThrow;
	}
	/**
	 * @return The 1500m race result, in seconds.
	 */
	public float getRace_1500m() {
		return race_1500m;
	}
	/**
	 * Set new 1500m race result, in seconds.
	 * @param race_1500m - new result
	 */
	public void setRace_1500m(float race_1500m) {
		scoreCalculated=false;
		if(race_1500m<0) this.race_1500m=0;
		else this.race_1500m = race_1500m;
	}
//Event	A	B	C
//100 m			25.4347		18		1.81
//Long Jump		0.14354		220		1.4
//Shot Put		51.39		1.5		1.05
//High Jump		0.8465		75		1.42
//400 m			1.53775		82		1.81
//110 m Hurdles	5.74352		28.5	1.92
//Discus Throw	12.91		4		1.1
//Pole Vault	0.2797		100		1.35
//Javelin Throw	10.14		7		1.08
//1500 m		0.03768		480		1.85
	
//track events Points=INT(A*(B-P)^C)
//field events Points = INT(A*(P-B)^C)

private	void calculateScore()
	{  
	scoreCalculated=true;
	int tmpScore=0;
	tmpScore+= getRace_100m() >0 ? (int) (25.4347 * Math.pow(18 - getRace_100m(), 		1.81)) : 0;
	tmpScore+= getLong_jump() >0 ? (int) (0.14354 * Math.pow(100*getLong_jump() - 220, 		1.4)) : 0;
	tmpScore+= getShot_put() >0 ? (int) (51.39   * Math.pow(getShot_put() - 1.5, 		1.05)) : 0;
	tmpScore+= getHigh_jump() >0 ? (int) (0.8465  * Math.pow(100*getHigh_jump() - 75, 		1.42)) : 0;
	tmpScore+= getRace_400m() >0 ? (int) (1.53775 * Math.pow(82 - getRace_400m(), 		1.81)) : 0;
	tmpScore+= getHurdles_110m() >0 ? (int) (5.74352 * Math.pow(28.5 - getHurdles_110m(), 	1.92)) : 0;
	tmpScore+= getDiscus_throw() >0 ? (int) (12.91   * Math.pow(getDiscus_throw() - 4, 	1.1)) : 0;
	tmpScore+= getPole_vault() >0 ? (int) (0.2797  * Math.pow(100*getPole_vault() - 100, 	1.35)) : 0;
	tmpScore+= getJavelin_throw() >0 ? (int) (10.14   * Math.pow(getJavelin_throw() - 7,	 1.08)) : 0;
	tmpScore+= getRace_1500m() >0 ? (int) (0.03768 * Math.pow(480 - getRace_1500m(), 	1.85)) : 0;
	score=tmpScore;
	}

/**
 * This implements the compareTo interface, but backwards!
 * This way we can sort an ArrayList of Records and have the sort method
 * return the competition results, in descending score, and ascending position order.
 * 
 * @return -1, if the total score of o is bigger than the total score of the current Record,
 * 0 if they are equal and +1, if the total score of o is smaller.
 */
@Override
public int compareTo(Record o) {
	int myScore=this.getScore();
	int otherScore=o.getScore();
	if(myScore < otherScore) return 1;
	else if(myScore > otherScore) return -1; //inverted comparator, because we want descending scores, not ascending
	else if(myScore == otherScore) return 0;
	else return 0;
}
}

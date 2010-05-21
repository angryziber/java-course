package net.azib.java.students.t050720.homework;

/**
 * ResultRecord
 *
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
	 * @return the score
	 */
	public int getScore() {
		if(!scoreCalculated) calculateScore();
		return score;
	}
	/**
	 * @return the athlete
	 */
	public String getAthlete() {
		return athlete;
	}
	/**
	 * @param athlete the athlete to set
	 */
	public void setAthlete(String athlete) {
		this.athlete = athlete;
	}
	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}
	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the race_100m
	 */
	public float getRace_100m() {
		return race_100m;
	}
	/**
	 * @param race_100m the race_100m to set
	 */
	public void setRace_100m(float race_100m) {
		scoreCalculated=false;
		if(race_100m<0) this.race_100m=0;
		else this.race_100m = race_100m;
	}
	/**
	 * @return the long_jump
	 */
	public float getLong_jump() {
		return long_jump;
	}
	/**
	 * @param longJump the long_jump to set
	 */
	public void setLong_jump(float longJump) {
		scoreCalculated=false;
		if(longJump<0) long_jump=0;
		else long_jump = longJump;
	}
	/**
	 * @return the shot_put
	 */
	public float getShot_put() {
		return shot_put;
	}
	/**
	 * @param shotPut the shot_put to set
	 */
	public void setShot_put(float shotPut) {
		scoreCalculated=false;
		if(shotPut<0) shot_put=0;
		else shot_put = shotPut;
	}
	/**
	 * @return the high_jump
	 */
	public float getHigh_jump() {
		return high_jump;
	}
	/**
	 * @param highJump the high_jump to set
	 */
	public void setHigh_jump(float highJump) {
		scoreCalculated=false;
		if(highJump<0) high_jump=0;
		else high_jump = highJump;
	}
	/**
	 * @return the race_400m
	 */
	public float getRace_400m() {
		return race_400m;
	}
	/**
	 * @param race_400m the race_400m to set
	 */
	public void setRace_400m(float race_400m) {
		scoreCalculated=false;
		if(race_400m<0) this.race_400m=0;
		else this.race_400m = race_400m;
	}
	/**
	 * @return the hurdles_110m
	 */
	public float getHurdles_110m() {
		return hurdles_110m;
	}
	/**
	 * @param hurdles_110m the hurdles_110m to set
	 */
	public void setHurdles_110m(float hurdles_110m) {
		scoreCalculated=false;
		if (hurdles_110m<0) this.hurdles_110m=0;
		else this.hurdles_110m = hurdles_110m;
	}
	/**
	 * @return the discus_throw
	 */
	public float getDiscus_throw() {
		return discus_throw;
	}
	/**
	 * @param discusThrow the discus_throw to set
	 */
	public void setDiscus_throw(float discusThrow) {
		scoreCalculated=false;
		if(discusThrow<0) discus_throw=0;
		else discus_throw = discusThrow;
	}
	/**
	 * @return the pole_vault
	 */
	public float getPole_vault() {
		return pole_vault;
	}
	/**
	 * @param poleVault the pole_vault to set
	 */
	public void setPole_vault(float poleVault) {
		scoreCalculated=false;
		if(poleVault<0) pole_vault=0;
		else pole_vault = poleVault;
	}
	/**
	 * @return the javelin_throw
	 */
	public float getJavelin_throw() {
		return javelin_throw;
	}
	/**
	 * @param javelinThrow the javelin_throw to set
	 */
	public void setJavelin_throw(float javelinThrow) {
		scoreCalculated=false;
		if (javelinThrow<0) javelin_throw=0;
		else javelin_throw = javelinThrow;
	}
	/**
	 * @return the race_1500m
	 */
	public float getRace_1500m() {
		return race_1500m;
	}
	/**
	 * @param race_1500m the race_1500m to set
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

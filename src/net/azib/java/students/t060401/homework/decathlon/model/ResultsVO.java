package net.azib.java.students.t060401.homework.decathlon.model;

/**
 * @hibernate.class table="RESULTS"
 */
public class ResultsVO {

	/**
	 * @hibernate.property column ="SPRINT_100M"
	 */
	private double sprint100m; // seconds
	/**
	 * @hibernate.property column ="LONG_JUMP"
	 */
	private double longJump; // meters
	/**
	 * @hibernate.property column ="SHOT_PUT"
	 */
	private double shotPut; // meters
	/**
	 * @hibernate.property column ="HIGH_JUMP"
	 */
	private double highJump; // meters
	/**
	 * @hibernate.property column ="SPRINT_400M"
	 */
	private double sprint400m; // seconds
	/**
	 * @hibernate.property column ="HURDLES_110M"
	 */
	private double hurdles110m; // seconds
	/**
	 * @hibernate.property column ="DISCUS_THROW"
	 */
	private double discusThrow; // meters
	/**
	 * @hibernate.property column ="POLE_VAULT"
	 */
	private double poleVault; // meters
	/**
	 * @hibernate.property column ="JAVELIN_THROW"
	 */
	private double javelinThrow; // meters
	/**
	 * @hibernate.property column ="RACE_1500M"
	 */
	private double race1500m; // seconds
	/**
	 * @hibernate.property column ="ATHLETE_ID"
	 */
	private long athleteId;
	/**
	 * @hibernate.property column ="COMPETITION_ID"
	 */
	private long competitionId;
	/**
	 * @hibernate.property column ="ID"
	 */
	private long id;

	public long getAthleteId() {
		return athleteId;
	}

	public void setAthleteId(long athleteId) {
		this.athleteId = athleteId;
	}

	public long getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(long competitionId) {
		this.competitionId = competitionId;
	}

	public double getDiscusThrow() {
		return discusThrow;
	}

	public void setDiscusThrow(double discusThrow) {
		this.discusThrow = discusThrow;
	}

	public double getHighJump() {
		return highJump;
	}

	public void setHighJump(double highJump) {
		this.highJump = highJump;
	}

	public double getHurdles110m() {
		return hurdles110m;
	}

	public void setHurdles110m(double hurdles110m) {
		this.hurdles110m = hurdles110m;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getJavelinThrow() {
		return javelinThrow;
	}

	public void setJavelinThrow(double javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	public double getLongJump() {
		return longJump;
	}

	public void setLongJump(double longJump) {
		this.longJump = longJump;
	}

	public double getPoleVault() {
		return poleVault;
	}

	public void setPoleVault(double poleVault) {
		this.poleVault = poleVault;
	}

	public double getRace1500m() {
		return race1500m;
	}

	public void setRace1500m(double race1500m) {
		this.race1500m = race1500m;
	}

	public double getShotPut() {
		return shotPut;
	}

	public void setShotPut(double shotPut) {
		this.shotPut = shotPut;
	}

	public double getSprint100m() {
		return sprint100m;
	}

	public void setSprint100m(double sprint100m) {
		this.sprint100m = sprint100m;
	}

	public double getSprint400m() {
		return sprint400m;
	}

	public void setSprint400m(double sprint400m) {
		this.sprint400m = sprint400m;
	}

	public String toString() {
		String str = "";
		str += "Results:\n";
		str += "100 m sprint (sec): " + getSprint100m() + "\n";
		str += "Long jump (m): " + getLongJump() + "\n";
		str += "Shot put (m): " + getShotPut() + "\n";
		str += "High jump (m): " + getHighJump() + "\n";
		str += "400 m sprint (sec): " + getSprint400m() + "\n";
		str += "110 m hurdles (sec): " + getHurdles110m() + "\n";
		str += "Discus throw (m): " + getDiscusThrow() + "\n";
		str += "Pole vault (m): " + getPoleVault() + "\n";
		str += "Javelin throw (m): " + getJavelinThrow() + "\n";
		str += "1500 m race (sec): " + getRace1500m() + "\n";
		str += "\n";

		return str;
	}

	/**
	 * @return returns <code>true</code> if all the decathlon info is set and
	 *         does not contain negative values
	 */
	public boolean isComplete() {
		return discusThrow >= 0 && highJump >= 0 && javelinThrow >= 0 && longJump >= 0 && poleVault >= 0 && race1500m >= 0
				&& shotPut >= 0 && sprint100m >= 0 && sprint400m >= 0 && hurdles110m >= 0;
	}

}

package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.Constants;
import net.azib.java.students.t060401.homework.util.Utils;

import java.util.Vector;
import java.util.logging.Logger;

/**
 * DecathlonData
 * 
 * Contains the results of an athletic event combining 10 track and field events.
 * 
 * @author t060401
 */
public class DecathlonResults {

	Logger log = Logger.getLogger(DecathlonResults.class.getName());

	double sprint100m = -1; // seconds
	double longJump = -1; // meters
	double shotPut = -1; // meters
	double highJump = -1; // meters
	double sprint400m = -1; // seconds
	double hurdles110m = -1; // seconds
	double discusThrow = -1; // meters
	double poleVault = -1; // meters
	double javelinThrow = -1; // meters
	double race1500m = -1; // seconds
	
	long athleteId;
	long competitionId;
	long id;
	
	public DecathlonResults() {}
	
	/**
	 * @param discusThrow the discusThrow to set
	 */
	public void setDiscusThrow(double discusThrow) {
		this.discusThrow = discusThrow;
	}
	/**
	 * @param highJump the highJump to set
	 */
	public void setHighJump(double highJump) {
		this.highJump = highJump;
	}
	/**
	 * @param hurdles110m the hurdles110m to set
	 */
	public void setHurdles110m(double hurdles110m) {
		this.hurdles110m = hurdles110m;
	}
	/**
	 * @param javelinThrow the javelinThrow to set
	 */
	public void setJavelinThrow(double javelinThrow) {
		this.javelinThrow = javelinThrow;
	}
	/**
	 * @param longJump the longJump to set
	 */
	public void setLongJump(double longJump) {
		this.longJump = longJump;
	}
	/**
	 * @param poleVault the poleVault to set
	 */
	public void setPoleVault(double poleVault) {
		this.poleVault = poleVault;
	}
	/**
	 * @param race1500m the race1500m to set
	 */
	public void setRace1500m(double race1500m) {
		this.race1500m = race1500m;
	}
	/**
	 * @param shotPut the shotPut to set
	 */
	public void setShotPut(double shotPut) {
		this.shotPut = shotPut;
	}
	/**
	 * @param sprint100m the sprint100m to set
	 */
	public void setSprint100m(double sprint100m) {
		this.sprint100m = sprint100m;
	}
	/**
	 * @param sprint400m the sprint400m to set
	 */
	public void setSprint400m(double sprint400m) {
		this.sprint400m = sprint400m;
	}
	
	/**
	 * @return the athleteId
	 */
	public long getAthleteId() {
		return athleteId;
	}
	
	/**
	 * @param athleteId the athleteId to set
	 */
	public void setAthleteId(long athleteId) {
		this.athleteId = athleteId;
	}

	/**
	 * @return the competitionId
	 */
	public long getCompetitionId() {
		return competitionId;
	}

	/**
	 * @param competitionId the competitionId to set
	 */
	public void setCompetitionId(long competitionId) {
		this.competitionId = competitionId;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the discusThrow
	 */
	public double getDiscusThrow() {
		return discusThrow;
	}
	
	/**
	 * @return the discusThrow
	 */
	public int getDiscusThrowPoints() {
		return PointsCalculator.calculatePoints(Constants.DISCUS_THROW, discusThrow);
	}
	
	/**
	 * Parses the string which should contains double value. Double value must not be negative.
	 * 
	 * @param discusThrow the discusThrow to set
	 * @throws IllegalArgumentException if the string value cannot be parse
	 */
	public void setDiscusThrow(String discusThrow) throws IllegalArgumentException
	{
		this.discusThrow = -1;
		this.discusThrow = parseDistance(discusThrow);
	}
	/**
	 * @return the highJump
	 */
	public double getHighJump() {
		return highJump;
	}
	
	/**
	 * @return the highJump
	 */
	public int getHighJumpPoints() {
		return PointsCalculator.calculatePoints(Constants.HIGH_JUMP, Utils.parseMetersToCm(highJump));
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param highJump the highJump to set
	 */
	public void setHighJump(String highJump) throws IllegalArgumentException
	{
		this.highJump = -1;
		this.highJump = parseDistance(highJump);
	}
	/**
	 * @return the hurdles110m
	 */
	public double getHurdles110m() {
		return hurdles110m;
	}
	
	/**
	 * @return the hurdles110m
	 */
	public int getHurdles110mPoints() {
		return PointsCalculator.calculatePoints(Constants.HURDLES_110M, hurdles110m);
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param hurdles110m the hurdles110m to set
	 */
	public void setHurdles110m(String hurdles110m) throws IllegalArgumentException
	{
		this.hurdles110m = -1;
		this.hurdles110m = parseTime(hurdles110m);
	}
	/**
	 * @return the javelinThrow
	 */
	public double getJavelinThrow() {
		return javelinThrow;
	}
	
	/**
	 * @return the javelinThrow
	 */
	public int getJavelinThrowPoints() {
		return PointsCalculator.calculatePoints(Constants.JAVELIN_THROW, javelinThrow);
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param javelinThrow the javelinThrow to set
	 */
	public void setJavelinThrow(String javelinThrow) throws IllegalArgumentException
	{
		this.javelinThrow = -1;
		this.javelinThrow = parseDistance(javelinThrow);
	}
	/**
	 * @return the longJump
	 */
	public double getLongJump() {
		return longJump;
	}
	
	/**
	 * @return the longJump
	 */
	public int getLongJumpPoints() {
		return PointsCalculator.calculatePoints(Constants.LONG_JUMP, Utils.parseMetersToCm(longJump));
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param longJump the longJump to set
	 */
	public void setLongJump(String longJump) throws IllegalArgumentException
	{
		this.longJump = -1;
		this.longJump = parseDistance(longJump);
	}
	/**
	 * @return the poleVault
	 */
	public double getPoleVault() {
		return poleVault;
	}
	
	/**
	 * @return the poleVault
	 */
	public int getPoleVaultPoints() {
		return PointsCalculator.calculatePoints(Constants.POLE_VAULT, Utils.parseMetersToCm(poleVault));
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param poleVault the poleVault to set
	 */
	public void setPoleVault(String poleVault) throws IllegalArgumentException
	{
		this.poleVault = -1;
		this.poleVault = parseDistance(poleVault);
	}
	/**
	 * @return the race1500m
	 */
	public double getRace1500m() {
		return race1500m;
	}
	
	/**
	 * @return the race1500m
	 */
	public int getRace1500mPoints() {
		return PointsCalculator.calculatePoints(Constants.RACE_1500M, race1500m);
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param race1500m the race1500m to set
	 */
	public void setRace1500m(String race1500m) throws IllegalArgumentException
	{
		this.race1500m = -1;
		this.race1500m = parseTime(race1500m);
	}
	/**
	 * @return the shotPut
	 */
	public double getShotPut() {
		return shotPut;
	}
	
	/**
	 * @return the shotPut
	 */
	public int getShotPutPoints() {
		return PointsCalculator.calculatePoints(Constants.SHOT_PUT, shotPut);
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param shotPut the shotPut to set
	 */
	public void setShotPut(String shotPut) throws IllegalArgumentException
	{
		this.shotPut = -1;
		this.shotPut = parseDistance(shotPut);
	}
	/**
	 * @return the sprint100m
	 */
	public double getSprint100m() {
		return sprint100m;
	}
	
	/**
	 * @return the sprint100m
	 */
	public int getSprint100mPoints() {
		return PointsCalculator.calculatePoints(Constants.SPRINT_100M, sprint100m);
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param sprint100m the sprint100m to set
	 */
	public void setSprint100m(String sprint100m) throws IllegalArgumentException
	{
		this.sprint100m = -1;
		this.sprint100m = parseTime(sprint100m);
	}
	/**
	 * @return the sprint400m
	 */
	public double getSprint400m() {
		return sprint400m;
	}
	
	/**
	 * @return the sprint400m
	 */
	public int getSprint400mPoints() {
		return PointsCalculator.calculatePoints(Constants.SPRINT_400M, sprint400m);
	}
	
	/**
	 * Parses the string which should contains double value. Double value cannot not be negative.
	 * 
	 * @param sprint400m the sprint400m to set
	 */
	public void setSprint400m(String sprint400m) throws IllegalArgumentException
	{
		this.sprint400m = -1;
		this.sprint400m = parseTime(sprint400m);
	}
	
	/**
	 * @return Returns the sum of all the points of 10 events
	 */
	public int getPoints()
	{
		int points = 0;
		points += getDiscusThrowPoints();
		points += getHighJumpPoints();
		points += getHurdles110mPoints();
		points += getJavelinThrowPoints();
		points += getLongJumpPoints();
		points += getPoleVaultPoints();
		points += getRace1500mPoints();
		points += getShotPutPoints();
		points += getSprint100mPoints();
		points += getSprint400mPoints();
		return points;
	}
	
	public String toString() {
		String str = "";
		str += "Results ("+getPoints()+" points):\n";
		str += "100 m sprint (sec): " + getSprint100m() + " ("+getSprint100mPoints()+" points)\n";
		str += "Long jump (m): " + getLongJump() + " ("+getLongJumpPoints()+" points)\n";
		str += "Shot put (m): " + getShotPut() + " ("+getShotPutPoints()+" points)\n";
		str += "High jump (m): " + getHighJump() + " ("+getHighJumpPoints()+" points)\n";
		str += "400 m sprint (sec): " + getSprint400m() + " ("+getSprint400mPoints()+" points)\n";
		str += "110 m hurdles (sec): " + getHurdles110m() + " ("+getHurdles110mPoints()+" points)\n";
		str += "Discus throw (m): " + getDiscusThrow() + " ("+getDiscusThrowPoints()+" points)\n";
		str += "Pole vault (m): " + getPoleVault() + " ("+getPoleVaultPoints()+" points)\n";
		str += "Javelin throw (m): " + getJavelinThrow() + " ("+getJavelinThrowPoints()+" points)\n";
		str += "1500 m race (sec): " + getRace1500m() + " ("+getRace1500mPoints()+" points)\n";
		str += "\n";

		return str;
	}
	
	/**
	 * @return the vetor containing all the results of decathlon event
	 */
	public Vector<Object> toVector() {
		Vector<Object> resultVector = new Vector<Object>();
		resultVector.add(Utils.getTimeString(getSprint100m()));
		resultVector.add(Utils.getDistanceString(getLongJump()));
		resultVector.add(Utils.getDistanceString(getShotPut()));
		resultVector.add(Utils.getDistanceString(getHighJump()));
		resultVector.add(Utils.getTimeString(getSprint400m()));
		resultVector.add(Utils.getTimeString(getHurdles110m()));
		resultVector.add(Utils.getDistanceString(getDiscusThrow()));
		resultVector.add(Utils.getDistanceString(getPoleVault()));
		resultVector.add(Utils.getDistanceString(getJavelinThrow()));
		resultVector.add(Utils.getTimeString(getRace1500m()));
		return resultVector;
	}
	
	/**
	 * @return returns <code>true</code> if all the decathlon info is set and does not contain negative values
	 */
	public boolean isComplete() {
		return discusThrow >= 0  && highJump >= 0 && javelinThrow >= 0 && longJump >= 0 && poleVault >= 0
				&& race1500m >= 0 && shotPut >= 0 && sprint100m >= 0 && sprint400m >= 0 && hurdles110m >= 0;
	}
	
	/**
	 * Parses time string to get seconds value. Minutes and seconds should be separated with ':'. Minutes value must be postitve integer value, seconds value must be a positive integer or double value.
	 * 
	 * @param time time string to parse
	 * @return returns seconds
	 * @throws IllegalArgumentException if time string could not be parsed
	 */
	private double parseTime (String time) throws IllegalArgumentException
	{
		if (time==null||"".equals(time))
		{
			throw new IllegalArgumentException("Time value cannot be null");
		}
		int minutes = Utils.extractMinutes(time);
		double seconds = Utils.extractSeconds(time);
		double parsedTime = seconds+(double)minutes*(double)60;
		if (parsedTime<0)
		{
			throw new IllegalArgumentException("Time value cannot be negative");
		}
		return parsedTime;
	}
	
	/**
	 * Parses distance string to get meters value. Meters value must be a positive integer or double value.
	 * 
	 * @param distance
	 * @return returns meters
	 * @throws IllegalArgumentException
	 */
	private double parseDistance (String distance) throws IllegalArgumentException
	{
		double meters;
		if (distance==null||"".equals(distance))
		{
			throw new IllegalArgumentException("Distance value cannot be null");
		}
		try {
			meters = Double.parseDouble(distance);
		}
		catch (NumberFormatException e) {
			throw new IllegalArgumentException("Illegal distance value: " + distance, e);
		}
		if (meters<0)
		{
			throw new IllegalArgumentException("Distance value cannot be negative");
		}
		return meters;
	}
}

package net.azib.java.students.t092874.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Decathlon
 * 
 * @author Aleksandr GLadki
 */
public class Result implements Comparable<Result> {

	private float sprint100;
	private float longJump;
	private float shortPut;
	private float highJump;
	private float sprint400;
	private float hurdles;
	private float discusThrow;
	private float poleVault;
	private float javelinThrow;
	private float race;
	private Athlete athlete;
	private int points;

	Result(){}
	
	Result(String[] line) {
		if (line.length !=  13)
			throw new IllegalArgumentException ("Line donn't consist 13 elements ");
		convertToResult(line);
		convertToAthlete(line);
	}

	private void convertToResult(String[] line) {
		setSprint100(Util.convertStringToNumberInSecond(line[3]));
		setLongJump(Float.valueOf(line[4]));
		setShortPut(Float.valueOf(line[5]));
		setHighJump(Float.valueOf(line[6]));
		setSprint400(Util.convertStringToNumberInSecond(line[7]));
		setHurdles(Util.convertStringToNumberInSecond(line[8]));
		setDiscusThrow(Float.valueOf(line[9]));
		setPoleVault(Float.valueOf(line[10]));
		setJavelinThrow(Float.valueOf(line[11]));
		setRace(Util.convertStringToNumberInSecond(line[12]));
		getPoints(); // fill points
	}

	private void convertToAthlete(String[] line) {
		athlete = new Athlete();
//		only word characters and whitespace
		Pattern pattern = Pattern.compile("[^\\w\\s]");
		Matcher matcher = pattern.matcher(line[0]);
		String str = matcher.replaceAll("");
		athlete.setName(str);
		
		athlete.setBirthday(Util.convertStringToDate(line[1]));
		athlete.setCountryCode(line[2]);

	}
/**
 * 
 * @return Convert Result Object to one String line.
 */
	public String putToString(boolean csv) {

		String quote = "";
		if (csv)
			quote = "\"";
		return getPoints() + "," + quote + getAthlete().getName() + quote + ","
				+ Util.convertDateToString(getAthlete().getBirthday()) + "," + getAthlete().getCountryCode() + ","
				+ getSprint100() + "," + getLongJump() + "," + getShortPut() + "," + getHighJump() + ","
				+ Util.convertNumberInSecondToString(getSprint400()) + "," + getHurdles() + "," + getDiscusThrow() + ","
				+ getPoleVault() + "," + getJavelinThrow() + "," + Util.convertNumberInSecondToString(getRace());
	}

	
	
	/**
	 * @return the athlete
	 */
	public Athlete getAthlete() {
		return athlete;
	}

	/**
	 * @param athlete
	 *            the athlete to set
	 */
	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	/**
	 * @return the sprint100
	 */
	public float getSprint100() {
		return sprint100;
	}

	/**
	 * @param sprint100
	 *            the sprint100 to set
	 */
	public void setSprint100(float sprint100) {
		this.sprint100 = sprint100;
	}

	/**
	 * @return the longJump
	 */
	public float getLongJump() {
		return longJump;
	}

	/**
	 * @param longJump
	 *            the longJump to set
	 */
	public void setLongJump(float longJump) {
		this.longJump = longJump;
	}

	/**
	 * @return the shortPut
	 */
	public float getShortPut() {
		return shortPut;
	}

	/**
	 * @param shortPut
	 *            the shortPut to set
	 */
	public void setShortPut(float shortPut) {
		this.shortPut = shortPut;
	}

	/**
	 * @return the highJump
	 */
	public float getHighJump() {
		return highJump;
	}

	/**
	 * @param highJump
	 *            the highJump to set
	 */
	public void setHighJump(float highJump) {
		this.highJump = highJump;
	}

	/**
	 * @return the sprint400
	 */
	public float getSprint400() {
		return sprint400;
	}

	/**
	 * @param sprint400
	 *            the sprint400 to set
	 */
	public void setSprint400(float sprint400) {
		this.sprint400 = sprint400;
	}

	/**
	 * @return the hurdles
	 */
	public float getHurdles() {
		return hurdles;
	}

	/**
	 * @param hurdles
	 *            the hurdles to set
	 */
	public void setHurdles(float hurdles) {
		this.hurdles = hurdles;
	}

	/**
	 * @return the discusThrow
	 */
	public float getDiscusThrow() {
		return discusThrow;
	}

	/**
	 * @param discusThrow
	 *            the discusThrow to set
	 */
	public void setDiscusThrow(float discusThrow) {
		this.discusThrow = discusThrow;
	}

	/**
	 * @return the poleVault
	 */
	public float getPoleVault() {
		return poleVault;
	}

	/**
	 * @param poleVault
	 *            the poleVault to set
	 */
	public void setPoleVault(float poleVault) {
		this.poleVault = poleVault;
	}

	/**
	 * @return the javelinThrow
	 */
	public float getJavelinThrow() {
		return javelinThrow;
	}

	/**
	 * @param javelinThrow
	 *            the javelinThrow to set
	 */
	public void setJavelinThrow(float javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	/**
	 * @return the race
	 */
	public float getRace() {
		return race;
	}

	/**
	 * @param race
	 *            the race to set
	 */
	public void setRace(float race) {
		this.race = race;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {

		if (points == 0)
			calculate();
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Override compare method in Result Object
	 */
	@Override
	public int compareTo(Result o) {
		if (this.getPoints() > o.getPoints()) {
			return -1;
		}
		else if (this.getPoints() < o.getPoints()) {
			return 1;
		}
		return 0;
	}

	/**
	 * Calculate  points for athlete
	 */
	public void calculate() {
		int points = 0;
		points = Double.valueOf(
				Constants.SPRING_100_A * Math.pow(getSprint100() - Constants.SPRING_100_B, Constants.SPRING_100_C)).intValue();
		points += Double.valueOf(Constants.LONG_JUMP_A * Math.pow(Constants.LONG_JUMP_B - getLongJump(), Constants.LONG_JUMP_C))
				.intValue();
		points += Double.valueOf(Constants.SHOT_PUT_A * Math.pow(Constants.SHOT_PUT_B - getShortPut(), Constants.SHOT_PUT_C))
				.intValue();
		points += Double.valueOf(Constants.HIGH_JUMP_A * Math.pow(Constants.HIGH_JUMP_B - getHighJump(), Constants.HIGH_JUMP_C))
				.intValue();
		points += Double.valueOf(
				Constants.SPRING_400_A * Math.pow(getSprint400() - Constants.SPRING_400_B, Constants.SPRING_400_C)).intValue();
		points += Double.valueOf(Constants.HURDLES_A * Math.pow(Constants.HURDLES_B - getHurdles(), Constants.HURDLES_C))
				.intValue();
		points += Double.valueOf(
				Constants.DISCUS_THROW_A * Math.pow(Constants.DISCUS_THROW_B - getDiscusThrow(), Constants.DISCUS_THROW_C))
				.intValue();
		points += Double.valueOf(
				Constants.POLE_VAULT_A * Math.pow(Constants.POLE_VAULT_B - getPoleVault(), Constants.POLE_VAULT_C)).intValue();
		points += Double.valueOf(
				Constants.JAVELIN_THROW_A * Math.pow(Constants.JAVELIN_THROW_B - getJavelinThrow(), Constants.JAVELIN_THROW_C))
				.intValue();
		points += Double.valueOf(Constants.RACE_A * Math.pow(getRace() - Constants.RACE_B, Constants.RACE_C)).intValue();
		setPoints(points);
	}
}

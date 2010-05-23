package net.azib.java.students.t050724.homework;

import java.util.Date;

/**
 * Athlete
 * 
 * @author xom
 */
public class Athlete implements Comparable<Athlete> {

	private String name;
	private Date date;
	private String country;
	private double hm;
	private double longJump;
	private double shotPut;
	private double highJump;
	private double fhm;
	private double htmHurdles;
	private double discusThrow;
	private double poleVault;
	private double javelinThrow;
	private double tfhm;
	private int score;
	private String place;

	/**
	 *Compares the Athlete objects with each other by score.
	 */
	@Override
	public int compareTo(Athlete o) {
		if (this.score == ((Athlete) o).score)
			return 0;
		else if ((this.score) > ((Athlete) o).score)
			return 1;
		else
			return -1;
	}

	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	protected Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	protected void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the country
	 */
	protected String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	protected void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the hm
	 */
	protected double getHm() {
		return hm;
	}

	/**
	 * @param hm
	 *            the hm to set
	 */
	protected void setHm(double hm) {
		this.hm = hm;
	}

	/**
	 * @return the longJump
	 */
	protected double getLongJump() {
		return longJump;
	}

	/**
	 * @param longJump
	 *            the longJump to set
	 */
	protected void setLongJump(double longJump) {
		this.longJump = longJump;
	}

	/**
	 * @return the shotPut
	 */
	protected double getShotPut() {
		return shotPut;
	}

	/**
	 * @param shotPut
	 *            the shotPut to set
	 */
	protected void setShotPut(double shotPut) {
		this.shotPut = shotPut;
	}

	/**
	 * @return the highJump
	 */
	protected double getHighJump() {
		return highJump;
	}

	/**
	 * @param highJump
	 *            the highJump to set
	 */
	protected void setHighJump(double highJump) {
		this.highJump = highJump;
	}

	/**
	 * @return the fhm
	 */
	protected double getFhm() {
		return fhm;
	}

	/**
	 * @param fhm
	 *            the fhm to set
	 */
	protected void setFhm(double fhm) {
		this.fhm = fhm;
	}

	/**
	 * @return the htmHurdles
	 */
	protected double getHtmHurdles() {
		return htmHurdles;
	}

	/**
	 * @param htmHurdles
	 *            the htmHurdles to set
	 */
	protected void setHtmHurdles(double htmHurdles) {
		this.htmHurdles = htmHurdles;
	}

	/**
	 * @return the discusThrow
	 */
	protected double getDiscusThrow() {
		return discusThrow;
	}

	/**
	 * @param discusThrow
	 *            the discusThrow to set
	 */
	protected void setDiscusThrow(double discusThrow) {
		this.discusThrow = discusThrow;
	}

	/**
	 * @return the poleVault
	 */
	protected double getPoleVault() {
		return poleVault;
	}

	/**
	 * @param poleVault
	 *            the poleVault to set
	 */
	protected void setPoleVault(double poleVault) {
		this.poleVault = poleVault;
	}

	/**
	 * @return the javelinThrow
	 */
	protected double getJavelinThrow() {
		return javelinThrow;
	}

	/**
	 * @param javelinThrow
	 *            the javelinThrow to set
	 */
	protected void setJavelinThrow(double javelinThrow) {
		this.javelinThrow = javelinThrow;
	}

	/**
	 * @return the tfhm
	 */
	protected double getTfhm() {
		return tfhm;
	}

	/**
	 * @param tfhm
	 *            the tfhm to set
	 */
	protected void setTfhm(double tfhm) {
		this.tfhm = tfhm;
	}

	/**
	 * @return the score
	 */
	protected int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	protected void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the place
	 */
	protected String getPlace() {
		return place;
	}

	/**
	 * @param place
	 *            the place to set
	 */
	protected void setPlace(String place) {
		this.place = place;
	}

}

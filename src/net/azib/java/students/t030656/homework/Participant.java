package net.azib.java.students.t030656.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import sun.util.calendar.BaseCalendar.Date;


/**
 * Participant
 *
 * @author Sprot
 */
public class Participant {
	
	private String name;
	private String dateOfBirth;
	private String country;
	private int points;
	
	
	/**
	 * constructor
	 */
	public Participant(String name, String country, String dateOfBirth,
			double resRun100, double resLongJump, double resShotPut, 
			double resHighJump, Date resRun400, double resRunHurdles,
			double resDiscusThrow, double resPoleVault, double resJavelinThrow,
			Date resRun1500) {
		SimpleDateFormat sdfDateOfBirth = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat sdfResultTimes = new SimpleDateFormat("ss");
		
		System.out.println(sdfResultTimes.format(resRun400));
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
}

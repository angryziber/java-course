package net.azib.java.students.t092851.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Participant
 *
 * @author Lauri
 */
public class Participant {
	private String    name;
	private Date      birthDate;
	private String    country;
	private Double [] results;
	private boolean   resultChange;
	private long      points;
	private String    place;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the date
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param date the date to set
	 */
	public void setBirthDate(Date birthDate) {
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
	 * @return the result
	 */
	public Double getResult(DecathlonEvent event) {
		return results[event.getIndex()];
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(DecathlonEvent event, Double result) {
		this.results[event.getIndex()] = result;
		resultChange = true;
	}
	
	public long getPoints() {
		if (resultChange) {
			calculatePoints();
			resultChange = false;
		}
		return points;
	}

	private void calculatePoints() {
		points = 0;
		for (DecathlonEvent event : DecathlonEvent.values())
			points += event.calcPoints(results[event.getIndex()]);
	}

	public Participant() {
		name      = "ANONYMUS";
		birthDate = new Date();
		country   = "N/A";
		place     = "(not set)";
		results   = new Double[DecathlonEvent.countEvents()];
		resultChange = true;
	}
	
	/**
	 * @return
	 */
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuild   = new StringBuilder();
		DateFormat    dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		strBuild.append("Place      : ").append(place      ).append('\n');
		strBuild.append("Points     : ").append(getPoints()).append('\n');
		strBuild.append("Name       : ").append(name       ).append('\n');
		strBuild.append("Birth date : ").append(dateFormat.format(birthDate)).append('\n');
		strBuild.append("Country    : ").append(country    ).append('\n');
		for (DecathlonEvent event: DecathlonEvent.values())
			strBuild.append(endPaddding(event.getName(), ' ', 14)).append(": ").append(getResult(event)).append(" " + event.getUnits()).append('\n');
		return strBuild.toString();
	}
	
	private String endPaddding(String s, char symbol, int length) {
		StringBuilder strBuilder = new StringBuilder(s);
		for (int i = s.length(); i < length; i++)
			strBuilder.append(symbol);
		return strBuilder.toString();
	}
}

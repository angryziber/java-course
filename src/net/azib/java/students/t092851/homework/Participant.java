package net.azib.java.students.t092851.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Participant - stores decathlon athlete data
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
	 * @return participant name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name participant name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return participant date of birth
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	
	/**
	 * @param date participant date of birth to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	
	/**
	 * @return two-letter ISO country code
	 */
	public String getCountry() {
		return country;
	}

	
	/**
	 * @param country two-letter ISO country code to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	
	/**
	 * @param event specifies decathlon event
	 * @return the result that corresponds to event
	 */
	public Double getResult(DecathlonEvent event) {
		return results[event.getIndex()];
	}

	
	/**
	 * @param event specifies decathlon event
	 * @param result decathlon event result to set
	 */
	public void setResult(DecathlonEvent event, Double result) {
		this.results[event.getIndex()] = result;
		resultChange = true;
	}
	
	
	/**
	 * @return points calculated from results 
	 */
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

	
	/**
	 * Default constructor
	 */
	public Participant() {
		name      = "ANONYMUS";
		birthDate = new Date();
		country   = "N/A";
		place     = "(not set)";
		results   = new Double[DecathlonEvent.countEvents()];
		resultChange = true;
	}
	
	
	/**
	 * @return rank in competition
	 */
	public String getPlace() {
		return place;
	}

	
	/**
	 * Sets place in competition
	 * @param place rank to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	private String endPaddding(String s, char symbol, int length) {
		StringBuilder strBuilder = new StringBuilder(s);
		for (int i = s.length(); i < length; i++)
			strBuilder.append(symbol);
		return strBuilder.toString();
	}
	
	
	/**
	 * @return data in string format 
	 */
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
	
	
	/**
	 * @param obj object to compare with 'this'
	 * @return true if all strategic data (name, country, birth date, results) equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		
		if ( !(obj instanceof Participant) )
			return false;

		Participant p          = (Participant)obj;
		// Since dates may not be equal even if dates in string format
		// are identical then dates are converted to strings before comparison
		DateFormat  dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		String      dateStr1   = dateFormat.format(p.birthDate);
		String      dateStr2   = dateFormat.format(this.birthDate);
		
		// Check that all "important" fields are the same
		if (       p.name.equals(this.name)
				&& p.country.equals(this.country)
				&& dateStr1.equals(dateStr2) ) {
			for (DecathlonEvent event : DecathlonEvent.values()) {
				if (!p.results[event.getIndex()].equals(this.results[event.getIndex()]))
					return false;
			}
			return true;
		}
		
		return false;
	}

}

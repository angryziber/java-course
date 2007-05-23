package net.azib.java.students.t050657.homework.src.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Athlet class represents athlet, implements comparable. 
 * 
 * @author Boriss
 */
public class Athlet implements Comparable<Athlet>{
	
	private Integer id;
	private String name;
	private Calendar dateOfBirth;
	private String countryCode;
	
	private Result result;
	
	private double finalScore;
	private String place;
	
	/**
	 * Concstructs new instance of athlet
	 */
	public Athlet(){
		
	}
	
	/**
	 * Concstructs new instance of athlet
	 * @param id unique number of athlet
	 * @param name of athlet
	 * @param dateOfBirth represents date of athlets birth	
	 * @param countryCode which athlet represents
	 */
	public Athlet(final Integer id, final String name, final Calendar dateOfBirth, final String countryCode) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.countryCode = countryCode;
	}
	
	/**
	 * Overriding Object's toString method. Output athlet in standartized format
	 */
	@Override
	public String toString() {
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		StringBuilder athlet =  new StringBuilder();
		
		athlet.append(place)
				.append("," + finalScore)
				.append(",\"" + name + "\"")
				.append("," + df.format(dateOfBirth.getTime()))
				.append(","+ countryCode);
		
		List<Double> results = result.getConvertedResults();
		
		for(Double res : results) {
			athlet.append("," + ((int)(res*100)/100));
		}
		
		return athlet.toString();
	}
	
	/**
	 * Equals method overriding Object's equals method.
	 * Tho athlets are equal if it's names, dates of birth and country codes are equal. 
	 */
	@Override
	public boolean equals(final Object obj) {
		if(!(obj instanceof Athlet))
			return false;
		
		final Athlet athlet = (Athlet) obj;

		if(!athlet.name.equals(this.name))
			return false;
		if(!athlet.dateOfBirth.getTime().equals(this.dateOfBirth.getTime()))
			return false;
		if(!athlet.countryCode.equals(this.countryCode))
			return false;
		
		return true;
	}

	/**
	 * Overriding Object's hashCode method.
	 */
	@Override
	public int hashCode() {
		int hash = 14;
		hash += hash * Integer.parseInt(this.name);
		hash += hash * Integer.parseInt(this.dateOfBirth.toString());
		hash += hash * Integer.parseInt(this.countryCode);
		return hash;
	}

	/**
	 * Method compare two athlets based on it's results (final scores).
	 * Method uses <i>calculateAndSetFinalScore</i> method.<br><br>
	 * Return value depends on:
	 * <ul>
	 * 	<li>if athlets <i>(not scores)</i> are equal - return 0.</li>
	 *  <li>if first athlet has <i>less</i> final score return 1</li>
	 *  <li>if first athlet has <i>upper</i> final score return -1 </li>
	 *  <li>if scores are equal it compares athlets in alphabetic order</li>
	 * </ul>
	 * It was designed for using with <i>TreeSet</i>. 
	 * So better results are higher in a set and different sortings goes right 
	 * in coordination of real athlet's prototype.
	 */
	public int compareTo(Athlet a){
		final int betterResult = -1;
		final int equalResult = 0;
		final int lessResult = 1;
		
		if(this.equals(a))
			return equalResult;
		
		if(this.finalScore  == 0) {
			this.calculateAndSetFinalScore();
		}
		if(a.finalScore == 0) {
			a.calculateAndSetFinalScore();
		}

		if(this.finalScore > a.finalScore) {
			return betterResult;
		}else if(this.finalScore < a.finalScore) {
			return lessResult;
		}else {
			if(this.name.compareTo(a.name) != 0) {
				return this.name.compareTo(a.name);
			}else if(this.countryCode.compareTo(a.countryCode) != 0) {
				return this.countryCode.compareTo(a.countryCode);
			}else {
				return this.dateOfBirth.compareTo(a.dateOfBirth);
			}
		}
	}

	/**
	 * Setter method  
	 * @param result to set
	 */
	public void setResult(final Result result) {
		this.result = result;
	}
	
	/**
	 * Getter for result
	 * @return result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * Getter for countryCode
	 * @return countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Getter for date of birth
	 * @return dateOfBirth
	 */
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Getter for id
	 * @return unique athlet id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Getter for name field
	 * @return athlet's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for countryCode
	 * @param countryCode to set
	 */
	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Setter for dateOfBirth
	 * @param dateOfBirth to set
	 */
	public void setDateOfBirth(final Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * Setter for id
	 * @param id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * Setter for name
	 * @param name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
	
	/**
	 * Calculetes and sets final score depends on athlet result
	 *
	 */
	public void calculateAndSetFinalScore(){
		try {
			finalScore = ((int)(result.getFinalScore()*100)) / 100;
		}
		catch (InsufficientResultsException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Getter for finalScore
	 * @return finalScore
	 */
	public double getFinalScore() {
		return finalScore;
	}

	/**
	 * Getter for place
	 * @return athlet's place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Setter for place
	 * @param place to set
	 */
	public void setPlace(final String place) {
		this.place = place;
	}
	
}
package net.azib.java.students.t030656.homework;

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
	private String[] strResults;
	private double[] results;

	
	
	/**
	 * constructor
	 */
	public Participant () {
		results = new double[10];
		this.points = 0;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @param strResults the strResults to set
	 */
	public void setResults (String[] strResults) {
		
		if(strResults.length != 10){
			throw new IllegalArgumentException();
		}
		this.strResults = strResults;
		int i = 0;
		for(String str : strResults){
			results[i++] = Double.parseDouble(str);
		}
		points = calcPoints();
	}
	/**
	 * @return the points
	 */
	private int calcPoints() {
		return Event.RUN100.getPoints(results[0]) +
					Event.LONGJUMP.getPoints(results[1]) +
					Event.SHOTPUT.getPoints(results[2]) +
					Event.HIGHJUMP.getPoints(results[3]) +
					Event.RUN400.getPoints(results[4]) +
					Event.RUNHURDLES.getPoints(results[5]) +
					Event.DISCUSTHROW.getPoints(results[6]) +
					Event.POLEVAULT.getPoints(results[7]) +
					Event.JAVELINTHROW.getPoints(results[8]) +
					Event.RUN1500.getPoints(results[9]);
	}
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @return the strResults
	 */
	public String[] getStrResults() {
		return strResults;
	}
}

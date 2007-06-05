package net.azib.java.students.t020543.homework;

/**
 * A class, which holds data about decathlon competition.<br>
 * ( <i>id, country, description, date</i> )
 *@author t020543
 */
public class Competition implements ICompetition {

	private int id;
	private String country;
	private String date;
	private String description;

	/**
	 * Constructs a {@link Competition} object.
	 *@param id - number of competition
	 *@param description - name of the competition
	 *@param country 
	 *@param date
	 */
	public Competition(int id, String country, String date, String description){
		this.id = id;
		this.country = country;
		this.date = date;
		this.description = description;
}
	
	@Override
	public String asString(){
		return "(" + this.id + ") " + "\"" + this.description + "\"" + " " + this.date + " " + this.country;
	} 
}
package net.azib.java.students.t010687.homework;

import java.text.DateFormat;
import java.util.Date;

/**
 * Competitions
 *
 * @author Matu
 */
public class Competition {

	private int id;
	private String country_code;
	private Date date;
	private String description;

	/** 
	 * @return String Country-Date-Description Format
	 * ("EE dd.mm.yyyy compdescription)
	 */
	@Override
	public String toString() {
		return country_code + " " 
		+ DateFormat.getDateInstance(DateFormat.MEDIUM).format(date) 
		+ " " + description;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}

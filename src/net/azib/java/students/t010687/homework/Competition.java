package net.azib.java.students.t010687.homework;

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * returns with description
	 */
	@Override
	public String toString() {
		return country_code + " " + description;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}

package net.azib.java.students.t980814.homework;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dom4j.Element;

/**
 * Athlete is a class that keeps the information about athlete.
 * The data for this class can be entered directly using int and String parameters or from database from 'athletes' table.
 * This class can output its data as String (regular format or CSV format) or as DOM4J Element-s.
 *
 * @author Allan Berg
 */
public class Athlete {

	private static final Logger LOG = Logger.getLogger(Athlete.class.getName());
	final static String COMMA = ",";
	public final static String CSV_DATE_FORMAT = "dd.MM.yyyy"; 
	
	protected int athleteId;
	protected String name;
	protected Date dob;
	protected String country;

	/**
	 * This is the dummy constructor of Athlete.
	 */
	public Athlete() {
		name = "unknown";
		dob = new Date();
		country = "";
	}
	
	/**
	 * This is the constructor of Athlete that simply fills it with data.
	 * @param athleteId - identificator
	 * @param name - the name of the athlete
	 * @param dob - date of birth. Must be in Athlete.CSV_DATE_FORMAT format. 
	 * @param country - the country of the athlete.
	 * @throws DecaCalcException - if the <b>dob</b> doesn't match the required pattern.
	 */
	public Athlete(int athleteId, String name, String dob, String country) throws DecaCalcException {
		DateFormat dfm = new SimpleDateFormat(CSV_DATE_FORMAT);
		this.athleteId = athleteId;
		this.name = name;
		try {
			this.dob = dfm.parse(dob);
		}
		catch (ParseException e) {
			throw new DecaCalcException("The entered date doesn't match the required pattern.");
		}
		this.country = country;
	}
	
	/**
	 * This is the constructor of Athlete that uses the connection and id to retrieve the data from database from 'athletes' table. 
	 * @param conn - an opened connection to database that contains an 'athletes' table that has following fields:
	 * 	id (int), name (varchar in UTF-8 format), country (varchar) and dob (date). 
	 * @param id - an identificator what to search from the 'athletes' table
	 * @throws DecaCalcException - if it was impossible to read data from 'athletes' table or if the name was not in UTF-8 format
	 */
	public Athlete(Connection conn,
			       int id) throws DecaCalcException {
		ResultSet rs = null;
		try {
			PreparedStatement athlete_statement = conn.prepareStatement("select * from athletes where id = ?");
			athlete_statement.setInt(1, id);
			rs = athlete_statement.executeQuery();
			LOG.info("Reading athlete (id=" + id + ") from DB");
			while (rs.next()) {
				this.athleteId = id;
				this.dob = rs.getDate("dob");
				this.name = new String(rs.getBytes("name"), "UTF-8");
				this.country = new String(rs.getBytes("country_code"), "UTF-8");
			}
		}
		catch (SQLException e) {
			throw new DecaCalcException("Error reading athlete data from athletes, id=" + id);
		}
		catch (UnsupportedEncodingException e) {
			throw new DecaCalcException("Unsupported charset in athlete data, id=" + id);
		}
		finally {
			Competition.closeQuietly(rs);
		}
	}

	/**
	 * Returns the contents of Athlete as String (regular format).
	 * The date of birth is formatted according to the local settings of the computer
	 * @return String
	 */
	@Override
	public String toString() {
		return new StringBuilder().append(name).append(" (").
                                   append(DateFormat.getDateInstance(DateFormat.MEDIUM).format(dob)).
                                   append(") from ").append(country).toString();
	}
	
	/**
	 * Returns the contents of Athlete as String (CSV format)
	 * The date of birth is formatted according Athlete.CSV_DATE_FORMAT
	 * @return String
	 */
	public String toStringCSV() {
		String dateStr;
		try {
			dateStr = new SimpleDateFormat(CSV_DATE_FORMAT).format(dob);
		} catch (Exception e) {
			dateStr = "-";
		}
		return new StringBuilder().append("\"").append(name).append("\"").append(COMMA).
								   append(dateStr).append(COMMA).
								   append(country).toString(); 
	}

	/**
	 * Takes the data from this class and appends it to DOM4J Element as child-Elements.
	 * The date of birth is formatted according to the local settings of the computer
	 * @param root - a DOM4J Element where to add child-Elements
	 * @return root
	 */
	public Element addAthleteDataToElement(Element root) {
		if (root instanceof Element) {
			DateFormat dfm = DateFormat.getDateInstance(DateFormat.MEDIUM);
			root.addElement("name").addText(name);
			root.addElement("country").addText(country);
			root.addElement("dob").addText(dfm.format(dob));
		}
		else
			LOG.log(Level.WARNING, "Unable to add athlete data, root parameter is not instance of Element.");
		return root;
	}

	/**
	 * Returns the athletes id.
	 * @return the athlete_id
	 */
	public int getAthleteId() {
		return athleteId;
	}

	/**
	 * Returns the athletes name.
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the athletes date of birth.
	 * @return the dob
	 */
	public Date getDateOfBirth() {
		return dob;
	}

	/**
	 * Returns the athletes country.
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
}

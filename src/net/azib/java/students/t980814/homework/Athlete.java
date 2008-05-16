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
 * Athlete
 *
 * @author dell
 */
public class Athlete {

	private static final Logger LOG = Logger.getLogger(Athlete.class.getName());
	final static String COMMA = ",";
	public final static String CSV_DATE_FORMAT = "dd.MM.yyyy"; 
	
	private int athleteId;
	private String name;
	private Date dob;
	private String country;

	/**
	 * @param athleteId
	 * @param name
	 * @param dob
	 * @param country
	 * @throws DecaCalcException
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
	 * @param conn
	 * @param id
	 * @throws DecaCalcException
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
	 *
	 */
	@Override
	public String toString() {
		return new StringBuilder().append(name).append(" (").
                                   append(DateFormat.getDateInstance(DateFormat.MEDIUM).format(dob)).
                                   append(") from ").append(country).toString();
	}
	
	/**
	 * @return
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
	 * @param root
	 * @return
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
	 * @return the athlete_id
	 */
	public int getAthleteId() {
		return athleteId;
	}
}

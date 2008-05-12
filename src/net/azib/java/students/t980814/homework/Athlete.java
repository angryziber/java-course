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

import org.dom4j.Element;

/**
 * Athlete
 *
 * @author dell
 */
public class Athlete {

	public final static String DATE_FORMAT = "dd.MM.yyyy"; 

	private int athlete_id;
	private String name;
	private Date dob;
	private String country;

	public Athlete(int athlete_id, String name, String dob, String country) throws DecaCalcException {
		DateFormat dfm = new SimpleDateFormat(DATE_FORMAT);
		this.athlete_id = athlete_id;
		this.name = name;
		try {
			this.dob = dfm.parse(dob);
		}
		catch (ParseException e) {
			throw new DecaCalcException("The entered date doesn't match the required pattern.");
		}
		this.country = country;
	}
	
	public Athlete(Connection conn,
			       int id) throws DecaCalcException {
		ResultSet rs = null;
		try {
			PreparedStatement athlete_statement = conn.prepareStatement("select * from athletes where id = ?");
			athlete_statement.setInt(1, id);
			rs = athlete_statement.executeQuery();
			while (rs.next()) {
				this.athlete_id = id;
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

	@Override
	public String toString() {
		final String COMMA = ",";
		StringBuilder sb = new StringBuilder();
		DateFormat dfm = new SimpleDateFormat(DATE_FORMAT);
		sb.append("\"").append(name).append("\"").append(COMMA);
		sb.append(dfm.format(dob)).append(COMMA);
		sb.append(country); 
		return sb.toString();
	}
	
	public Element addAthleteDataToElement(Element root) {
		if (root instanceof Element) {
			root.addElement("name").addText(name);
			root.addElement("dob").addText(dob.toString());
		}
		return root;
	}

	@Override
	public int hashCode() {
		return athlete_id;
	}
}

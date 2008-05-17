package net.azib.java.students.t980814.homework;

import static org.junit.Assert.*;

import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;


/**
 * AthleteTest
 *
 * @author dell
 */
public class AthleteTest {

	@Test
	public void testAthleteConstructor() {
		boolean exceptionWasThrown = false;
		try {
			Date date = new SimpleDateFormat(Athlete.CSV_DATE_FORMAT).parse("12.11.1999");
			Athlete a = new Athlete(123, "Nipi Tiri", "12.11.1999", "EE");
			assertEquals("Athlete's ID doesn't match", a.getAthleteId(), 123);
			assertEquals("Athlete's name doesn't match", a.getName(), "Nipi Tiri");
			assertEquals("Athlete's date doesn't match", a.getDateOfBirth(), date);
			assertEquals("Athlete's country code doesn't match", a.getCountry(), "EE");
		}
		catch (DecaCalcException e) {
			exceptionWasThrown = true;
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals("Unexpected exception was thrown when creating Athlete", false, exceptionWasThrown);
	}

	@Test
	public void testAthleteConstructorDB() {
		boolean exceptionWasThrown = false;
		try {
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
			Statement stmt = conn.createStatement();
			stmt.execute("create table athletes (id integer, name varchar, dob date, country_code varchar)");
			stmt.execute("insert into athletes values (1, 'John Doe', '1970-02-03', 'EE')");
			stmt.execute("insert into athletes values (2, 'Jaan Tamm', '2008-06-25', 'PL')");
			
			Athlete a = new Athlete(conn, 1);
			Athlete b = new Athlete(conn, 2);

			assertEquals("Athlete's ID doesn't match", a.getAthleteId(), 1);
			assertEquals("Athlete's name doesn't match", a.getName(), "John Doe");
			assertEquals("Athlete's date doesn't match", a.getDateOfBirth(), new SimpleDateFormat("yyyy-MM-dd").parse("1970-02-03"));
			assertEquals("Athlete's country code doesn't match", a.getCountry(), "EE");

			assertEquals("Athlete's ID doesn't match", b.getAthleteId(), 2);
			assertEquals("Athlete's name doesn't match", b.getName(), "Jaan Tamm");
			assertEquals("Athlete's date doesn't match", b.getDateOfBirth(), new SimpleDateFormat("yyyy-MM-dd").parse("2008-06-25"));
			assertEquals("Athlete's country code doesn't match", b.getCountry(), "PL");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (DecaCalcException e) {
			exceptionWasThrown = true;
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals("Unexpected exception was thrown when creating Athlete", false, exceptionWasThrown);
	}

	@Test
	public void testAthleteToString() {
		boolean exceptionWasThrown = false;
		try {
			Athlete a = new Athlete(123, "Nipi Tiri", "12.11.1999", "EE");
			Date date = new SimpleDateFormat("dd.MM.yyyy").parse("12.11.1999"); 
			assertEquals("Athlete.toString() is incorrect.", a.toString(),
						"Nipi Tiri (" +
						DateFormat.getDateInstance(DateFormat.MEDIUM).format(date) +
						") from EE");

			assertEquals("Athlete.toStringCSV() is incorrect.", a.toStringCSV(),
					"\"Nipi Tiri\"," +
					new SimpleDateFormat(Athlete.CSV_DATE_FORMAT).format(date) +
					",EE");
	}
		catch (DecaCalcException e) {
			exceptionWasThrown = true;
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		assertEquals("Unexpected exception was thrown when creating Athlete", false, exceptionWasThrown);
	}

	@Test
	public void testAthleteDOM4JElement() {
		boolean exceptionWasThrown = false;
		try {
			Athlete a = new Athlete(123, "Nipi Tiri", "12.11.1999", "EE");
			Document document = DocumentHelper.createDocument();
			Element root = document.addElement("competition");
			root = a.addAthleteDataToElement(root);
			assertEquals("The 'name' element was not added correctly", "Nipi Tiri", root.elementText("name"));
			assertEquals("The 'country' element was not added correctly", "EE", root.elementText("country"));
		}
		catch (DecaCalcException e) {
			exceptionWasThrown = true;
			e.printStackTrace();
		}
		assertEquals("Unexpected exception was thrown when creating Athlete", false, exceptionWasThrown);
	}
}

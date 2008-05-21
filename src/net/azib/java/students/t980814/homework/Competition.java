package net.azib.java.students.t980814.homework;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


/**
 * Class that operates with competitions.
 * It can get the results from the console, from CSV file or from database.
 * This class also builds the sorted list of all the results and outputs them to
 * console or to CSV file or to XML file or to HTML file.
 * 
 * @author Allan Berg
 */
public class Competition {

	private static final Logger LOG = Logger.getLogger(Competition.class.getName());
	final static String LN = System.getProperty("line.separator");

	private TreeSet<Results> results;
	private int competitionId;
	
	/**
	 * Constructor of Competition that reads input from inputStream (e.g. from console)
	 * and builds the Results collection
	 * 
	 * @param printStream - output stream to where to print the questions about data to be entered 
	 * @param inputStream - input stream from where to read the entered data
	 * @throws DecaCalcException - routes exceptions from Athlete or Results class if it was
	 * 	not possible to construct these classes according to entered data. 
	 */
	public Competition(PrintStream printStream, InputStream inputStream) throws DecaCalcException {
		LinkedList<Float> resultsFloat = new LinkedList<Float>();
		Scanner scanner = new Scanner(inputStream);
		results = new TreeSet<Results>();
		int athleteId = 1;
		do {
			printStream.print("Enter athlete's name: ");
			String name = scanner.nextLine();
			LOG.info("Reed name:" + name);
			Date date = readAthleteBirthday(printStream, "Enter athlete's date of birth", scanner);
			printStream.print("Enter athlete's country code: ");
			String country = scanner.next();
			
			resultsFloat.clear();
			resultsFloat.add(readRunningResult(printStream, "Enter result of 100 metres race: ", scanner));
			resultsFloat.add(readFieldResult(printStream, "Enter result of long jump: ", scanner));
			resultsFloat.add(readFieldResult(printStream, "Enter result of shot put: ", scanner));
			resultsFloat.add(readFieldResult(printStream, "Enter result of high jump: ", scanner));
			resultsFloat.add(readRunningResult(printStream, "Enter result of 400 metres race: ", scanner));
			resultsFloat.add(readRunningResult(printStream, "Enter result of 110 metres hurdles: ", scanner));
			resultsFloat.add(readFieldResult(printStream, "Enter result of discus throw: ", scanner));
			resultsFloat.add(readFieldResult(printStream, "Enter result of pole vault: ", scanner));
			resultsFloat.add(readFieldResult(printStream, "Enter result of javelin throw: ", scanner));
			resultsFloat.add(readRunningResult(printStream, "Enter result of 1500 metres race: ", scanner));
		
			results.add(new Results(new Athlete(athleteId++,
												name,
												new SimpleDateFormat(Athlete.CSV_DATE_FORMAT).format(date),
												country),
									resultsFloat));

		} while(askContinueEnteringConsole(printStream, "Enter data for next athlete (y/n)?", scanner));
		
		scanner.close();
	}
	
	/**
	 * Constructor of Competition class that reads input from CSV file
	 * and builds the Results collection

	 * @param fileCSV - CSV file to parse
	 * @throws DecaCalcException - routes exceptions from Athlete or Results class if it was
	 * 	not possible to construct these classes according to entered data.
	 * 	Also throws this exception if the given file could not be found of there were
	 *  problems accessing it.  
	 */
	public Competition(File fileCSV) throws DecaCalcException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileCSV), "UTF-8"));
			LOG.info("Opened CSV file: " + fileCSV);
			String line;
			results = new TreeSet<Results>();
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				try {
					lineNumber++;
					results.add(new Results(line));
				}
				catch (IndexOutOfBoundsException e) {
					throw new DecaCalcException("Error (not enough data) in file (" + fileCSV + ") on line nr:" + lineNumber);
				}
			}
		}
		catch (FileNotFoundException e) {
			throw new DecaCalcException("File not found: " + fileCSV);
		}
		catch (UnsupportedEncodingException e) {
			throw new DecaCalcException("Unsupported encoding in file: " + fileCSV);
		}
		catch (IOException e) {
			throw new DecaCalcException("Error reading file: " + fileCSV);
		}
		finally {
			closeQuietly(reader);
		}
	}
	
	/**
	 * This is the constructor of Competition that uses the connection and id to retrieve the data from
	 * database from 'competitions' table and from 'results' table via Results constructor
	 * (and also from 'athletes' table via Athlete constructor).  
	 * 
	 * @param conn - an opened connection to database that contains an 'results' table that has following fields:
	 * id (integer), athlete_id (integer), competition_id (integer), race_100m, long_jump, shot_put, high_jump, race_400m,
	 * hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m (all float)
	 *  and 'athletes' table that has following fields:
	 * 	id (int), name (varchar in UTF-8 format), country (varchar) and dob (date)
	 *  and 'competitions' that has at least following fields:
	 *  id (integer), name (varchar)
	 * @param compIdString - competition name or id to process
	 * @throws DecaCalcException
	 */
	public Competition(Connection conn,
			       String compIdString) throws DecaCalcException {
		ResultSet rs = null;

		try {
			PreparedStatement statement = conn.prepareStatement("select id from results where competition_id = ?");
			competitionId = getCompetitionIdInt(conn, compIdString);
			statement.setInt(1, competitionId);

			results = new TreeSet<Results>();
			rs = statement.executeQuery();
			while (rs.next())
				results.add(new Results(conn, rs.getInt("id")));
		}
		catch (SQLException e) {
			throw new DecaCalcException("Error reading results database.");
		}
		finally {
			closeQuietly(rs);
		}
	}

	/**
	 * Helper function that returns the competition id that matches the given competion name or id
	 * @param conn - an opened connection to database that contains an 'competitions' table that has at least following fields:
	 * id (integer), name (varchar)
	 * @param compIdString - competition name or id to search
	 * @return int - competitionId
	 * @throws DecaCalcException - if it was not possible to access the 'competitions' table
	 */
	private int getCompetitionIdInt(Connection conn, String compIdString) throws DecaCalcException {
		ResultSet rs = null;
		int returnCompId = 0;
		try {
			PreparedStatement competition_statement =
							conn.prepareStatement("select id from competitions where id = ? or name = ?");
			competition_statement.setString(1, compIdString);
			competition_statement.setString(2, compIdString);
			rs = competition_statement.executeQuery();
			if (rs.next())
				returnCompId = rs.getInt("id");
		}
		catch (SQLException e) {
			throw new DecaCalcException("Error reading competitions database.");
		}
		finally {
			closeQuietly(rs);
		}
		LOG.info("Reed competition id=" + returnCompId);
		return returnCompId;
	}
	
	/**
	 * Helper function that builds a list of places that match the current results
	 * @return LinkedList<String> of places
	 */
	private LinkedList<String> buildSortedResults() {
		LinkedList<String> positions = new LinkedList<String>();
		int place = 1;
		int prevSum = -1;
		int index = 1;
		int samePlaceCounter = 1;
		
		for (Results rr : results) {
			if (prevSum == rr.getSum()) {
				samePlaceCounter++;
				positions.removeLast();
			}
			else {
				place = index;
				if (samePlaceCounter > 1) {
					StringBuilder currentPosition = new StringBuilder();
					currentPosition.append(place-samePlaceCounter).append("-").append(place-1);
					for (int j = 0; j < samePlaceCounter; j++)
						positions.add(currentPosition.toString());
					System.out.println(currentPosition + " - " + place);
				}
				positions.add(String.valueOf(place));	
				samePlaceCounter = 1;
			}
			prevSum = rr.getSum();
			index++;
		}
		return positions;
	}
	
	/**
	 * Outputs the competition data into CSV file
	 * 
	 * @param fileCSV - file name to where to output 
	 * @throws DecaCalcException - if it was not possible to output data
	 */
	public void toStringCSV(File fileCSV) throws DecaCalcException {
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<String> position = buildSortedResults().iterator();
		for (Results rr : results)
			sb.append(position.next()).append(",").append(rr.toStringCSV()).append(LN);

		BufferedOutputStream bs = null;
		try {
			LOG.info("Creating CSV file=" + fileCSV);
			bs = new BufferedOutputStream(new FileOutputStream(fileCSV));
			bs.write(sb.toString().getBytes("UTF-8"));
		}
		catch (IOException e) {
			throw new DecaCalcException("Unable to output data to CSV file named " + fileCSV);
		}
		finally {
			closeQuietly(bs);
		}
	}

	/**
	 * Returns a formatted string of the decathlon competition
	 * @return result - formatted string
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("Sorted results: " + LN);
		java.util.Iterator<String> position = buildSortedResults().iterator();
		for (Results rr : results)
			sb.append(String.format("%2d", position.next())).append(". ").append(rr).append(LN);
		return sb.toString();
	}

	/**
	 * Helper function that builds a DOM4J Document according to current
	 * information about the competition, results and athletes
	 *
	 * @return - DOM4J Document
	 * @throws DecaCalcException - if exception was thrown from Results class
	 */
	private Document buildXMLDocument() throws DecaCalcException {
		LOG.info("Building XML document");
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("UTF-8");
		document.addDocType("competition", "", "decathlon.dtd");
		Element root = document.addElement("competition");
		
		java.util.Iterator<String> position = buildSortedResults().iterator();
		for (Results rr : results)
			root = rr.addResultsDataToElement(root, position.next());
		return document;
	}
	
	/**
	 * Outputs the competition data into XML file
	 * 
	 * @param fileXML - file name to where to output 
	 * @throws DecaCalcException - if it was not possible to output data
	 */
	public void toXML(File fileXML) throws DecaCalcException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter writer = null;
        try {
    		LOG.info("Creating XML file=" + fileXML);
        	writer = new XMLWriter(new FileOutputStream(fileXML), format);
			writer.write(buildXMLDocument());
		}
		catch (IOException e) {
			throw new DecaCalcException("Unable to create XML file");
		}
		finally {
			closeQuietly(writer);
		}
	}
	
	/**
	 * Outputs the competition data into HTML file using "DecaToHTML.xsl" stylesheet
	 * 
	 * @param fileHTML - file name to where to output 
	 * @throws DecaCalcException - if it was not possible to output data or if the stylesheet file was not found
	 */
	public void toHTML(File fileHTML) throws DecaCalcException {
		final String XSL_FILE = "DecaToHTML.xsl";
		FileOutputStream fos = null;
		try {
    		LOG.info("Creating HTML file=" + fileHTML);
			fos = new FileOutputStream(fileHTML);
			Transformer t = TransformerFactory.newInstance().
							newTransformer(new StreamSource(Competition.class.getResourceAsStream(XSL_FILE)));
			t.transform(new DocumentSource(buildXMLDocument()),
						new StreamResult(fos));
		}
		catch (FileNotFoundException e) {
			throw new DecaCalcException("Cannot find the XSL file: " + XSL_FILE);
		}
		catch (TransformerException e) {
			throw new DecaCalcException("Unable to transform data into HTML file.");
		}
		finally {
			closeQuietly(fos);
		}
	}

	
	/**
	 * Helper function for reading, verifying and converting running result from console
	 * @param out - output stream to where to print the question about the data
	 * @param queryText - the question what to ask from user
	 * @param scanner - from where to read the input
	 * @return float - parsed and converted input data
	 */
	private Float readRunningResult(PrintStream out, String queryText, Scanner scanner) {
		String inputText;
		Float result;
		while (true) {
			out.print(queryText);
			inputText = scanner.next();
			if (inputText.matches("([0-9]{1,2}:){0,1}[0-9]{1,2}[,.][0-9]{1,2}")) {
				inputText = inputText.replace(',', '.');
				String[] timeComponents = inputText.split(":");
				if (timeComponents.length > 1)
					result = (new Integer(timeComponents[0]) * 60) + new Float(timeComponents[1]);
				else
					result = new Float(timeComponents[0]);
				LOG.info("Reed running result (float): " + result);
				return result;
			}
			else
				out.println("The entered number doesn't match the required format (MM:)ss,mm or (MM:)ss.mm");
		}
	}
	
	/**
	 * Helper function for reading, verifying and converting field result from console
	 * @param out - output stream to where to print the question about the data
	 * @param queryText - the question what to ask from user
	 * @param scanner - from where to read the input
	 * @return float - parsed and converted input data
	 */
	private Float readFieldResult(PrintStream out, String queryText, Scanner scanner) {
		String inputText;
		Float result;
		while (true) {
			out.print(queryText);
			inputText = scanner.next();
			if (inputText.matches("[0-9]{1,3}[,.][0-9]{1,2}")) {
				inputText = inputText.replace(',', '.');
				result = new Float(inputText);
				LOG.info("Reed field result (float): " + result);
				return result;
			}
			else
				out.println("The entered number doesn't match the required format MMM,cc or MMM.cc");
		}
	}

	/**
	 * Helper function for reading, verifying and converting date from console
	 * @param out - output stream to where to print the question about the data
	 * @param queryText - the question what to ask from user
	 * @param scanner - from where to read the input
	 * @return Date - parsed and converted Date
	 */
	private Date readAthleteBirthday(PrintStream out, String queryText, Scanner scanner) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		Date date;
		while (true) {
			out.print(queryText + "(" + ((SimpleDateFormat)df).toPattern() + "): ");
			String dateStr = scanner.next();
			try {
				date = df.parse(dateStr);
				LOG.info("Reed date: " + date);
				return date;
			}
			catch (ParseException e) {
				out.println("The entered date doesn't match the required pattern.");
			}
		}
	}
	
	/**
	 * Helper function for reading confirmation about whether to enter data for a next athlete or not
	 * @param out - output stream to where to print the question about the data
	 * @param queryText - the question what to ask from user
	 * @param scanner - from where to read the input
	 * @return boolean - if data inputting should continue
	 */
	private boolean askContinueEnteringConsole(PrintStream out, String queryText, Scanner scanner) {
		out.print(queryText);
		String response = scanner.next();
		scanner.nextLine(); // flush the scanner
		if (response.matches("[yY]"))
			return true;
		else
			return false;
	}
	
	
	/**
	 * A helper function to quietly close a XMLWriter
	 * @param writer - XMLWriter to close
	 */
	private void closeQuietly(XMLWriter writer) {
		try {
			if (writer != null)
				writer.close();
		}
		catch (Exception e) {
		}
	}

	/**
	 * A helper function to quietly close a ResultSet
	 * @param rs - ResultSet to close
	 */
	public static void closeQuietly(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		}
		catch (Exception e) {
		}
	}

	/**
	 * A helper function to quietly close a Closeable
	 * @param rs - closeable to close
	 */
	public static void closeQuietly(Closeable r) {
		try {
			if (r != null)
				r.close();
		}
		catch (Exception e) {
		}
	}
}

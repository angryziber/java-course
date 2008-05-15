package net.azib.java.students.t980814.homework;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


/**
 * Results
 *
 * @author dell
 */
public class Competition {

	final static String LN = System.getProperty("line.separator");

	private TreeSet<Results> results;
	private int competitionId;
	
	public Competition(InputStream inputStream) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(inputStream);

		System.out.print("Enter athlete's name: ");
		sb.append("\"").append(scanner.next()).append("\"");
		
		System.out.print("Enter his/her date of birth (" + DateFormat.getDateInstance(DateFormat.MEDIUM) + "): ");
		
		scanner.close();
	}
	
	public Competition(File fileCSV) throws DecaCalcException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileCSV), "UTF-8"));
			String line;
			results = new TreeSet<Results>();
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				try {
					lineNumber++;
					results.add(new Results(line));
				}
				catch (IndexOutOfBoundsException e) {
					throw new DecaCalcException(e.getMessage() + "Error (not enough data) in file (" + fileCSV + ") on line nr:" + lineNumber);
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
		return returnCompId;
	}
	
	private LinkedList<Integer> buildSortedResults() {
		LinkedList<Integer> positions = new LinkedList<Integer>();
		int place = 1;
		int prevSum = -1;
		int index = 1;
		
		for (Results rr : results) {
			if (prevSum != rr.getSum())
				place = index;
			prevSum = rr.getSum();
			positions.add(place);
			index++;
		}
		return positions;
	}
	
	public void toStringCSV(File fileCSV) throws DecaCalcException {
		/*StringBuilder sb = new StringBuilder();
		java.util.Iterator<Integer> i = buildSortedResults().iterator();
		for (Results rr : results)
			sb.append(i.next()).append(",").append(rr.toStringCSV()).append(LN);
		*/
		String fileContent = toString();
		BufferedOutputStream bs = null;
		try {
			// What to do if there is no data to output... create an empty file?
			bs = new BufferedOutputStream(new FileOutputStream(fileCSV));
			bs.write(/*sb.toString().getBytes("UTF-8")*/fileContent.getBytes("UTF-8"));
		}
		catch (IOException e) {
			throw new DecaCalcException("Unable to output data to CSV file named " + fileCSV);
		}
		finally {
			closeQuietly(bs);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		java.util.Iterator<Integer> i = buildSortedResults().iterator();
		for (Results rr : results)
			sb.append(String.format("%2d", i.next())).append(". ").append(rr).append(LN);
		return sb.toString();
	}

	public void toXML(File fileXML) throws DecaCalcException {
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("UTF-8");
		document.addDocType("competition", "", "decathlon.dtd");
		Element root = document.addElement("competition");
		
		java.util.Iterator<Integer> i = buildSortedResults().iterator();
		for (Results rr : results)
			root = rr.addResultsDataToElement(root, i.next());
		
		//OutputFormat format = new OutputFormat("    ", true, "UTF-8");
		XMLWriter writer = null;
		BufferedOutputStream bs = null;
        try {
			bs = new BufferedOutputStream(new FileOutputStream(fileXML));
        	bs.write(document.asXML().getBytes("UTF-8"));
        	//writer = new XMLWriter(new FileWriter(fileXML), format);
			//writer.write(document);
		}
		catch (IOException e) {
			throw new DecaCalcException("Unable to create XML file");
		}
		finally {
			closeQuietly(writer);
			closeQuietly(bs);
		}
	}
	
	private void closeQuietly(XMLWriter writer) {
		try {
			if (writer != null)
				writer.close();
		}
		catch (Exception e) {
		}
	}

	public static void closeQuietly(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		}
		catch (Exception e) {
		}
	}

	public static void closeQuietly(Closeable r) {
		try {
			if (r != null)
				r.close();
		}
		catch (Exception e) {
		}
	}
}

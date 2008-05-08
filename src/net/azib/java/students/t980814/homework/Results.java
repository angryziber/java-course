package net.azib.java.students.t980814.homework;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Results
 *
 * @author dell
 */
public class Results {

	final String OUTPUT_PLACE_DELIMITER_CONSOLE = ". ";
	final String OUTPUT_PLACE_DELIMITER_CSV     = ",";
	
	private TreeSet<ResultRecord> results;
	private int comp_id;
	private String outputPlaceSeparator = OUTPUT_PLACE_DELIMITER_CONSOLE;
	
	
	public Results(InputStream inputStream) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(inputStream);

		System.out.print("Enter athlete's name: ");
		sb.append("\"").append(scanner.next()).append("\"");
		
		System.out.print("Enter his/her date of birth (" + Athlete.DATE_FORMAT + "): ");
		
		scanner.close();
	}
	
	public Results(File fileCSV) throws DecaCalcException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileCSV), "UTF-8"));
			String line;
			results = new TreeSet<ResultRecord>();
			int lineNumber = 0;
			while ((line = reader.readLine()) != null) {
				try {
					lineNumber++;
					results.add(new ResultRecord(line));
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
	
	public Results(Connection conn,
			       String competition_id) throws DecaCalcException {
		ResultSet rs = null;

		try {
			PreparedStatement result_statement = conn.prepareStatement("select * from results where id = ?");
			PreparedStatement statement = conn.prepareStatement("select id from results where competition_id = ?");

			this.comp_id = getCompetitionIdInt(conn, competition_id);
			statement.setInt(1, this.comp_id);

			rs = statement.executeQuery();
			results = new TreeSet<ResultRecord>();
			while (rs.next()) {
				result_statement.setInt(1, rs.getInt("id"));
				results.add(new ResultRecord(conn, result_statement));
			}
		}
		catch (SQLException e) {
			throw new DecaCalcException("Error reading results database.");
		}
		finally {
			closeQuietly(rs);
		}
	}

	private int getCompetitionIdInt(Connection conn, String competition_id) throws DecaCalcException {
		ResultSet rs = null;
		int returnCompId = 0;
		try {
			PreparedStatement competition_statement =
							conn.prepareStatement("select id from competitions where id = ? or name = ?");
			competition_statement.setString(1, competition_id);
			competition_statement.setString(2, competition_id);
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
	
	public void toStringCSV(File fileCSV) throws DecaCalcException {
		outputPlaceSeparator = OUTPUT_PLACE_DELIMITER_CSV;
		String fileContent = toString();
		BufferedOutputStream bs = null;
		try {
			// What to do if there is no data to output... create an empty file?
			bs = new BufferedOutputStream(new FileOutputStream(fileCSV));
			bs.write(fileContent.getBytes("UTF-8"));
		}
		catch (IOException e) {
			throw new DecaCalcException("Unable to output data to CSV file named " + fileCSV);
		}
		finally {
			closeQuietly(bs);
		}
	}

	public String toString() {
		final String LN = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();

		int place = 1;
		int prevSum = -1;
		int index = 1;
		
		for (ResultRecord rr : results) {
			if (prevSum != rr.getSum())
				place = index;
			prevSum = rr.getSum();
			sb.append(place).append(outputPlaceSeparator).append(rr);
			sb.append(LN);
			index++;
		}
		outputPlaceSeparator = OUTPUT_PLACE_DELIMITER_CONSOLE;
		return sb.toString();
	}

	public static void closeQuietly(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		}
		catch (Exception e) {
		}
	}

	public static void closeQuietly(OutputStream s) {
		try {
			if (s != null)
				s.close();
		}
		catch (Exception e) {
		}
	}

	public static void closeQuietly(Reader r) {
		try {
			if (r != null)
				r.close();
		}
		catch (Exception e) {
		}
	}
}

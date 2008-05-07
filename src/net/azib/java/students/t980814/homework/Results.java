package net.azib.java.students.t980814.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

/**
 * Results
 *
 * @author dell
 */
public class Results {

	private TreeSet<ResultRecord> results;
	private int comp_id;
	
	public Results(InputStream inputStream) {
		// loe andmed, moodusta string ja kasuta results.add(new ResultRecord(line))
	}
	
	public Results(File fileCSV) throws IOException {
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
					System.out.println("Error in CSV file on line nr:" + lineNumber);
					e.printStackTrace();
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding");
		}
		catch (IOException e) {
			System.out.println("Error reading file");
		}
		finally {
			try {
				reader.close();
			}
			catch (Exception e) {
			}
		}
	}
	
	public Results(Connection conn,
			       String competition_id) throws SQLException {
		PreparedStatement result_statement = conn.prepareStatement("select * from results where id = ?");
		PreparedStatement statement        = conn.prepareStatement("select id from results where competition_id = ?");

		this.comp_id = getCompetitionIdInt(conn, competition_id);
		statement.setInt(1, this.comp_id);

		ResultSet rs = statement.executeQuery();
		results = new TreeSet<ResultRecord>();
		while (rs.next()) {
			result_statement.setInt(1, rs.getInt("id"));
			results.add(new ResultRecord(conn, result_statement));
		}
		rs.close();
	}

	private int getCompetitionIdInt(Connection conn, String competition_id) throws SQLException {
		PreparedStatement competition_statement =
							conn.prepareStatement("select id from competitions where id = ? or name = ?");
		competition_statement.setString(1, competition_id);
		competition_statement.setString(2, competition_id);
		ResultSet rs = competition_statement.executeQuery();
		if (rs.next())
			return rs.getInt("id");
		else
			return 0;
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
			sb.append(place).append(". ").append(rr);
			sb.append(LN);
			index++;
		}
		return sb.toString();
	}
}

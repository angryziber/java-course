package net.azib.java.students.t980814.homework;

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

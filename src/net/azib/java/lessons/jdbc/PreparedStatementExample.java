package net.azib.java.lessons.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * PreparedStatementExample
 *
 * @author ant
 */
public class PreparedStatementExample extends SimpleExample {

	@Override
	public List<Person> makeQuery() throws SQLException {
		PreparedStatement ps = connection.prepareStatement("select * from test where gender = ? ");
		ps.setString(1, "M");
		ResultSet rs = ps.executeQuery();
		List<Person> list = extractData(rs);
		rs.close();
		ps.close();
		return list;
	}

}

package net.azib.java.students.t010687.homework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * JdbcStudentDao
 *
 * @author anton
 */
public class JdbcDechatlontDao implements DecathlonDao {
	
	private JdbcTemplate jdbcTemplate;
	private String query;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}

	public List<ResultsOfTheAthlet> getCompetition_id(int competitionsID) {
		return new ArrayList<ResultsOfTheAthlet>(); 
		/*jdbcTemplate.queryForObject(query, new Object[] {competitionsID}, new RowMapper() {
			public Object mapRow(ResultSet rs, int index) throws SQLException {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setStudentCode(rs.getString("studentCode"));
				return student;
			}
		})*/
	}

}

package net.azib.java.lessons.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * JdbcStudentDao
 *
 * @author anton
 */
public class JdbcStudentDao implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	private String query;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}

	public Student getStudent(String studentCode) {
		return (Student)
		jdbcTemplate.queryForObject(query, new Object[] {studentCode}, new RowMapper() {
			public Object mapRow(ResultSet rs, int index) throws SQLException {
				Student student = new Student();
				student.setName(rs.getString("name"));
				student.setStudentCode(rs.getString("studentCode"));
				return student;
			}
		});
	}

}

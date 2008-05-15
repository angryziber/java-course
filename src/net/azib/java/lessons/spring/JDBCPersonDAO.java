package net.azib.java.lessons.spring;

import net.azib.java.lessons.db.Person;
import net.azib.java.lessons.db.PersonDAO;
import net.azib.java.lessons.db.Person.Name;
import net.azib.java.lessons.db.Person.Sex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

/**
 * JDBCPersonDAO
 *
 * @author anton
 */
public class JDBCPersonDAO implements PersonDAO {
	
	private JdbcOperations jdbcOperations;

	/** loads a Person instance from the JDBC ResultSet */
	private RowMapper personMapper = new RowMapper() {
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			return new Person(new Name(rs.getString("name")), rs.getInt("age"), Sex.valueOf(rs.getString("sex")));
		}
	};

	@SuppressWarnings("unchecked")
	public Person loadPerson(int id) {
		List<Person> results = jdbcOperations.query("select * from persons where id = ?", new Object[] { id }, personMapper);
		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	public Collection<Person> findAllPersons() {
		List<Person> results = jdbcOperations.query("select * from persons", personMapper);
		return results;
	}

	public void setJdbcOperations(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}
}

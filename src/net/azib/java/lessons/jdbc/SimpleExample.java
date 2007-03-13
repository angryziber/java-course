package net.azib.java.lessons.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * SimpleExample
 * 
 * @author ant
 */
public class SimpleExample {

	protected Connection connection;

	public void initializeConnection(String url, String user, String password) throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		connection = DriverManager.getConnection(url, user, password);
	}

	public List<Person> makeQuery() throws SQLException {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from test");
		List<Person> list = extractData(resultSet); 
		resultSet.close();
		statement.close();
		return list;
	}
	
	public List<Person> extractData(ResultSet resultSet) throws SQLException{
		List<Person> list = new ArrayList<Person>(); 
		while (resultSet.next()) {
			list.add(new Person(resultSet.getString("name"), 
					resultSet.getInt("age"), resultSet.getString("gender")));
		}
		return list;
	}
	
	public void releaseConnection() throws SQLException{
		connection.close();
	}

	class Person {
		String name;
		int age;
		String gender;

		public Person(String name, int age, String gender) {
			super();
			this.name = name;
			this.age = age;
			this.gender = gender;
		}

		public String toString() {
			return "Person {name=" + name + "; age = " + age + "; gender=" + gender + "}";
		}
	}

	
}

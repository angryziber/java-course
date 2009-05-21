package net.azib.java.lessons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * FakeDB
 *
 * @author anton
 */
public class FakeDB {

	public void prepare() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
		Statement stmt = conn.createStatement();
		stmt.execute("create table persons (id integer, name varchar, age integer, sex char)");
		stmt.execute("insert into persons values (1, 'John Doe', 25, 'M')");
		stmt.execute("insert into persons values (2, 'Jaan Tamm', 43, 'M')");
		conn.close();
	}

}

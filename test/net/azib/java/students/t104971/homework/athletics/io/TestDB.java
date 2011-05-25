package net.azib.java.students.t104971.homework.athletics.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Fake database for Decathlon competition. As an example is taken FakeDB class by Anton Keks.
 * Create tables and insert scripts are exported from 'production' DB and simplified.
 *
 * @see net.azib.java.lessons.db.FakeDB
 */
public class TestDB {

	static void prepare() throws SQLException {
		Connection conn = null;
		try {
			conn = openConnection();
			Statement stmt = conn.createStatement();

			stmt.execute("CREATE TABLE athletes ( id int NOT NULL , name varchar NOT NULL, dob date NOT NULL, country_code varchar, PRIMARY KEY (id))");
			stmt.execute("CREATE TABLE competitions (id int NOT NULL , country_code varchar, date date, name varchar, location varchar(64), PRIMARY KEY (id))");
			stmt.execute("CREATE TABLE results (id int NOT NULL, athlete_id int, competition_id int," +
					"  race_100m float, long_jump float, shot_put float, high_jump float,\n" +
					"  race_400m float, hurdles_110m float, discus_throw float," +
					"  pole_vault float, javelin_throw float, race_1500m float, PRIMARY KEY (id))");

			stmt.execute("INSERT INTO athletes (id, name, dob, country_code) VALUES (1, 'Siim Susi', '1976-01-01', 'EE')");
			stmt.execute("INSERT INTO competitions (id, country_code, date, name, location) VALUES (1, 'PL', '2006-03-18', 'DECATHLON4BEER', 'Krakow')");
			stmt.execute("INSERT INTO results (id, athlete_id, competition_id, race_100m, long_jump, shot_put, high_jump, race_400m," +
					" hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m) VALUES\n" +
					"(1, 1, 1, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)");

			conn.commit();
		} catch (SQLException e) {
			rollbackQuietly(conn);
			throw new IllegalStateException("unable to prepare database.");
		} finally {
			closeQuietly(conn);
		}
	}

	static void clean() {
		Connection conn = null;
		try {
			conn = openConnection();
			Statement statement = conn.createStatement();

			statement.execute("DROP TABLE athletes");
			statement.execute("DROP TABLE competitions");
			statement.execute("DROP TABLE results");

			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			rollbackQuietly(conn);
		} finally {
			closeQuietly(conn);
		}
	}

	private static void rollbackQuietly(Connection conn) {
		try {
			if (conn != null)
				conn.rollback();
		} catch (SQLException ignore) {
		}
	}

	static Connection openConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:mem:DemoDB", "sa", "");
	}

	public static void closeQuietly(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException ignore) {
		}
	}
}

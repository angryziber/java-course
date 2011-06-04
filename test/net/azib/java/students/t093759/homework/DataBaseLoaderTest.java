package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.sql.*;

/**
 * @author dionis
 *         6/4/11 2:09 AM
 */
public class DataBaseLoaderTest {

	@Test(expected = IllegalArgumentException.class)
	public void thereShouldBeOneParameter() {
		new DataBaseLoader().load();
	}

	@Test(expected = IllegalArgumentException.class)
	public void parameterShouldBeAString() {
		new DataBaseLoader().load(112);
	}

	@Test
	public void badArgument() {
		
	}

	@Test
	public void playingWithDB() throws SQLException {
		DataBaseLoader dataBaseLoader = new DataBaseLoader();
		setUpFakeDB(dataBaseLoader);
		dataBaseLoader.connection = openConnection();
		String sql = "SELECT a.name, a.dob, a.country_code, " +
				"r.race_100m, r.long_jump, r.shot_put, r.high_jump, r.race_400m, r.hurdles_110m, r.discus_throw," +
				"r.pole_vault, r.javelin_throw, r.race_1500m " +
				"FROM athletes as a " +
				"INNER JOIN results as r" +
				" ON r.athlete_id=a.id" +
				" INNER JOIN competitions" +
				"  ON competitions.id=?";
		PreparedStatement preparedStatement = dataBaseLoader.connection.prepareStatement(sql);
		String value = "DECATHLON4BEER";
		int id = -1;
		try {
			id = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			PreparedStatement prepStat = dataBaseLoader.connection.prepareStatement("SELECT id FROM competitions WHERE name LIKE ? LIMIT 1");
			prepStat.setString(1, value);
			System.out.println(prepStat);
			ResultSet resultSet = prepStat.executeQuery();

			if (resultSet.next())
				id = resultSet.getInt(1);
		}
		System.out.println(id);
		preparedStatement.setInt(1, id);
		ResultSet rs = preparedStatement.executeQuery();
		ResultSetMetaData rsm = rs.getMetaData();
		int columnCount = rsm.getColumnCount();
		for (int i = 1; i <= columnCount; i++) {
			String columnName = rsm.getColumnName(i);
			System.out.print("| " + columnName + " ");
		}
		System.out.println("|");
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				String columnContent = rs.getString(i);
				System.out.print("| " + columnContent + " ");
			}
			System.out.println("|");
		}

		closeConnectionAt(dataBaseLoader);
	}

	public void setUpFakeDB(DataBaseLoader dataBaseLoader) {
		try {
			dataBaseLoader.connection = openConnection();
			Statement statement = dataBaseLoader.connection.createStatement();

			createAthletesTable(statement);
			fillAthletesTable(statement);

			createCompetitionsTable(statement);
			fillCompetitionsTable(statement);

			createResultsTable(statement);
			fillResultsTable(statement);

			dataBaseLoader.connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			rollbackAt(dataBaseLoader);
		} finally {
			closeConnectionAt(dataBaseLoader);
		}
	}

	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:mem:decathlon", "sa", "");
	}

	private void closeConnectionAt(DataBaseLoader dataBaseLoader) {
		try {
			dataBaseLoader.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void rollbackAt(DataBaseLoader dataBaseLoader) {
		try {
			dataBaseLoader.connection.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void fillResultsTable(Statement statement) throws SQLException {
		String insertPart = "INSERT INTO results (id, athlete_id, competition_id, race_100m, long_jump, shot_put, " +
				"high_jump, race_400m, hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m) VALUES ";
		String[] results = {
				"(1, 1, 2, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)",
				"(2, 2, 2, 13.04, 4.53, 7.79, 1.55, 64.72, 18.74, 24.2, 2.4, 28.2, 410.76)",
				"(3, 3, 2, 13.75, 4.84, 10.12, 1.5, 68.44, 19.18, 30.85, 2.8, 33.88, 382.75)",
				"(4, 4, 2, 13.43, 4.35, 8.64, 1.5, 66.06, 19.05, 24.89, 2.2, 33.48, 411.01)",
				"(5, 6, 2, 12.85, 4.9, 10.18, 1.35, 60.15, 17.54, 40.18, 2.89, 32.11, 399.98)",
				"(6, 1, 1, 14.15, 3.98, 10, 1.45, 70.12, 18.65, 29.15, 2.15, 32.67, 466.6)",
				"(7, 8, 1, 10.94, 7.83, 12.48, 2, 49.72, 15.67, 38.3, 5.4, 55.84, 271.72)",
				"(8, 8, 2, 10.94, 7.83, 12.48, 2, 49.72, 15.67, 38.3, 5.4, 55.84, 271.72)",
				"(9, 7, 2, 11.52, 7.87, 12.4, 2.05, 50.05, 15.6, 39, 5.45, 55.95, 274.42)",
				"(10, 9, 2, 12.85, 4.9, 10.18, 1.35, 60.15, 17.54, 40.18, 2.89, 32.11, 399.98)",
				"(11, 10, 2, 11.33, 7.18, 13.49, 1.94, 50.19, 15.17, 43.76, 4.5, 60.84, 277.86)",
				"(12, 5, 2, 12.75, 4.93, 10.05, 1.33, 60.25, 17.45, 40.17, 2.9, 32.13, 395)",
				"(13, 11, 2, 10.23, 8.05, 11, 2.1, 49.53, 16.11, 57.21, 5.54, 71, 270.18)",
				"(14, 12, 2, 10.62, 8.07, 16.57, 2, 47.74, 13.8, 45.51, 5, 68.53, 275.13)",
				"(15, 13, 2, 12.61, 5, 9.22, 1.2, 59.39, 16.4, 21.6, 2.6, 35.81, 315.72)",
				"(16, 14, 2, 12.61, 5, 9.22, 1.2, 59.39, 16.4, 21.6, 2.6, 35.81, 315.72)",
				"(17, 15, 2, 12.61, 5, 9.22, 1.2, 59.39, 16.4, 21.6, 2.6, 35.81, 315.72)",
				"(18, 39, 2, 12.61, 5, 9.22, 1.5, 59.39, 16.43, 21.6, 2.6, 35.81, 325.72)",
				"(19, 40, 2, 13.04, 4.53, 7.79, 1.55, 64.72, 18.74, 24.2, 2.4, 28.2, 410.76)",
				"(20, 41, 2, 13.75, 4.84, 10.12, 1.5, 68.44, 19.18, 30.85, 2.8, 33.88, 382.75)",
				"(21, 42, 2, 13.43, 4.35, 8.64, 1.5, 66.06, 19.05, 24.89, 2.2, 33.48, 411.01)"
		};
		executeInsertUsing(insertPart, results, statement);
	}

	private void createResultsTable(Statement statement) throws SQLException {
		String sql = "CREATE TABLE results (" +
				"  id int NOT NULL PRIMARY KEY," +
				"  athlete_id int NOT NULL ," +
				"  competition_id int NOT NULL ," +
				"  race_100m float NOT NULL ," +
				"  long_jump float NOT NULL ," +
				"  shot_put float NOT NULL ," +
				"  high_jump float NOT NULL ," +
				"  race_400m float NOT NULL ," +
				"  hurdles_110m float NOT NULL ," +
				"  discus_throw float NOT NULL ," +
				"  pole_vault float NOT NULL ," +
				"  javelin_throw float NOT NULL ," +
				"  race_1500m float NOT NULL ," +
				"  CONSTRAINT competitor_id FOREIGN KEY (athlete_id) REFERENCES athletes (id)" +
				")";
		statement.execute(sql);
	}

	private void fillCompetitionsTable(Statement statement) throws SQLException {
		String insertPart = "INSERT INTO competitions (id, country_code, date, name, location) VALUES ";
		String[] competitions = {
				"(1, 'EE', '2005-12-01', 'Training', 'Tallinn')",
				"(2, 'PL', '2006-03-18', 'DECATHLON4BEER', 'Krakow')",
				"(3, 'EE', '2005-12-01', 'Training', 'Tallinn2')",
		};
		executeInsertUsing(insertPart, competitions, statement);
	}

	private void createCompetitionsTable(Statement statement) throws SQLException {
		String sql = "CREATE TABLE competitions (" +
				"  id int NOT NULL PRIMARY KEY," +
				"  country_code varchar NOT NULL," +
				"  date date NOT NULL," +
				"  name varchar," +
				"  location varchar(64)" +
				")";
		statement.execute(sql);
	}

	private void executeInsertUsing(String insertPart, String[] valuesPart, Statement statement) throws SQLException {
		for (String values : valuesPart) {
			String sql = insertPart + values;
			System.out.print(sql + " : ");
			System.out.println(statement.execute(sql));
		}
	}

	private void fillAthletesTable(Statement statement) throws SQLException {
		String insertPart = "INSERT INTO athletes (id, name, dob, country_code) VALUES ";
		String[] athletes = {
				"(1, 'Siim Susi', '1976-01-01', 'EE');",
				"(2, 'Beata Kana', '1989-05-09', 'ZA');",
				"(3, 'József Fenyő', '1972-04-03', 'HU');",
				"(4, 'Василий Пупкин', '1980-10-21', 'UA');",
				"(5, 'José Maria González Desperado', '1967-05-03', 'ES');",
				"(6, 'Mąrtęn Kołobrźeg', '1979-12-31', 'PL');",
				"(7, 'Janis Litoměřice', '1985-06-06', 'LV');",
				"(8, 'Erki Nool', '1970-06-25', 'EE');",
				"(9, 'Marat Zuckermann', '1973-08-05', 'IL');",
				"(10, '宗弘金子 (Munehiro Kaneko)', '1968-06-06', 'JP');",
				"(11, 'Mumbalele-Nsowu Mensah-Bonsu Pops', '1985-05-15', 'ZW');",
				"(12, 'Tomáš Dvořák', '1972-05-11', 'CZ');",
				"(13, 'Barry Gibb', '1946-09-01', 'AU');",
				"(14, 'Robin Gibb', '1949-12-22', 'AU');",
				"(15, 'Maurice Gibb', '1949-12-22', 'AU');",
				"(16, 'Siim Susi', '1976-01-01', 'EE');",
				"(17, 'Beata Kana', '1982-03-01', 'ZA');",
				"(18, 'José Mañana Perez', '1972-04-03', 'ES');",
				"(19, '??????? ??????', '1980-10-21', 'UA');",
				"(20, 'Siim Susi', '1976-01-01', 'EE');",
				"(21, 'Beata Kana', '1982-03-01', 'ZA');",
				"(22, 'José Mañana Perez', '1972-04-03', 'ES');",
				"(23, '??????? ??????', '1980-10-21', 'UA');",
				"(24, 'Siim Susi', '1976-01-01', 'EE');",
				"(25, 'Beata Kana', '1982-03-01', 'ZA');",
				"(26, 'José Mañana Perez', '1972-04-03', 'ES');",
				"(27, '??????? ??????', '1980-10-21', 'UA');",
				"(28, 'Siim Susi', '1976-01-01', 'EE');",
				"(29, 'Beata Kana', '1982-03-01', 'ZA');",
				"(30, 'José Mañana Perez', '1972-04-03', 'ES');",
				"(31, '??????? ??????', '1980-10-21', 'UA');",
				"(32, 'Siim Susi', '1976-01-01', 'EE');",
				"(33, 'Beata Kana', '1982-03-01', 'ZA');",
				"(34, 'José Mañana Perez', '1972-04-03', 'ES');",
				"(35, 'Василий Пупкин', '1980-10-21', 'UA');",
				"(36, 'Siim Susi', '1976-01-01', 'EE');",
				"(37, 'Siim Susi', '1976-01-01', 'EE');",
				"(38, 'Siim Susi', '1976-01-01', 'EE');",
				"(39, 'Siim Susi', '1976-01-01', 'EE');",
				"(40, 'Siim Susi', '1976-01-01', 'EE');",
				"(41, 'Beata Kana', '1982-03-01', 'ZA');",
				"(42, 'José Mañana Perez', '1972-04-03', 'ES');",
				"(43, 'Василий Пупкин', '1980-10-21', 'UA');",
		};
		executeInsertUsing(insertPart, athletes, statement);
	}

	private void createAthletesTable(Statement statement) throws SQLException {
		String sql = "CREATE TABLE athletes (" +
				"  id int NOT NULL PRIMARY KEY," +
				"  name varchar NOT NULL," +
				"  dob date NOT NULL," +
				"  country_code varchar NOT NULL" +
				");";
		statement.execute(sql);
	}
}

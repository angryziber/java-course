package net.azib.java.students.t073639.homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * DBControl class extends AthleteList.
 * <br>Instance of DBControl class has methods to read athletes for database.
 * <br>Database configuration is held in file "db.properties".
 * <br>All errors or correct result are displayed to User with console messages.
 * @author t073639
 * @see AthleteList
 */
public class DBControl extends AthleteList {

	/**
	 * <p>
	 * Create a new list of athletes from database.
	 * 
	 * @param string
	 *            - ID or Name of competition.
	 */
	public DBControl(String string) {
		this.connectAndGetAthleteList(string);
	}

	private void connectAndGetAthleteList(String string) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(DBControl.class.getResource("db.properties").getFile())).useDelimiter("\\,");
		}
		catch (FileNotFoundException e) {
			System.out.println("\t*Database connection:...ERROR:\tProblems with opening \"db.properties\"");
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(scanner.next().replaceAll(" ", ""), scanner.next().replaceAll(" ", ""), scanner
					.next().replaceAll(" ", ""));
			System.out.println("\t*Database connection:...OK");
			Scanner stringScanner = new Scanner(string);
			PreparedStatement statement = null;
			if (stringScanner.hasNext("\\d")) {
				statement = conn
						.prepareStatement("SELECT `athletes`.`name` , `athletes`.`dob` , `athletes`.`country_code` ,"
								+ "`results`.`race_100m` , `results`.`long_jump` , `results`.`shot_put` , "
								+ "`results`.`high_jump` , `results`.`race_400m` , `results`.`hurdles_110m` , "
								+ "`results`.`discus_throw` , `results`.`pole_vault` , `results`.`javelin_throw` ,"
								+ "`results`.`race_1500m` FROM athletes, results, competitions WHERE `competitions`.`id`=?"
								+ "AND `results`.`athlete_id` = `athletes`.`id`"
								+ "AND `results`.`competition_id` = `competitions`.`id`");
				statement.setString(1, string);
			}
			else {
				statement = conn
						.prepareStatement("SELECT `athletes`.`name` , `athletes`.`dob` , `athletes`.`country_code` ,+"
								+ "`results`.`race_100m` , `results`.`long_jump` , `results`.`shot_put` , "
								+ "`results`.`high_jump` , `results`.`race_400m` , `results`.`hurdles_110m` , "
								+ "`results`.`discus_throw` , `results`.`pole_vault` , `results`.`javelin_throw` ,"
								+ "`results`.`race_1500m` FROM athletes, results, competitions WHERE `competitions`.`name`=?"
								+ "AND `results`.`athlete_id` = `athletes`.`id`"
								+ "AND `results`.`competition_id` = `competitions`.`id`");
				statement.setString(1, string);
			}
			ResultSet rs = statement.executeQuery();
			int maxColumnIndex = statement.getMetaData().getColumnCount();
			while (rs.next()) {
				int columnIndex = 1;
				String s = "";
				while (columnIndex <= maxColumnIndex) {
					try {
						if (columnIndex == 1) {
							s = s + "\"" + rs.getString(columnIndex) + "\"";
						}
						else if (columnIndex == 2) {
							SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM,
									new Locale("ru"));
							Calendar c = Calendar.getInstance(new Locale("ru"));
							c.setTime(rs.getDate(columnIndex));
							s = s + "," + dateFormat.format(c.getTime());
						}
						else {
							s = s + "," + rs.getString(columnIndex);
						}
					}
					catch (SQLException e) {
						System.out.println("\t*" + s + "\tERROR in database:check value:\n" + "\t*" + e.toString());
						s = s + ",00.00.0000";
					}
					columnIndex++;
				}
				Pattern p = Pattern.compile("\"[\\D\\ ]+\"," + "[0-9]{1,2}\\.[0-9]{2}\\.[0-9]{4},[A-Z]{2}"
						+ "(,[0-9]{1,3}(\\.[0-9]{1,2})*){10}[\\s]*");
				Matcher m = p.matcher(s);
				if (m.find()) {
					this.addNewAthlete(s);
				}
			}
			this.sortAndSetPlaces();
		}
		catch (SQLException e1) {
			System.out.println("\t*Database connection:...ERROR:\tProblems establishing connection to database");
		}
		finally {
			try {
				if (conn != null)
					conn.close();
			}
			catch (SQLException e) {
				System.out.println("\t*Database connection:...ERROR:\tProblems closing connection to database");
			}
		}

	}

	/**
	 * <p>
	 * Create a new list of athletes, which is copy of parameter.
	 * 
	 * @param inputAthleteList
	 *            - List of athletes
	 */
	public DBControl(List<Athlete> inputAthleteList) {
		super(inputAthleteList);
	}
}

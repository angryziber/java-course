package net.azib.java.students.t010588.homework.importer;

/**
 * Constant used to load database properties and data from database
 *
 * @author Vjatseslav Rosin, 010588
 */
public interface DBConstants {

	public static final String DEFAULT_DB_PROP_FILE_NAME = "db.properties";

	public static final String URL_PROP = "url";

	public static final String LOGIN_PROP = "login";

	public static final String PASSWORD_PROP = "password";

	public static final String SELECT_SQL = "SELECT athletes.name, athletes.dob, athletes.country_code, "
			+ "results.race_100m, results.long_jump, results.shot_put, "
			+ "results.high_jump, results.race_400m, results.hurdles_110m, "
			+ "results.discus_throw, results.pole_vault, results.javelin_throw, results.race_1500m "
			+ "FROM athletes INNER JOIN results ON results.athlete_id = athletes.id "
			+ "INNER JOIN competitions ON results.competition_id = competitions.id "
			+ "WHERE competitions.id = ? OR competitions.name = ?";
}

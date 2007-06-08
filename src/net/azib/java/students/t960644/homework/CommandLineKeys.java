package net.azib.java.students.t960644.homework;

/**
 * CommandLineKeys
 *
 * Provides string constants for referring to the command line parameters of Decathlon.main 
 */
public class CommandLineKeys {
	/**
	 * connection string to input database: jdbc:driver://server:port/schema
	 */
	public static final String IN_DB = "in.db";
	/**
	 * Database driver class: com.mysql.jdbc.Driver (default) 
	 */
	public static final String IN_DB_DRIVER = "in.db.driver";
	/**
	 * User name for database
	 */
	public static final String IN_DB_USER = "in.db.user";
	/**
	 * Password for database
	 */
	public static final String IN_DB_PASS = "in.db.pass";
	/**
	 * Competition id in the database
	 */
	public static final String IN_DB_COMP_ID = "in.db.comp";
	/**
	 * Filepath for csv input
	 */
	public static final String IN_CSV = "in.csv";
	/**
	 * Filepath for csv output
	 */
	public static final String OUT_CSV = "out.csv";
	/**
	 * Filepath for xml output
	 */
	public static final String OUT_XML = "out.xml";
	/**
	 * 0 do not display console output
	 * 1 display console output (default)
	 */
	public static final String OUT_CONSOLE = "out.console";
}

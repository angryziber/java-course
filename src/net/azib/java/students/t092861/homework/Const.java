package net.azib.java.students.t092861.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Defined constants class.
 * 
 * @author Stanislav / 092861
 * 
 */
public class Const {
	
	/**
	 * Completely numeric date format, such as 12.13.52 or 3:30pm.
	 */
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yy");
		/*(SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);*/
	
	public static final String CMD_ERROR = "\nError! Not enought IO parameters. \nUsage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]";
	
	/**
	 * File.separator system property return the correct file separator for each
	 * different platform (Windows = \), (Linux = /).
	 */
	public static final String SEPARATOR = System.getProperty("file.separator");
	
//	public static final String USER_DIR = System.getProperty("user.dir") + SEPARATOR;

//	/**
//	 * Students package directory.
//	 */
//	public static final String PACKAGE = USER_DIR;

	/**
	 * Command line parameter for console.
	 */
	public static final String CONSOLE = "-console";
	/**
	 * Command line parameter for csv.
	 */
	public static final String CSV = "-csv";
	/**
	 * Command line parameter for db.
	 */
	public static final String DB = "-db";
	/**
	 * Command line parameter for xml.
	 */
	public static final String XML = "-xml";
	/**
	 * Command line parameter for html.
	 */
	public static final String HTML = "-html";

	public static final float SPRING_100_A = 25.4347F; // sec
	public static final float SPRING_100_B = 18F;
	public static final float SPRING_100_C = 1.81F;

	public static final float LONG_JUMP_A = 0.14354F; // cm
	public static final float LONG_JUMP_B = 220f;
	public static final float LONG_JUMP_C = 1.4f;

	public static final float SHOT_PUT_A = 51.39F; // m
	public static final float SHOT_PUT_B = 1.5F;
	public static final float SHOT_PUT_C = 1.05F;

	public static final float HIGH_JUMP_A = 0.8465F; // cm
	public static final float HIGH_JUMP_B = 75F;
	public static final float HIGH_JUMP_C = 1.42F;

	public static final float SPRING_400_A = 1.53775F; // sec
	public static final float SPRING_400_B = 82F;
	public static final float SPRING_400_C = 1.81F;

	public static final float HURDLES_A = 5.74352F; // sec
	public static final float HURDLES_B = 28.5F;
	public static final float HURDLES_C = 1.92F;

	public static final float DISCUS_THROW_A = 12.91F; // m
	public static final float DISCUS_THROW_B = 4F;
	public static final float DISCUS_THROW_C = 1.1F;

	public static final float POLE_VAULT_A = 0.2797F; // cm
	public static final float POLE_VAULT_B = 100F;
	public static final float POLE_VAULT_C = 1.35F;

	public static final float JAVELIN_THROW_A = 10.14F; // m
	public static final float JAVELIN_THROW_B = 7F;
	public static final float JAVELIN_THROW_C = 1.08F;

	public static final float RACE_A = 0.03768F; // sec
	public static final float RACE_B = 480F;
	public static final float RACE_C = 1.85F;
}

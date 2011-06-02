package net.azib.java.students.t100228.Homework;

/**
 * Helper class which contains enums representing input and output methods, and a time converter method
 * @author Martin
 */
public class Utils {
	public static enum enumInputMethod { INPUT_METHOD_CONSOLE, INPUT_METHOD_CSV, INPUT_METHOD_DB };
	public static enum enumOutputMethod { OUTPUT_METHOD_CONSOLE, OUTPUT_METHOD_CSV, OUTPUT_METHOD_XML,
		OUTPUT_METHOD_HTML}

	/**
	 * Converts time given in the format MM:SS into seconds
	 * @param timeInMinutes Time in minutes
	 * @return Time in seconds
	 */
	public static float minutesToSeconds(String timeInMinutes){
		String[] minutesAndSeconds = timeInMinutes.split(":");

		if(minutesAndSeconds.length > 1)
		{
			return new Float(minutesAndSeconds[0]) * 60 + new Float(minutesAndSeconds[1]);
		}
		else return new Float(minutesAndSeconds[0]);
	}
}

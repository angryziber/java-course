package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.DecathlonConstants;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * ConsoleOutput - class for outputting decathlon results to console
 *
 * @version 1.0
 * @author Romi Agar
 */
public class ConsoleOutput implements DataOutput{
	private static final Logger LOG = Logger.getLogger(ConsoleOutput.class.getSimpleName());

	private final PrintStream out;
	
	public ConsoleOutput() {
		this(System.out);
	}
	
	ConsoleOutput(PrintStream out){
		this.out = out;
	}
	
	/**
	 * Formats the results and outputs them to the console
	 * @param results a sorted list of athletes
	 * @param parameter not used for console output
	 */
	public void outputResults(List<Athlete> results, String... parameter){
		if (results == null){
			LOG.severe("No results given.");
			exit(11);
		} else {
			out.println("");
			out.println("The decathlon competition final results:");
			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
			
			int dateLength = ((SimpleDateFormat)df).toPattern().length()+1;
			int longestNameLength = (getLongestNameLength(results)>0)? getLongestNameLength(results) : 4;
			int positionFieldLength = Integer.toString(results.size()).length();
			int i = 1;
	
			List<String> tableHeader = new ArrayList<String>();
			tableHeader.add("#");
			tableHeader.add("Name");
			tableHeader.add("Score");
			tableHeader.add("Country");
			tableHeader.add("DOB");
			tableHeader.addAll(getEventNames());
			out.println(String.format(Locale.getDefault(), "%" + positionFieldLength + "s %-" + longestNameLength + "s %5s %7s %-" + dateLength + "s " + getEventNamesFormatString(), tableHeader.toArray()));
			for (Athlete a: results){
				String format = "%" + positionFieldLength + "d %-" + longestNameLength + "s %5d %5s   %" + dateLength + "s " + getEventsFormatString();
				out.println(String.format(Locale.getDefault(),format, getAthleteInfo(i,df,a)));
				i++;
			}
		}
	}

	/**
	 * Finds the length of the longest name in Athlete list
	 * @param results list of athletes
	 * @return length
	 */
	int getLongestNameLength(List<Athlete> results) {
		int len = 0;
		for (Athlete a: results)
			if (a.getName().length() > len)
				len = a.getName().length();
		return len;
	}

	/**
	 * @return returns the formatting string for event names
	 */
	String getEventNamesFormatString() {
		String str = "";
		for(int i=0; i<DecathlonConstants.values().length-1; i++)
			str += "%s | ";
		return str + "%s";
	}
	
	/**
	 * @return returns events formatting string
	 */
	String getEventsFormatString() {
		String str = "";
		for(int i=0; i<DecathlonConstants.values().length-1; i++)
			str += "%" + DecathlonConstants.getOrdinal(i).getName().length() + ".2f | ";
		return str + "%" + DecathlonConstants.getOrdinal(9).getName().length() + ".2f";
	}

	/**
	 * @return returns a list with all the event names
	 */
	List<String> getEventNames() {
		List<String> sl = new ArrayList<String>();
		for(int i=0; i<DecathlonConstants.values().length; i++)
			sl.add(DecathlonConstants.getOrdinal(i).getName());
		return sl;
	}
	
	/**
	 * @param position (int) place of the athlete in the final rank
	 * @param df DateFormat object for formatting date of birth
	 * @param athlete an athlete's object
	 * @return returns an object array with one athlete's information 
	 * in correct order for formatted output
	 */
	Object[] getAthleteInfo(int position, DateFormat df, Athlete athlete) {
		List<Object> lo = new ArrayList<Object>();
		lo.add(position);
		lo.add(athlete.getName());
		lo.add(athlete.getDecathlonPoints());
		lo.add(athlete.getCountryCode());
		lo.add(df.format(athlete.getBirthday()));
		for(int i=0; i<DecathlonConstants.values().length; i++)
			lo.add(athlete.getDecathlonResult(i));
		return lo.toArray();
	}
	
	void exit(int errorCode) {
		   System.exit(errorCode);
	}
}

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
	 * Formats the decathlon results and outputs them to console
	 * @param results a sorted list of athletes
	 * @param parameter not used for console output
	 */
	public void outputResults(List<Athlete> results, String... parameter){
		if (results == null){
			LOG.severe("Null parameter for athlete list");
			exit(9);
		} else {
			out.println("The decathlon competition final results:");
			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
			
			int dateLength = ((SimpleDateFormat)df).toPattern().length()+1;
			int longestNameLength = (getLongestNameLength(results)>0)? getLongestNameLength(results) : 4;
			int positionFieldLength = getPositionFieldLength(results);
			String place = "1";
			
			List<String> tableHeader = new ArrayList<String>();
			tableHeader.add("#");
			tableHeader.add("Name");
			tableHeader.add("Score");
			tableHeader.add("Country");
			tableHeader.add("DOB");
			tableHeader.addAll(getEventNames());
			out.println(String.format(Locale.US, "%" + positionFieldLength + "s %-" + longestNameLength + "s %5s %7s %-" + dateLength + "s " + getEventNamesFormatString(), tableHeader.toArray()));
			for (int i=0; i<results.size(); i++){
	        	Athlete a = results.get(i);
				if (i != 0 && results.get(i-1).getDecathlonPoints()>a.getDecathlonPoints() 
		        		&& i < results.size()-1 
		        		&& results.get(i+1).getDecathlonPoints()<a.getDecathlonPoints() 
		        		|| i == results.size()-1 && results.size() > 1
		        		&& results.get(i-1).getDecathlonPoints()>a.getDecathlonPoints())
		        	place = Integer.toString(i+1);
		        else if(i < results.size()-1 && results.get(i+1).getDecathlonPoints() == a.getDecathlonPoints())
		        	place = FileOutput.findPlaceSharers(results, i);
				String format = "%" + positionFieldLength + "s %-" + longestNameLength + "s %5d %5s   %" + dateLength + "s " + getEventsFormatString();
				out.println(String.format(Locale.US,format, getAthleteInfo(place,df,a)));
			}
		}
	}

	/**
	 * @param results a list of athletes
	 * @return returns the longest position combination length (comes in handy if places are shared)
	 */
	int getPositionFieldLength(List<Athlete> results) {
		boolean sharing = false;
		for (int i=0; i<results.size(); i++)
			if (i<results.size()-1 && results.get(i).getDecathlonPoints() == results.get(i+1).getDecathlonPoints()){
				sharing = true;
				break;
			}	
		return (sharing) ? 2*Integer.toString(results.size()).length()+1 : Integer.toString(results.size()).length();
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
			if (i==4)
				str += "%" + ((int)Math.ceil((double)(DecathlonConstants.getOrdinal(i).getName().length()-7)/2)+7) + "s%16$" + ((int)Math.floor((double)(DecathlonConstants.getOrdinal(i).getName().length()-7)/2)) + "s | ";
			else
				str += "%" + ((int)Math.ceil((double)(DecathlonConstants.getOrdinal(i).getName().length()-5)/2)+5) + ".2f%16$" + ((int)Math.floor((double)(DecathlonConstants.getOrdinal(i).getName().length()-5)/2)) + "s | ";
		return str + "%" + ((int)Math.ceil((double)(DecathlonConstants.getOrdinal(9).getName().length()-7)/2)+7) + "s";
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
	Object[] getAthleteInfo(String place, DateFormat df, Athlete athlete) {
		List<Object> lo = new ArrayList<Object>();
		if (place == null || df == null || athlete == null){
			LOG.severe("Null parameter(s) given for getAthleteInfo().");
			exit(10);
		}else{
			lo.add(place);
			lo.add(athlete.getName());
			lo.add(athlete.getDecathlonPoints());
			lo.add(athlete.getCountryCode());
			lo.add(df.format(athlete.getBirthday()));
			for(int i=0; i<DecathlonConstants.values().length; i++)
				if (i==4 || i==9)
					lo.add(InputParser.formatTime(athlete.getDecathlonResult(i)));
				else
					lo.add(athlete.getDecathlonResult(i));
			lo.add("");
		}
		return lo.toArray();
	}
	
	/**
	 * Exiting from program with given error code
	 * @param errorCode error code (int) for exiting
	 */
	void exit(int errorCode) {
		   System.exit(errorCode);
	}
}

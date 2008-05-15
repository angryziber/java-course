package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.DecathlonConstants;
import net.azib.java.students.t040719.homework.ISOCountry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ConsoleInput - a class for obtaining decathlon results from the user via console
 *
 * @version 1.0
 * @author Romi Agar
 */
public class ConsoleInput implements DataInput {
	private static final Logger LOG = Logger.getLogger(ConsoleInput.class.getSimpleName());
	
	static final String INVALID_NAME = " is not a valid name";
	static final String INVALID_DATE = " is not a valid date";
	static final String INVALID_COUNTRY = " is not a valid ISO 2-letter country code";
	static final String NOT_AN_INT = " is not integer";
	static final String NOT_A_FLOAT = " is not float";
	
	private final PrintStream out;
	private final BufferedReader input;
	
	public ConsoleInput() {
		this(new BufferedReader(new InputStreamReader(System.in)), System.out);
	}
	
	/**
	 * This constructor is for testing purpose
	 */
	ConsoleInput(BufferedReader input, PrintStream out){
		this.input = input;
		this.out = out;
	}
	
	/**
	 * @param parameters not implemented for console input
	 * @return returns a list of athletes
	 */
	public List<Athlete> getResults(String... parameters){
		Integer n = null;
		String line = "";
		out.print("How many athletes do you want to enter? ");
		do{
			try{
				n = Integer.parseInt(line = input.readLine());
			}catch (NumberFormatException e){
				out.println("'" + line + "'" + NOT_AN_INT);
				out.print("How many athletes do you want to enter? ");
			}
			catch (IOException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Could not read athlete count.", e);
				else
					LOG.log(Level.SEVERE, "Could not read athlete count.");
				System.exit(3);
			}
		}while(n == null);
		
		String name = "";
		String countryCode = "";
		Date birthday = null;
		float[] results = null;
		List<Athlete> athletes = new ArrayList<Athlete>();
		for (int i=0; i<n; i++){
			out.println((i+1) + ". athlete:");
			name = getName();
			birthday = getDOB();
			countryCode = getCountry();
			results = getDecathlonResults();
			Athlete athlete = new Athlete(name, birthday, countryCode, results);
			athletes.add(athlete);
		}
		out.println("Input complete.");
		return athletes;
	}

	/**
	 * @return returns an array of decathlon event results taken from console input
	 */
	float[] getDecathlonResults() {
		float[] results = new float[DecathlonConstants.values().length];
		Float n;
		String line = "";
		out.println("NB! All event marks should be entered using the format 0.00! (in SI units)");
		for (int i=0; i<results.length; i++){
			out.print(DecathlonConstants.getOrdinal(i).getName()+": ");
			n = null;
			do{
				try{
					n = Float.parseFloat(line = input.readLine());
				}catch (NumberFormatException e){
					out.println("'" + line + "'" + NOT_A_FLOAT);
					out.print(DecathlonConstants.getOrdinal(i).getName()+": ");
				}
				catch (IOException e) {
					if (System.getProperty("program.debug") != null)
						LOG.log(Level.WARNING, "Could not read decathlon result", e);
					else
						LOG.log(Level.WARNING, "Could not read decathlon result");
					return results;
				}				
			}while(n == null);
			results[i] = (float)((int)Math.round(n * 100)/100.0);
		}
		return results;
	}

	/**
	 * @return returns 2-letter country code taken from console input
	 */
	String getCountry() {
		out.print("Country (ISO 2-letter code): ");
		String line="";
		do{
			try {
				line = input.readLine().toUpperCase();
			}
			catch (IOException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.WARNING, "Could not read athlete country code", e);
				else
					LOG.log(Level.WARNING, "Could not read athlete country code");
				return "--";
			}
			if (!ISOCountry.isValidCountryCode(line)){
				out.println("'" + line + "'" + INVALID_COUNTRY);
				out.print("Country (ISO 2-letter code): ");
			}
		}while(!ISOCountry.isValidCountryCode(line));
		return line;
	}

	/**
	 * @return returns date of birth of athlete taken from console input
	 */
	Date getDOB() {
		Date dob = null;
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());
		df.setLenient(false);
		out.print("Date of birth (" + ((SimpleDateFormat)df).toPattern() + "): ");
		String line="";
		do{
			try {
				line = input.readLine();
				if (line != null)
					dob = df.parse(line);
				else{
					LOG.log(Level.WARNING, "Input for date of birth is NULL.");
					return new Date();
				}
			}
			catch (ParseException e){
				out.println("'" + line + "'" + INVALID_DATE);
				out.print("Date of birth (" + ((SimpleDateFormat)df).toPattern() + "): ");				
			}
			catch (IOException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.WARNING, "Could not read athlete' date of birth",e);
				else
					LOG.log(Level.WARNING, "Could not read athlete' date of birth");
				return new Date();
			}
		}while(dob == null);
		return dob;
	}

	/**
	 * @return returns athlete name taken from console input
	 */
	String getName() {
		String name = "";
		out.print("Name: ");
		do{
			try {
				name= input.readLine();
			}
			catch (IOException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.WARNING, "Could not read athlete name",e);
				else
					LOG.log(Level.WARNING, "Could not read athlete name");
				return "<no name>";
			}
			if (!InputParser.isValidName(name)){
				out.println("'" + name + "'" + INVALID_NAME);
				out.print("Name: ");
			}
		}while(!InputParser.isValidName(name));
		return name;
	}
	
}

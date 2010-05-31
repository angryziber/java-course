package net.azib.java.students.t073862.homework.model;

import net.azib.java.students.t073862.homework.util.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory; 
/**
 * InputData
 * This class handles input data parsing to ArrayList<Data>
 *
 * @author Pets
 */
public class InputManager {
	
	private static final Log logger = LogFactory.getLog(InputManager.class); 

	private String[] races = { "race_100m", "long_jump", "shot_put", "high_jump", "race_400m", "hurdles_110m", "discus_throw", "pole_vault", "javelin_throw", "race_1500m" };

	private DateFormat formatter2 = new SimpleDateFormat("dd.mm.yyyy");
	/**
	 * Loads input from the database
	 * @param option
	 * @return Formatted data in the format name, date of birth, country code, points 
	 */
	public Score[] loadInputFromDatabase(String option) {
		
		DatabaseConnection db = new DatabaseConnection();
		ResultSet resultset = null;
		try {
			int id = Integer.parseInt(option);
			/**
			 * If it's a number, this line is reached. If it\s not, an exception is thrown and this is never reached
			 */
			try {
				db.getLoadDataFromID().setInt(1, id);
				resultset = db.getLoadDataFromID().executeQuery();
			}
			catch (SQLException e) {
				logger.fatal(e);
				
			}

		}
		catch(NumberFormatException e) {
			/**
			 * If it's not a number (e.g. name), exception is thrown and this line is reached.
			 */
			try {
				db.getLoadDataFromID().setString(1, option);
				resultset = db.getLoadDataFromName().executeQuery();
			}
			catch (SQLException e1) {
				logger.fatal("Error in SQL",e);
			}
			
		}
		ArrayList<Score> scores = new ArrayList<Score>();
		try {
			while(resultset.next()) {
				Date date = null;
				try {
					date = resultset.getDate("dob");
				}
				catch(Exception e) {
					date = new Date(0);
				}
			    Double[] scoreData = new Double[races.length];
				for(int i = 0; i < races.length; i++) {
					scoreData[i] = resultset.getDouble(races[i]);
				}

				scores.add(new Score(resultset.getString("name"),date.toString() ,resultset.getString("country_code"),scoreData));
			}
		}
		catch (SQLException e) {
			logger.error("Error in SQL",e);
		}
		return scores.toArray(new Score[]{});
	}
	/**
	 * Loads input from the CSV file
	 * @param option
	 * @return Formatted data in the format name, date of birth, country code, points 
	 */
	public Score[] loadInputFromCSV(File f) {
		ArrayList<Score> scores = new ArrayList<Score>();
		BufferedReader reader;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(f));
			while ((line = reader.readLine()) != null) {
		        StringTokenizer tokenizer = new StringTokenizer(line, ",");
		        int i = 0;
		        String name = null;
		        String iso = null;
		        Date date = null;
		        Double[] scoreData = new Double[races.length];
				
		        while (tokenizer.hasMoreTokens()) {
		        	if(i == 0) {
		        		name = tokenizer.nextToken();
		        		name = name.trim().trim();
		        		name = name.substring(1,name.length()-1);
		        	}
		            else if(i == 1) {
		            	try {
		                	date = (Date)formatter2.parse(tokenizer.nextToken());
		                }
		                catch (ParseException e) {
		                	logger.fatal("Error in CSV file",e);
		                
		                }
		            }
		            else if(i == 2) {
		            	iso = tokenizer.nextToken();
		            }
		            
		            else {
		                try {
		                	Double fx = 0D;

		                	if(i == 7 || i == 12) {
		                		String token = tokenizer.nextToken().trim();
		                		try {
		                		fx = Double.parseDouble(token);
		                		}
		                		catch(NumberFormatException e) {
			    					fx = parseMinutesToSeconds(token);

		                		}
		                		

		                	}
		                	else {
		                		fx = Double.parseDouble(tokenizer.nextToken());
		                	}
			            	scoreData[i-3] = fx;
		                }
		                catch(NumberFormatException e) {
		                	logger.fatal("Error in CSV file",e);
		                
		                }
		            
		            }
		        	i++;
		        }
		        scores.add(new Score(name,date.toString() ,iso ,scoreData));
			
			}
		}
		catch(Exception e) {
			logger.fatal("Error in CSV file",e);
		}
		return scores.toArray(new Score[]{});
	}
	
	private Double parseMinutesToSeconds(String s) throws NumberFormatException {
		String data[] = s.split(":");
		return Double.valueOf(data[0])*60+Float.valueOf(data[1]);
	}
	
	/**
	 * Loads input from the console
	 * @param option
	 * @return Formatted data in the format name, date of birth, country code, points 
	 */
	public Score[] loadInputFromConsole() {
		ArrayList<Score> scores = new ArrayList<Score>();
		scores = consoleActon(scores);
				
		return scores.toArray(new Score[]{});
	}
	private SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
	private ArrayList<Score> consoleActon(ArrayList<Score> scores) {
		Scanner scanner = new Scanner(System.in);
		
		String name = null;
		try {
			System.out.println("Enter name(empty to exit):");
			name = scanner.nextLine();
		} 
		catch(IllegalArgumentException e){
			return scores;
		}
		Date date = null;
		while(date == null){
			try{
				System.out.println("Enter birthday in the following format: ("+format.toPattern()+")");
				date =  format.parse(scanner.nextLine());
			} 
			catch(ParseException e){ }
		}
		Pattern isoPattern = Pattern.compile("[A-Z]{2,3}");
		
		scanner = new Scanner(System.in);
		System.out.println("");
		String iso = null;
		while(iso == null) {
			try {
				iso = scanner.next(isoPattern);
			}
			catch(InputMismatchException e) {	}
		}
		Double[] scoreData = new Double[races.length];
	
		for(int i = 0; i < races.length; i++) {
			scoreData[i]  = Util.getDouble("Please enter results for: " + races[i]);
		}
		scores.add(new Score(name,date.toString() ,iso, scoreData));
		return consoleActon(scores);
	}
}

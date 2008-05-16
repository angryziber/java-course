package net.azib.java.students.t001370.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonOutputCSV
 *
 * @author maksim
 */
public class DecathlonOutputCSV extends DecathlonOutput{
	
	private static final Logger LOG = Logger.getLogger(DecathlonOutputCSV.class.getName());

	private final PrintStream output;

	/**
	 * Class constructor
	 */
	DecathlonOutputCSV(){
		LOG.log(Level.INFO, "DecathlonOutputCSV created");
		this.output = System.out;
	}
	
	/**
	 * Class constructor mainly used for unit testing
	 * @param out - output stream
	 */
	DecathlonOutputCSV(PrintStream out){
		this.output = out;
	}
	
	/**
	 * Compiles CSV line
	 * @param place - athlete's place in competition
	 * @param athlete - athlete which data will be compiled
	 * @return compiled CSV string
	 */
	private String compileCSVLine(int place, Athlete athlete){
		String compiledString = null;
		
		compiledString = Integer.toString(place) 												+ "," +
							Integer.toString(athlete.competitionResults.getTotalScore()) 		+ "," +
							"\"" + athlete.getName() + "\"" 									+ "," +
							((SimpleDateFormat)DateFormat.getDateInstance(DateFormat.MEDIUM)).
								format(athlete.getBirthday()) 									+ "," +
							athlete.getCountryCode() 											+ "," +
							Float.toString(athlete.competitionResults.getResult100mRace()) 		+ "," +
							Float.toString(athlete.competitionResults.getResultLongJump()) 		+ "," +
							Float.toString(athlete.competitionResults.getResultShotPut()) 		+ "," +
							Float.toString(athlete.competitionResults.getResultHighJump()) 		+ "," +
							Float.toString(athlete.competitionResults.getResult400mSprint()) 	+ "," +
							Float.toString(athlete.competitionResults.getResult110mHurdles()) 	+ "," +
							Float.toString(athlete.competitionResults.getResultDiscusThrow()) 	+ "," +
							Float.toString(athlete.competitionResults.getResultPoleVault()) 	+ "," +
							Float.toString(athlete.competitionResults.getResultJavelinThrow()) 	+ "," +
							Float.toString(athlete.competitionResults.getResult1500mRace());
		
		System.out.println(
				Integer.toString((int)(athlete.competitionResults.getResult1500mRace()%60)) + ":" +
				Float.toString(athlete.competitionResults.getResult1500mRace() - (int)(athlete.competitionResults.getResult1500mRace()%60)));
				
		LOG.log(Level.INFO, compiledString);
		return compiledString;
	}
	
	@Override
	public void writeData(Collection<Athlete> competitors, File outputFile) {
		BufferedWriter writer = null;
		
		try{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
			
			
			int prevAthleteTotal = 0;
			int prevAthletePlace = 0;
			int i = 1;
			
			for (Athlete athlete : competitors) {
				int currAthleteTotal = athlete.competitionResults.getTotalScore();
				int athletesPlace = calculateCompatetorPlace(
										i++, prevAthletePlace, prevAthleteTotal, currAthleteTotal);
				
				writer.write(compileCSVLine(athletesPlace, athlete));
				writer.newLine();
				
				prevAthletePlace = athletesPlace;
				prevAthleteTotal = currAthleteTotal;
			}
			
			LOG.log(Level.INFO, "writer flushed");
			writer.flush();
			
		}
		catch (Exception e){
			output.println(Errors.ERROR_0006.getErrorText() + outputFile +  "'!");
			
			LOG.log(Level.INFO, "Error! Problems reading CSV file='" + outputFile +  "'!" + e.getMessage());
			System.exit(1);
		}
		finally{
			try {
				if (writer != null){
					writer.close();
				}
			}
			catch (IOException e) {
				output.println(Errors.ERROR_0005.getErrorText());
				
				LOG.log(Level.INFO, "Error! Problems closing file write" + e.getMessage());
				System.exit(1);
			}
		}
		
	}
	
}

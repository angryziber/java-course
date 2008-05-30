package net.azib.java.students.t001370.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonOutputCSV
 * Class for writing decathlon competition data to CSV file
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
	 * @param out - output stream for user interaction
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
	 String compileCSVLine(String place, Athlete athlete){
		String compiledString = null;
		
		compiledString = place 																	+ "," +
							Integer.toString(athlete.competitionResults.getTotalScore()) 		+ "," +
							"\"" + athlete.getName() + "\"" 									+ "," +
							//((SimpleDateFormat)DateFormat.getDateInstance(DateFormat.MEDIUM)).
							new SimpleDateFormat("dd.MM.yyyy").format(athlete.getBirthday()) 									+ "," +
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
		
		LOG.log(Level.INFO, compiledString);
		return compiledString;
	}
	
	@Override
	public void writeData(Collection<Athlete> competitors, File outputFile) throws DecathlonException {
		BufferedWriter writer = null;
		
		try{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
			
			//write athlete results to csv file
			int athleteCount = 1;
			for (Athlete athlete : competitors) {
				
				writer.write(compileCSVLine(calculateCompatetorPlace(athleteCount++, competitors), athlete));
				writer.newLine();
			}
			
			LOG.log(Level.INFO, "writer flushed");
			writer.flush();
			
		}
		catch (Exception e){
			output.println(Errors.ERROR_PROBLEMS_READING_CSV.getErrorText() + outputFile +  "'!");
			
			LOG.log(Level.INFO, Errors.ERROR_PROBLEMS_READING_CSV.getErrorText() + outputFile +  "'!" + e.getMessage());

			throw new DecathlonException();
		}
		finally{
			try {
				if (writer != null){
					writer.close();
				}
			}
			catch (IOException e) {
				output.println(Errors.ERROR_PROBLEMS_CLOSING_FILE.getErrorText());
				
				LOG.log(Level.INFO, Errors.ERROR_PROBLEMS_CLOSING_FILE.getErrorText() + e.getMessage());
			}
		}
	}
}

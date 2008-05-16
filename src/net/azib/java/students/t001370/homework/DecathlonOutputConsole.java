package net.azib.java.students.t001370.homework;

import java.io.File;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonOutoutConsole
 *
 * @author maksim
 */
public class DecathlonOutputConsole extends DecathlonOutput{
	private static final Logger LOG = Logger.getLogger(DecathlonOutputConsole.class.getName());

	private final PrintStream output;

	DecathlonOutputConsole(){
		this.output = System.out;
	}
	
	DecathlonOutputConsole(PrintStream out){
		this.output = out;
	}

	
	
	/**
	 * Prints table separator to output specified by calling class constructor
	 * @param longestNameLen - for formating name column
	 */
	private void printTableSeparator(int longestNameLen){
		
		output.print("+-----+-----------+");
		for (int i = 0; i < longestNameLen; i++) {
			output.print("-");
		}
		output.print("+----------+------+-----------+---------+--------+---------+-----------+------------+------------+----------+-------------+----------+\n");
	}
	
	/**
	 * Prints table heading to output specified by calling class construtor
	 * @param longestNameLen - for formating name column
	 */
	private void printTableHeading(int longestNameLen){
		output.print("|Place|Total Score|Name");
		for (int i = 0; i < (longestNameLen - "Name".length()); i++) {
			output.print(" ");
		}
		output.print("|Birthday  |Coutry|Sprint 100m|Long Jump|Shot Put|High Jump|Sprint 400m|Hurdles 110m|Discus Throw|Pole Vault|Javelin Throw|Race 1500m|\n");
	}
	
	/**
	 * Print athlete information as a table to output specified by calling class constructor
	 * @param athlete - athlete to print
	 * @param place - giving athlete place 
	 * @param longestNameLen - for formating name column
	 */
	private void printAthleteResults(Athlete athlete, int place, int longestNameLen){
		String tempStr = null;
		NumberFormat nf = new DecimalFormat("#0.00");
		
		//print place
		tempStr = "" + place;
		output.print("|" + tempStr);
		for (int i = 0; i < (5 - tempStr.length()); i++) {
			output.print(" ");
		}
		
		//print total score
		tempStr = "" + athlete.competitionResults.getTotalScore();
		output.print("|" + tempStr);
		for (int i = 0; i < (11 - tempStr.length()); i++) {
			output.print(" ");
		}
		
		//print name
		tempStr = "" + athlete.getName();
		output.print("|" + tempStr);
		for (int i = 0; i < (longestNameLen - tempStr.length()); i++) {
			output.print(" ");
		}
		
		//print birthday
		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
		tempStr = "" + ((SimpleDateFormat)df).format(athlete.getBirthday());
		output.print("|" + tempStr);
		for (int i = 0; i < (10 - tempStr.length()); i++) {
			output.print(" ");
		}

		
		//print country code
		tempStr = "" + athlete.getCountryCode();
		output.print("|" + tempStr);
		for (int i = 0; i < (6 - tempStr.length()); i++) {
			output.print(" ");
		}
		
		//print 100m sprint
		tempStr = "" + nf.format(athlete.competitionResults.getResult100mRace())/* + 
					" (" + DecathlonFormulaArguments.RUNNING_EVENT_100M_IN_SEC.
							getRunningEventResult(athlete.competitionResults.getResult100mRace()) + ")"*/;
		output.print("|" + tempStr);
		for (int i = 0; i < (11 - tempStr.length()); i++) {
			output.print(" ");
		}

		//print Long Jump 
		tempStr = "" + nf.format(athlete.competitionResults.getResultLongJump()) /*+ 
					" (" + DecathlonFormulaArguments.FIELD_EVENT_LONG_JUMP_IN_M.
							getFieldEventResult(athlete.competitionResults.getResultLongJump()) + ")"*/;
		output.print("|" + tempStr);
		for (int i = 0; i < (9 - tempStr.length()); i++) {
			output.print(" ");
		}
		
		//Shot Put
		tempStr = "" + nf.format(athlete.competitionResults.getResultShotPut());
		output.print("|" + tempStr);
		for (int i = 0; i < (8 - tempStr.length()); i++) {
			output.print(" ");
		}

		//High Jump
		tempStr = "" + nf.format(athlete.competitionResults.getResultHighJump());
		output.print("|" + tempStr);
		for (int i = 0; i < (9 - tempStr.length()); i++) {
			output.print(" ");
		}

		//Sprint 400m
		tempStr = "" + nf.format(athlete.competitionResults.getResult400mSprint());
		output.print("|" + tempStr);
		for (int i = 0; i < (11 - tempStr.length()); i++) {
			output.print(" ");
		}

		//Hurdles 110m
		tempStr = "" + nf.format(athlete.competitionResults.getResult110mHurdles());
		output.print("|" + tempStr);
		for (int i = 0; i < (12 - tempStr.length()); i++) {
			output.print(" ");
		}

		//Discus Throw
		tempStr = "" + nf.format(athlete.competitionResults.getResultDiscusThrow());
		output.print("|" + tempStr);
		for (int i = 0; i < (12 - tempStr.length()); i++) {
			output.print(" ");
		}

		//Pole Vault
		tempStr = "" + nf.format(athlete.competitionResults.getResultPoleVault());
		output.print("|" + tempStr);
		for (int i = 0; i < (10 - tempStr.length()); i++) {
			output.print(" ");
		}

		//Javelin Throw
		tempStr = "" + nf.format(athlete.competitionResults.getResultJavelinThrow());
		output.print("|" + tempStr);
		for (int i = 0; i < (13 - tempStr.length()); i++) {
			output.print(" ");
		}

		//Race 1500m
		tempStr = "" + nf.format(athlete.competitionResults.getResult1500mRace());
		output.print("|" + tempStr);
		for (int i = 0; i < (10 - tempStr.length()); i++) {
			output.print(" ");
		}
		output.print("|\n");
	}
	
	
	@Override
	public void writeData(Collection<Athlete> competitors, File outputFile) {
		LOG.log(Level.INFO, "write data to console entered");

		int longestNameLenght = "Name".length();
		
		//find out the longest name length
		for (Athlete athlete : competitors) {
			if (longestNameLenght < athlete.getName().length()) {
				longestNameLenght = athlete.getName().length();
			}
		}
		
		//print table borders
		printTableSeparator(longestNameLenght);
		printTableHeading(longestNameLenght);
		printTableSeparator(longestNameLenght);
		
		//print athlete result as table
		int prevAthleteTotal = 0;
		int prevAthletePlace = 0;
		int place = 1;
		for (Athlete athlete : competitors) {
			int currAthleteTotal = athlete.competitionResults.getTotalScore();
			int atheltesPlace = calculateCompatetorPlace(
										place++, prevAthletePlace, prevAthleteTotal, currAthleteTotal);

			printAthleteResults(athlete, atheltesPlace, longestNameLenght);
		
			prevAthletePlace = atheltesPlace;
			prevAthleteTotal = currAthleteTotal;
		}
		
		//print table border
		printTableSeparator(longestNameLenght);
	}

}

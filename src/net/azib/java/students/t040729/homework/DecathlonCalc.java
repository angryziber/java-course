package net.azib.java.students.t040729.homework;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * DecathlonCalc - inputs competition data, calculates points
 * and outputs data. User can choose where from and where to.
 * <p>
 * For input:<p>
 * <ul>
 * <li>-console - data are typed in manually
 * <li>-csv [filename] - given file is read for data
 * <li>-db [id|name] - data are taken from database 
 * </ul>
 * <p>
 * For output:<p>
 * <ul>
 * <li>-conole - results are printed on screen
 * <li>-csv [filename]- results are written into CSV file
 * <li>-xml [filename] - results are written into XML file
 * <li>-html [filename] - results are written into HTML file
 *</ul>
 * @author ValleTon
 */
public class DecathlonCalc {
	
	/**
	 * @param athletesList List of athletes to be processed
	 * @param input Interface to data input implementation
	 * @param output Interface to data output implementation
	 * @throws Exception Any problems during processing are thrown out
	 * @return List of athletes (for testing)
	 */
	public static List<Athlete> processCompetitionData(List<Athlete> athletesList, CompetitionDataIn input, CompetitionDataOut output) throws Exception{
		
		athletesList = input.getCompetitionData();
		
		if (athletesList.isEmpty()){
			throw new Exception("Athletes' list is empty, nothing to do.");
		}
		
		for (Athlete a : athletesList){
			a.calculateTotalPoints();
		}
		
		Collections.sort(athletesList);
		
		computePlaces(athletesList);
		
		output.putCompetitionData(athletesList);
		
		return athletesList;
	}

	/**
	 * Computes places for each competitor
	 * @param athletesList List of athletes
	 */
	private static void computePlaces(List<Athlete> athletesList) {
		String place = null;
		int athleteIndex = 0;
		int lastAthleteIndexWidthSamePoints = 0;
		boolean hasSameScore = false;
		ListIterator<Athlete> it;
		
		for (Athlete a : athletesList){
			if (!hasSameScore){
				lastAthleteIndexWidthSamePoints = athleteIndex;
				it = athletesList.listIterator(athleteIndex);
				if (it.hasNext()){
					it.next();
				}
				while (it.hasNext() && it.next().getTotalPoints()==a.getTotalPoints()){
					lastAthleteIndexWidthSamePoints++;
					hasSameScore = true;
				}

				if (athleteIndex != lastAthleteIndexWidthSamePoints){
					place = String.valueOf(athleteIndex+1)+"-"+String.valueOf(lastAthleteIndexWidthSamePoints+1);
				}else{
					place = String.valueOf(athleteIndex+1);
				}
			}
			if (lastAthleteIndexWidthSamePoints == athleteIndex){
				hasSameScore = false;
			}
			a.setPlace(place);
			athleteIndex++;
		}
	}
	
	/**
	 * @param args Command line parameters which determine
	 * input and output modes for the application
	 */
	public static void main(String[] args) {
		
		InputOutputProvider iop = null;
		try {
			iop = new InputOutputProvider(args);
		}
		catch (Exception e1) {
			terminateApp(e1.getMessage());
		}
		
		CompetitionDataIn input = iop.getInput();
		CompetitionDataOut output = iop.getOutput();
		
		List<Athlete> athletesList = null;
		try {
			athletesList = processCompetitionData(athletesList, input, output);
			System.out.println("\nCompetition data processing successful!");
			System.exit(0);
		}
		catch (Exception e) {
			terminateApp(e.getMessage());
		}
	}
	
	private static void terminateApp(String msg){
		System.out.println("There were problems:\n"+msg);
		System.out.println("\nApplication terminated.");
		System.exit(1);
	}
}

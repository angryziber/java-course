package net.azib.java.students.t030636.homework;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;


/**
 * PointsForObjects
 * 
 * This class is for calculating points for a decathlon competition 
 *
 * @author Martin
 */
public class PointsForObjects {

	/**
	 * This method will calculate decathlon results and put the athletes in the correct order.
	 * Input is a String array, where every string is one competitors competition data. The string format:
	 * "[Name]",[date-of-birth],[ISO country code],[100m],[longjump],...and so on for all 10 events. 
	 * All results in the format [m.cm] or [min:sec] - leaving out the minute if under 60 sec.
	 * The method returns a sorted ArrayList of Competitors. 
	 * @param inputAsString - String array where there is one string for every competitior and the strings mus be in 
	 * the predefined format.
	 * 
	 */
	public ArrayList<Competitor> calculatePoints(String [] inputAsStrings) {
		
		ArrayList <Competitor> competitors = new ArrayList<Competitor>(); 

		for(String inText: inputAsStrings) {
			Competitor decathlete = new Competitor();			
			String [] resultsAsText = inText.split(",");
			String [] minutesAndSeconds = null;
			double [] resultsAsDouble = new double[10]; 
			for (int i = 0; i < 10; i++)  {
				if (i == 0 | i == 2 | i == 5 | i ==6 | i ==8) {
					try{
						resultsAsDouble[i] =  Double.parseDouble(resultsAsText[i + 3]);
						decathlete.results[i] = resultsAsText[i + 3];
					}
					catch (ArrayIndexOutOfBoundsException e){
						System.out.println("Errorneous data");
						System.exit(0);
					}
				}
				else if ( i == 1 | i == 3 | i ==7) {
					try {	
						resultsAsDouble[i] = Double.parseDouble(resultsAsText[i + 3])*100;
						decathlete.results[i] = resultsAsText[i + 3];
					}
					catch (ArrayIndexOutOfBoundsException e){
						System.out.println("Errorneous data");
						System.exit(0);
					}
				}
				else if (i == 4 | i == 9) {
					try {
						minutesAndSeconds = resultsAsText[i + 3].split(":");
						decathlete.results[i] = resultsAsText[i + 3];
					}
					catch (ArrayIndexOutOfBoundsException e){
						System.out.println("Errorneous data");
						System.exit(0);
					}					
					try {
						resultsAsDouble[i] = Double.parseDouble(minutesAndSeconds[0])*60 + Double.parseDouble(minutesAndSeconds[1]);
					}
					catch (ArrayIndexOutOfBoundsException e) {
						resultsAsDouble[i] = Double.parseDouble(minutesAndSeconds[0]);
					}
					finally {	
						
					}
				}
			}
			Locale l = new Locale("",resultsAsText[2]);
	        decathlete.nationality = l.getDisplayCountry();
	        
			int finalPointsScore = 0;
			int count= 0;
			
			for (Event event: Event.values()){
				finalPointsScore = finalPointsScore + event.returnPointsForTheEvent(resultsAsDouble[event.ordinal()]);
				decathlete.resultsAsPoints[count] = event.returnPointsForTheEvent(resultsAsDouble[event.ordinal()]);
				count++;
			}
			decathlete.score = finalPointsScore;
			decathlete.name = resultsAsText[0];
			decathlete.born = resultsAsText[1];
			competitors.add(decathlete);
		}
		Collections.sort(competitors);
		return competitors;
	}
}

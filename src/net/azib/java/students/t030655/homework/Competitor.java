package net.azib.java.students.t030655.homework;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Competitor
 *
 * @author Triin Nestor
 */
public class Competitor implements Comparable<Competitor> {
	private String info;	//all data in a string (CSV)
	private String place = "";
	private String name;
	private String dateOfBirth;
	private String country;
	private double[] results = new double[10];
	private int totalPoints;
	
	/**
	 * Method sets competitor's name, date of birth, country, results and total points from 
	 * input string.
	 * 
	 * @param string - CSV string containing name, date of birth, country and results
	 */
	public void setCompetitor (String string){
		String[] masInfo = string.split(",");
		name = masInfo[0];
		dateOfBirth = masInfo[1];
		country = masInfo[2];
		//putting results into array of doubles
		for (int i=3; i < masInfo.length; i++){
			//if the result is in time format with minutes
			if ((i==7 || i==12) && (masInfo[i].indexOf(":")>0)){
				String[] masTimeInfo = masInfo[i].split(":");
				NumberFormat nf = NumberFormat.getInstance(Locale.US);
				Number number1 = 0;
				try {
					number1 = nf.parse(masTimeInfo[0]);
				}
				catch (ParseException e) {
					System.out.println("Parsing failed!");
					e.printStackTrace();
				}
				Number number2 = 0;
				try {
					number2 = nf.parse(masTimeInfo[1]);
				}
				catch (ParseException e) {
					System.out.println("Parsing failed!");
					e.printStackTrace();
				}
				results[i-3]= 60.00*(number1.doubleValue()) + number2.doubleValue();
			}
			//if the result is in meters or in seconds
			else {
				NumberFormat nf = NumberFormat.getInstance(Locale.US);
				Number number = 0;
				try {
					number = nf.parse(masInfo[i]);
				}
				catch (ParseException e) {
					System.out.println("Parsing failed!");
					e.printStackTrace();
				}
				results[i-3] = number.doubleValue();
			}
		}
		totalPoints = pointsCalculation();
	}
	
	/**
	 * Method calculates points of competitor
	 * 
	 * @return Total points of competitor
	 */
	private int pointsCalculation (){
		DecathlonPoints points = new DecathlonPoints();
		
		points.setSprint100m(results[0]);
		points.setLongJump(results[1]);
		points.setShotPut(results[2]);
		points.setHighJump(results[3]);
		points.setSprint400m(results[4]);
		points.setHurdles110m(results[5]);
		points.setDiscusThrow(results[6]);
		points.setPoleVault(results[7]);
		points.setJavelinThrow(results[8]);
		points.setRace1500m(results[9]);
		
		return points.totalPoints();
	}
	
	/**
	 * Sets competitor's place
	 * 
	 * @param position - place string
	 */
	public void setPlace (String position){
		place = position;
	}
	
	/**
	 * Gets competitor's name
	 * 
	 * @return Competitor's name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Gets competitor's date of birth
	 * 
	 * @return Competitor's date of birth
	 */
	public String getDateOfBirth(){
		return dateOfBirth;
	}
	
	/**
	 * Gets competitor's country
	 * 
	 * @return Competitor's country
	 */
	public String getCountry(){
		return country;
	}
	
	/**
	 * Gets competitor's results of decathlon events
	 * 
	 * @return Competitor's results of decathlon events
	 */
	public double[] getResults(){
		return results;
	}
	
	/**
	 * Gets competitor's total points of decathlon
	 * 
	 * @return Competitor's total points
	 */
	public int getTotalPoints(){
		return totalPoints;
	}
	
	/**
	 * Gets competitor's place
	 * 
	 * @return Competitor's place
	 */
	public String getPlace(){
		return place;
	}
	
	/**
	 * Gets competitor's data as one string
	 * 
	 * @return Competitor's data string
	 */
	public String getString (){
		info = place + totalPoints + "," + name + "," + dateOfBirth + "," + country;
		for (int i=0; i<10; i++){
			info = info + "," + results[i];
		}		
		return info;
	}
	
	/**
	 * Compares competitor with another competitor accoring to total points
	 * 
	 * @param competitor - competitor to compare to
	 * @return Returns 1, when competitor's total points higher than parameter's and -1, 
	 * when reverse. 0 is returned, when total points are equal.
	 */
	public int compareTo (Competitor competitor){		
		int value = totalPoints - competitor.getTotalPoints();
		if (value < 0)
			return 1;
		else if (value > 0)
			return -1;
		else
			return 0;
	}
	
}

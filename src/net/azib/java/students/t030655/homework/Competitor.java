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
	private String info;
	private String place = "";
	private String name;
	private String dateOfBirth;
	private String country;
	private double[] results = new double[10];
	private int totalPoints;
	
	/**Sets competitor's name, date of birth, country, results and total points from input string.
	 * 
	 * @param string - CSV string containing name, date of birth, country and results
	 */
	public void setCompetitor (String string){
		String[] masInfo = string.split(",");
//		for (int l=0; l<13; l++){
//			System.out.println(masInfo[l]);
//		}
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Number number2 = 0;
				try {
					number2 = nf.parse(masTimeInfo[1]);
				}
				catch (ParseException e) {
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				results[i-3] = number.doubleValue();
			}
		}
		totalPoints = pointsCalculation();
	}
	
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
	
	public void setPlace (String position){
		place = position;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDateOfBirth(){
		return dateOfBirth;
	}
	
	public String getCountry(){
		return country;
	}
	
	public double[] getResults(){
		return results;
	}
	
	public int getTotalPoints(){
		return totalPoints;
	}
	
	public String getPlace(){
		return place;
	}
	
	public String getString (){
		info = place + "," + totalPoints + "," + name + "," + dateOfBirth + "," + country;
		for (int i=0; i<10; i++){
			info = info + "," + results[i];
		}		
		return info;
	}
	
	public int compareTo (Competitor competitor){
		if(competitor == null)
			return -1;
		
		int value = totalPoints - competitor.getTotalPoints();
		
		if (value < 0)
			return 1;
		else if (value > 0)
			return -1;
		else
			return 0;
	}
	
}

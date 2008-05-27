package net.azib.java.students.t020281.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Sportsman
 *
 * @author Trial
 */
    /**
     * Sportsman
     *
     * @author Trial
     */
    public class Sportsman implements Comparable<Object> {
	
    private String name;
	private String birthDate;
	private String country;
	private Double sprint100mEvent;
	private Double longJumpEvent;
	private Double shotPutEvent;
	private Double highJumpEvent;
	private Double sprint400mEvent;
	private Double hurdles110mEvent;
	private Double discusThrowEvent;
	private Double poleVaultEvent;
	private Double javelinThrowEvent;
	private Double race1500mEvent;
	private Double points;

	
	public String toString(){
		
		StringBuilder builder = new StringBuilder();
		builder.append("\"").append(name).append("\",").append(birthDate).append(",");
		builder.append(country).append(",").append(sprint100mEvent).append(",");
		builder.append(longJumpEvent).append(",").append(shotPutEvent).append(",");
		builder.append(highJumpEvent).append(",").append(sprint400mEvent).append(",");
		builder.append(hurdles110mEvent).append(",").append(discusThrowEvent).append(",");
		builder.append(poleVaultEvent).append(",").append(javelinThrowEvent).append(",");
		builder.append(race1500mEvent).append(",").append(points);
		return builder.toString();
		
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the sprint100mEvent
	 */
	public Double getSprint100mEvent() {
		return sprint100mEvent;
	}

	/**
	 * @return the longJumpEvent
	 */
	public Double getLongJumpEvent() {
		return longJumpEvent;
	}

	/**
	 * @return the shotPutEvent
	 */
	public Double getShotPutEvent() {
		return shotPutEvent;
	}

	/**
	 * @return the highJumpEvent
	 */
	public Double getHighJumpEvent() {
		return highJumpEvent;
	}

	/**
	 * @return the sprint400mEvent
	 */
	public Double getSprint400mEvent() {
		return sprint400mEvent;
	}

	/**
	 * @return the hurdles110mEvent
	 */
	public Double getHurdles110mEvent() {
		return hurdles110mEvent;
	}

	/**
	 * @return the discusThrowEvent
	 */
	public Double getDiscusThrowEvent() {
		return discusThrowEvent;
	}

	/**
	 * @return the poleVaultEvent
	 */
	public Double getPoleVaultEvent() {
		return poleVaultEvent;
	}

	/**
	 * @return the javelinThrowEvent
	 */
	public Double getJavelinThrowEvent() {
		return javelinThrowEvent;
	}

	/**
	 * @return the race1500mEvent
	 */
	public Double getRace1500mEvent() {
		return race1500mEvent;
	}

	/**
	 * @return the points
	 */
	public Double getPoints() {
		return points;
	}

	public Sportsman(){
	}
	
	public Sportsman(String results) {
//		this(System.out);
		this.parseDataString(results);
		this.calculateDecathlonPoints();
	}
	

	
	/**
	 *  Function to check if the given string match the double format
	 * @param number
	 * @return
	 */
	public static boolean isDouble (String number){
		
		return doMatching("^[0-9]+\\.[0-9]+$",number);	
	}
	
	/**
	 *  Function to check if the given string match the time format
	 * @param time
	 * @return
	 */
	public static boolean isTime (String time){

		return doMatching("^[0-9]*:?[0-9]+\\.[0-9]+$",time);	
	}
	
	/**
	 * Function to check if the given string match the country Code format
	 * @param code
	 * @return boolean
	 */
	public static boolean isCode(String code) {

		return doMatching("^[A-Z]{2}$",code);	
	}
	
	/**
	 *  Function to check if the given string match the date format
	 * @param date
	 * @return
	 */
	public static boolean isDate(String date) {
		
		if (doMatching("^[0-3]?[0-9]\\.[0-1]?[0-9]\\.[0-9]{4}$",date)) {
			
		String[] dateArray = date.split("\\.");
			if ((Integer.parseInt(dateArray[0])< 32) && (Integer.parseInt(dateArray[1])<13)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 *  Function to check if the given string match name format
	 * @param name
	 * @return
	 */
	public static boolean isName(String name) {
		return doMatching("[(?\\p{L}+\\s?)?]+",name);
	}

	/**
	 * Method provides an ability to do the string matching with regular expression specified.
	 * 
	 * @param regExp - regular expression to do matching
	 * @param testString - string to test for matching
	 * @return True or False depending on matching results
	 */
	public static boolean doMatching(String regExp, String testString) {
		
		Pattern testPattern = Pattern.compile(regExp);
		Matcher matcher = testPattern.matcher(testString);
		return matcher.matches();
	}
	/**
	 * Attempts to parse CSV string filled with sportsman's information 
	 * 
	 * @param results - string in CSV format filled with sportsman's information 
	 * @return True or False depending on success of parsing
	 */
	public boolean parseDataString(String results) {

		String[] resultArray = results.split("\\,");
		
		if (resultArray[0].startsWith("\"") && resultArray[0].endsWith("\"")){
			
			resultArray[0] = resultArray[0].substring(1, resultArray[0].length()-1);
		
		}
		if (!isName(resultArray[0])) {
			System.out.println("Name has invalid format! Example: \"Sihken Såhkel\"");
			return false;
		}
		if (!isDate(resultArray[1])) {
			System.out.println("Birthdate has invalid format! Example: 21.02.1982");
			return false;
		}
		if (!isCode(resultArray[2])) {
			System.out.println("Country code has invalid format! Example: EE");
			return false;
		}
		if (!isTime(resultArray[3])) {
			System.out.println("100m sprint time has invalid format! Example: 12.69 or 1:12.69");
			return false;
		}
		if (!isDouble(resultArray[4])) {
			System.out.println("Long jump distance has invalid format! Example: 12.69");
			return false;
		}
		if (!isDouble(resultArray[5])) {
			System.out.println("Short put distance has invalid format! Example: 12.69");
			return false;
		}
		if (!isDouble(resultArray[6])) {
			System.out.println("High jump distance has invalid format! Example: 12.69");
			return false;
		}
		if (!isTime(resultArray[7])) {
			System.out.println("400m sprint time has invalid format! Example: 12.69 or 1:12.69");
			return false;
		}
		if (!isTime(resultArray[8])) {
			System.out.println("110m hurdles time has invalid format! Example: 12.69 or 1:12.69");
			return false;
		}
		if (!isDouble(resultArray[9])) {
			System.out.println("Discus throw distance has invalid format! Example: 12.69");
			return false;
		}
		if (!isDouble(resultArray[10])) {
			System.out.println("Pole vault distance has invalid format! Example: 12.69");
			return false;
		}
		if (!isDouble(resultArray[11])) {
			System.out.println("Javelin throw distance has invalid format! Example: 12.69");
			return false;
		}
		if (!isTime(resultArray[12].trim())) {
			System.out.println("1500m race distance has invalid format! Example: 12.69 or 6:50.76 Aquired value is \""+resultArray[12]+"\"");
			return false;
		}
		
		this.name = resultArray[0];
		this.birthDate = resultArray[1];
		this.country = resultArray[2];
		this.sprint100mEvent = convertToSec(resultArray[3]);
		this.longJumpEvent = convertToSanti(Double.parseDouble(resultArray[4]));
		this.shotPutEvent = Double.parseDouble(resultArray[5]);
		this.highJumpEvent =  convertToSanti(Double.parseDouble(resultArray[6]));
		this.sprint400mEvent = convertToSec(resultArray[7]);
		this.hurdles110mEvent = convertToSec(resultArray[8]);
		this.discusThrowEvent = Double.parseDouble(resultArray[9]);
		this.poleVaultEvent = convertToSanti(Double.parseDouble(resultArray[10]));
		this.javelinThrowEvent = Double.parseDouble(resultArray[11]);
		this.race1500mEvent = convertToSec(resultArray[12]);
		
		return true;
	}

	public double convertToSec(String time){
		
		double minute = 0; 
		if (time.contains(":")) {
		minute = Integer.parseInt(time.substring(0, time.indexOf(":")));
		time = time.substring(time.indexOf(":")+1, time.length());
		}
		double seconds = Double.parseDouble(time);
		seconds = minute*60+seconds;
		return seconds;
	}
	
	
	/**
	 *  Function to convert meters to samntimeters
	 * @param metres
	 * @return
	 */
	public double convertToSanti(double metres){
		return 100*metres;
	}
	
	public double calcRunningEvent(double A,double B,double C,double P) {
		
		return A*Math.pow((B-P), C);
	}
	
	public double calcFieldEvent(double A,double B,double C,double P) {
		
		return A*Math.pow((P-B), C);
	}

	public void calculateDecathlonPoints() {
		
		this.points = calcRunningEvent(25.437, 18.0, 1.81, this.sprint100mEvent);
		this.points += calcFieldEvent(0.14354, 220, 1.40, this.longJumpEvent);
		this.points += calcFieldEvent( 51.39, 1.5, 1.05, this.shotPutEvent);
		this.points += calcFieldEvent(0.8465, 75, 1.42, this.highJumpEvent);
		this.points += calcRunningEvent(0.8465, 75, 1.42, this.sprint400mEvent);
		this.points += calcRunningEvent(5.74352, 28.5, 1.92, this.hurdles110mEvent);
		this.points += calcFieldEvent(12.91, 4.0, 1.1, this.discusThrowEvent);
		this.points += calcFieldEvent(0.2797, 100, 1.35, this.poleVaultEvent);
		this.points += calcFieldEvent(10.14, 7.0, 1.08, this.javelinThrowEvent);
		this.points += calcRunningEvent(0.03768, 480, 1.85, this.race1500mEvent);
	}

	public int compareTo(Object o) {
		Sportsman Person = (Sportsman) o;
		Double returnValue = this.points-Person.points;
		return returnValue.intValue();
	}
	
}

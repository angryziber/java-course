package net.azib.java.students.t040729.homework;

import java.util.Locale;

/**
 * Athlete class represents a competitor
 *
 * @author ValleTon
 */
public class Athlete implements Comparable<Athlete>{
	private Name name;
	private BirthDate birthDate;
	private Country country;
	
	private float[] results = new float[10];
	private short totalCalculatedPoints;
	private String place;
	
	/**
	 * @param name Athlete's name
	 * @param birthDate Athlete's birth date
	 * @param countryCode Athlete's country code
	 */
	public Athlete (Name name, BirthDate birthDate, Country countryCode){
		this.name = name;
		this.birthDate = birthDate;
		this.country = countryCode;
	}
	
	/**
	 * Method inserts or updates athlete's event results array.
	 * @param eventNr Determines which event's result is inserted
	 * @param eventResult Result in float
	 * @throws Exception In case of a negative result
	 */
	public void insertEventResult(byte eventNr, float eventResult) throws Exception{
		if (eventResult < 0.0f){
			throw new Exception("Negative result on event nr: "+(eventNr+1)+", athlete: "+this.getName());
		}
		results[eventNr] = eventResult;
	}
	
	/**
	 * Method retrieves appropriate result and formats it for output
	 * @param eventNr Determines which result is needed
	 * @return Formatted string depending on result type (meters, seconds)
	 */
	public String getFormattedResult(byte eventNr){
		Event[] evt = Event.values();
		Locale decimalPointLocale = new Locale("en", "US");
		if (evt[eventNr].isTrackEvent()){
			int minutes = (int) (results[eventNr]/60);
			
			if (minutes==0){
				return String.format(decimalPointLocale,"%.2f",results[eventNr]);
			}else{
				Float seconds = results[eventNr]-minutes*60;
				String secondsString = String.format(decimalPointLocale,"%.2f",seconds);;
				return String.valueOf(minutes)+":"+((seconds<10)?"0"+secondsString:secondsString);
			}
		}else{
			return String.format(decimalPointLocale,"%.2f",results[eventNr]);
		}
	}
	
	/**
	 * Calculates and sums up all athlete's points on different events
	 */
	public void calculateTotalPoints(){
		totalCalculatedPoints = 0;
		for (Event e : Event.values()){
			totalCalculatedPoints += e.calculatePoints(results[e.ordinal()]);
		}
	}
	
	/**
	 * Getter method for athlete's total points
	 * @return Athlete's total points on all events
	 */
	public short getTotalPoints(){
		return totalCalculatedPoints;
	}
	
	/**
	 * Assigns the place for atlete
	 * @param place String which represents athletes place on that competition.
	 * Type is string because 2 or more athletes can share 2 or more places.
	 */
	public void setPlace(String place){
		this.place = place;
	}
	
	/**
	 * Getter function which gives out athlete's place on that competition.
	 * @return Athlete's place in string.
	 */
	public String getPlace(){
		return (place!=null)?place:"";
	}
	
	/**
	 * @return Athlete's name in string
	 */
	public String getName(){
		return name.toString();
	}
	
	/**
	 * @return Athletes birth date
	 */
	public String getBirthDate(){
		return birthDate.toString();
	}
	
	/**
	 * @param dateFormatString Specifies returned date format
	 * @return Athletes birth date in XML compliant (or custom) string
	 * @throws Exception 
	 */
	public String getCustomBirthDate(String dateFormatString) throws Exception{
		return birthDate.getCustomDate(dateFormatString);
	}
	
	/**
	 * @return Athlete's country code
	 */
	public String getCountryCode(){
		return country.getCountryCode();
	}

	/**
	 * Compares two athlete's by their total points
	 * @param a Another athlete to compare
	 * @return negative, positive or zero depending on points
	 */
	@Override
	public int compareTo(Athlete a) {
		return a.getTotalPoints()-getTotalPoints();
	}
}

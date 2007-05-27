package net.azib.java.students.t030632.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import sun.security.pkcs.ParsingException;

/**
 * Competitor<br>
 * Calculates result from competitors results(parses result string). 
 * Result string should be input data to constructor.
 * @author Toni
 */
public class Competitor{
	private int points;
	private String name;
	private Date birthDate;
	private Locale country;
	private float sprint;/*seconds.milliseconds*/
	private float longJump;
	private float shotPut;
	private float highJump;
	private float longSprint;/*seconds.milliseconds*/
	private float hurdles;/*seconds.milliseconds*/
	private float discusThrow;
	private float poleVault;
	private float javelinThrow;
	private float race; /*seconds.milliseconds*/
	private String [] results;
	private String initialData;
	
	/**
	 * 
	 * @param competitorData string with results in csv view
	 */
	public Competitor(String competitorData) {
		initialData = competitorData;
		parseResults(competitorData);
		calculatePoints();
	}
	private void calculatePoints(){
		float points=0f;
		points+=(25.437f * Math.pow((18.0f-getSprint()), 1.81d));
		points+=(0.14354f * Math.pow((getLongJump()*100f- 220f), 1.40d));
		points+=(51.39f * Math.pow((getShotPut()- 1.5f), 1.05d));
		points+=(0.8465f * Math.pow((getHighJump()*100f- 75f), 1.42d));
		points+=(1.53775f * Math.pow((82f-getLongSprint()), 1.81d));
		points+=(5.74352f * Math.pow((28.5f-getHurdles()), 1.92d));
		points+=(12.91f * Math.pow((getDiscusThrow()- 4.0f), 1.1d));
		points+=(0.2797f * Math.pow((getPoleVault()*100f- 100f), 1.35d));
		points+=(10.14f * Math.pow((getJavelinThrow()- 7.0f), 1.08d));
		points+=(0.03768f * Math.pow((480f-getRace()), 1.85d));
		setPoints((int) points);
	}
	private void parseResults (String competitorData){
		results = competitorData.split(",");
		int index = 0;
		if(results.length>13){
			throw new NullPointerException("Invalid data, too many arguments!!!");
		}else if(results.length<13){
			throw new NullPointerException("Invalid data, too few arguments!!!");
		}else{
			setName(results[index++]);
			try {
				DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//				sdf.setCalendar(GregorianCalendar.getInstance());
				Date date = sdf.parse(results[index++]);
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTime(date);
//				todo check correctness of formatted date
				setBirthDate(date/*DateFormat.getDateInstance(DateFormat.SHORT).parse(results[index++])*/);
			}
			catch (ParseException e) {
				System.out.println("Unable to parse Date of Birth!!!");
				e.printStackTrace();
			}
			setCountry(parseLocaleString(results[index++]));
			setSprint(Float.parseFloat(results[index++]));
			setLongJump(Float.parseFloat(results[index++]));
			setShotPut(Float.parseFloat(results[index++]));
			setHighJump(Float.parseFloat(results[index++]));
			String[]longSprintS = results[index++].split(":");
			if(longSprintS.length<2){
				setLongSprint(Float.parseFloat(longSprintS[0]));
			}else{
				setLongSprint(Integer.parseInt(longSprintS[0])*60+Float.parseFloat(longSprintS[1]));
			}
			setHurdles(Float.parseFloat(results[index++]));
			setDiscusThrow(Float.parseFloat(results[index++]));
			setPoleVault(Float.parseFloat(results[index++]));
			setJavelinThrow(Float.parseFloat(results[index++]));
			String[]raceS = results[index++].split(":");
			if(raceS.length<2){
				setRace(Float.parseFloat(raceS[0]));
			}else{
				setRace(Integer.parseInt(raceS[0])*60+Float.parseFloat(raceS[1]));
			}
			
			
			
		}
		
	}
	private Locale parseLocaleString(String str){
		Locale [] locales = Locale.getAvailableLocales();
		for(Locale loc:locales){
			if(loc.getCountry().equals(str)){
				return loc;
			}
		}
		try {
			throw new ParsingException("Unknown Country abbreviation: "+str);
		}
		catch (ParsingException e) {
			System.out.println("Unable to throw Parsing Exception: Unknown Country = "+str);
			e.printStackTrace();
			return null;
		}
		 
	}
	/**
	 * @param date the birthDate to set
	 */
	private void setBirthDate(Date date) {
		this.birthDate = date;
	}
	/**
	 * @param country the country to set
	 */
	private void setCountry(Locale country) {
		this.country = country;
	}
	/**
	 * @param discusThrow the discusThrow to set
	 */
	private void setDiscusThrow(float discusThrow) {
		this.discusThrow = discusThrow;
	}
	/**
	 * @param highJump the highJump to set
	 */
	private void setHighJump(float highJump) {
		this.highJump = highJump;
	}
	/**
	 * @param hurdles the hurdles to set
	 */
	private void setHurdles(float hurdles) {
		this.hurdles = hurdles;
	}
	/**
	 * @param javelinThrow the javelinThrow to set
	 */
	private void setJavelinThrow(float javelinThrow) {
		this.javelinThrow = javelinThrow;
	}
	/**
	 * @param longJump the longJump to set
	 */
	private void setLongJump(float longJump) {
		this.longJump = longJump;
	}
	/**
	 * @param longSprint the longSprint to set
	 */
	private void setLongSprint(float longSprint) {
		this.longSprint = longSprint;
	}
	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * @param points the points to set
	 */
	private void setPoints(int points) {
		this.points = points;
	}
	/**
	 * @param poleVault the poleVault to set
	 */
	private void setPoleVault(float poleVault) {
		this.poleVault = poleVault;
	}
	/**
	 * @param race the race to set
	 */
	private void setRace(float race) {
		this.race = race;
	}
	/**
	 * @param shotPut the shotPut to set
	 */
	private void setShotPut(float shotPut) {
		this.shotPut = shotPut;
	}
	/**
	 * @param sprint the sprint to set
	 */
	private void setSprint(float sprint) {
		this.sprint = sprint;
	}
	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}
	/**
	 * @return the country
	 */
	public Locale getCountry() {
		return country;
	}
	/**
	 * @return the discusThrow
	 */
	public float getDiscusThrow() {
		return discusThrow;
	}
	/**
	 * @return the highJump
	 */
	public float getHighJump() {
		return highJump;
	}
	/**
	 * @return the hurdles
	 */
	public float getHurdles() {
		return hurdles;
	}
	/**
	 * @return the javelinThrow
	 */
	public float getJavelinThrow() {
		return javelinThrow;
	}
	/**
	 * @return the longJump
	 */
	public float getLongJump() {
		return longJump;
	}
	/**
	 * @return the longSprint
	 */
	public float getLongSprint() {
		return longSprint;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @return the poleVault
	 */
	public float getPoleVault() {
		return poleVault;
	}
	/**
	 * @return the race
	 */
	public float getRace() {
		return race;
	}
	/**
	 * @return the shotPut
	 */
	public float getShotPut() {
		return shotPut;
	}
	/**
	 * @return the sprint
	 */
	public float getSprint() {
		return sprint;
	}
	/**
	 * 
	 * @return
	 */
	/*public String returnCompetitorsData (){
		String data="";
		data="Points: "+getPoints();
		StringBuffer sb = new StringBuffer(data);
		sb.append(data).append("Points: ").append(getPoints()).append(": ").append(
				getName()).append(", ").append(
				getBirthDate()).append(", ").append(
				getCountry()).append(".");
		return sb.toString();
	}*/
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	
	public String toString() {
		DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		String data = new String();
		StringBuffer sb = new StringBuffer(data);
		sb.append(data).append("Points: ").append(
				getPoints()).append(", ").append(
				getName()).append(", ").append(
				sdf.format(getBirthDate())).append(", ").append(
				getCountry().getDisplayCountry()).append(", ").append(
				results[3]).append(", ").append(
				results[4]).append(", ").append(
				results[5]).append(", ").append(
				results[6]).append(", ").append(
				results[7]).append(", ").append(
				results[8]).append(", ").append(
				results[9]).append(", ").append(
				results[10]).append(", ").append(
				results[11]).append(", ").append(
				results[12]).append(". ");
		return sb.toString();	
	}
	/**
	 * @return initialData - string with initial results in csv format 
	 */
	public String getInitialData() {
		return initialData;
	}
}
